package com.ecust.service.impl;

import com.ecust.dao.ProductLineDao;
import com.ecust.pojo.BuildInfo;
import com.ecust.pojo.ModuleInfo;
import com.ecust.pojo.PipelineInfo;
import com.ecust.service.ModuleDeployService;
import com.ecust.utils.ModuleDeploy.HttpGet;
import com.ecust.utils.ModuleDeploy.HttpPost;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
@Service
public class ModuleDeployServiceImpl implements ModuleDeployService {

    @Autowired
    ProductLineDao productLineDao;
    @Override
    public Map<String,Object> deploy(String productName, String pipelineName, String branch) throws IOException {
        Map<String,Object> productResult = productLineDao.queryProductByName(productName);
        Map<String,Object> returnResult = new HashMap<>();
        if(productResult.get("productpath") == null || productResult.get("productpath") =="" ){
            returnResult.put("errno","-1");
            returnResult.put("msg","获取DB模块信息失败");
            return returnResult;
        }
        String productPath = (String) productResult.get("productpath");
        //从配置文件获取coolie
        Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("/cookie.properties"));
        String agileCookie = properties.getProperty("agile.baidu.com");
        //根据模块路径获取pipeline信息
        String pipeLineUrl = "http://agile.baidu.com/agile/pipelineConf/getPipelineBranchInfo";
        String pipeLineParam = "module="+productPath;
        String pipelineResp = HttpGet.httpGet(pipeLineUrl,pipeLineParam,agileCookie);
        if(pipelineResp == "请求失败"){
            //Map<String,Object> returnResult = new HashMap<>();
            returnResult.put("errno","-2");
            returnResult.put("msg","该pipeLine信息不存在");
            return returnResult;
        }
        //数据转换
        JSONArray jArray = JSONArray.fromObject(pipelineResp);
        Collection collection = JSONArray.toCollection(jArray,PipelineInfo.class);
        List<PipelineInfo> pipelineInfos = new ArrayList<>();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            PipelineInfo pipelineInfo = (PipelineInfo) it.next();
            pipelineInfos.add(pipelineInfo);
        }
        Integer pipeLineId=null;
        //获取pipeLineConfigId
        for (PipelineInfo tempPipelineInfo:pipelineInfos) {
            if(tempPipelineInfo.getName()==pipelineName){
                pipeLineId = tempPipelineInfo.getId();
                break;
            }
        }
        if(pipeLineId == null){
            //Map<String,Object> returnResult = new HashMap<>();
            returnResult.put("errno","-1");
            returnResult.put("msg","pipeLineId数据异常");
            return returnResult;
        }
        //获取模块信息
        String moduleUrl = "http://agile.baidu.com/agile/pipeline/getPipelineBuilds";
        String moduleParam = "pipelineConfId="+pipeLineId+"&branch="+branch+"&offset=0&limit=1";
        String moduleResp = HttpGet.httpGet(moduleUrl,moduleParam,agileCookie);
        if(moduleResp =="请求失败"){
            //Map<String,Object> returnResult = new HashMap<>();
            returnResult.put("errno","-2");
            returnResult.put("msg","模块信息不存在");
            return returnResult;
        }
        //数据转换
        JSONArray moduleJArray = JSONArray.fromObject(moduleResp);
        Collection moduleCollection = JSONArray.toCollection(moduleJArray,ModuleInfo.class);
        List<ModuleInfo> moduleInfos = new ArrayList<>();
        Iterator moduleIt = moduleCollection.iterator();
        while (moduleIt.hasNext()) {
            ModuleInfo moduleInfo = (ModuleInfo) moduleIt.next();
            moduleInfos.add(moduleInfo);
        }
        //获取triggerId和complieBuildId
        Integer compileBuildId = moduleInfos.get(0).getCompileBuildId();
        Integer triggerId = moduleInfos.get(0).getTriggerId();
        if(compileBuildId == null || triggerId == null){
            //Map<String,Object> returnResult = new HashMap<>();
            returnResult.put("errno","-2");
            returnResult.put("msg","获取compliebuildId或者triggerId失败");
            return returnResult;
        }
        //获取构建信息
        //tofo 1 获取构建信息，2 请求nminst平台进行环境部署3 新增测试机配置文件
        //http://agile.baidu.com/agile/commitInfo?triggerId=10007021&compileBuildId=10242727&isGitModule=true
        String buildUrl = "http://agile.baidu.com/agile/commitInfo";
        String buildParam = "triggerId="+triggerId+"&compileBuildId="+compileBuildId+"&isGitModule=true";
        String buildResp = HttpGet.httpGet(buildUrl,buildParam,agileCookie);
        if(buildResp == "请求失败"){
            //Map<String,Object> returnResult = new HashMap<>();
            returnResult.put("errno","-2");
            returnResult.put("msg","该构建信息不存在");
            return returnResult;
        }
        //json转java bean
        JSONObject jsonBuildResp = JSONObject.fromObject(buildResp);
        BuildInfo buildInfo = (BuildInfo) JSONObject.toBean(jsonBuildResp,BuildInfo.class);
        //获取编译信息
        String buildResult = buildInfo.getBuildResult();
        if(buildResult == "" || buildResult == null ){
            //Map<String,Object> returnResult = new HashMap<>();
            returnResult.put("errno","-2");
            returnResult.put("msg","构建url输出不存在");
            return returnResult;
        }
        //请求nminst进性构建
        properties.load(this.getClass().getResourceAsStream("/testserver.properties"));
        properties.load(this.getClass().getResourceAsStream("/module.properties"));
        String machine_host = properties.getProperty("machine_host");
        String machine_user = properties.getProperty("machine_user");
        String machine_passwd = properties.getProperty("machine_passwd");
        String user = properties.getProperty("user");
        String module_name = properties.getProperty(productPath);
        String env = properties.getProperty("env");
        String source = buildResult;
        String deployParam = "machine_host="+machine_host+"&machine_user="+machine_user+"&machine_passwd="+machine_passwd+"&user="+user+"&module_name="+module_name+
                "&env="+env+"&source="+source;
        String deployUrl = "http://nminst.baidu.com/nminst/createenv";
        String deployCookie = properties.getProperty("nminst.baidu.com");
        String deployResult = HttpPost.httpPost(deployUrl,deployParam,deployCookie);
        if(deployResult == "请求失败"){
            //Map<String,Object> returnResult = new HashMap<>();
            returnResult.put("errno","-1");
            returnResult.put("msg","请求nminst代码部署失败");
            return returnResult;
        }
        JSONObject deployJsonResult = JSONObject.fromObject(deployResult);
        int errNo = (int) deployJsonResult.get("errno");
        if(errNo == 0){
            //Map<String,Object> returnResult = new HashMap<>();
            returnResult.put("errno","0");
            returnResult.put("msg","success");
            return returnResult;
        }else{
            //Map<String,Object> returnResult = new HashMap<>();
            returnResult.put("errno","-1");
            returnResult.put("msg","代码部署失败");
            return returnResult;
        }
    }
}
