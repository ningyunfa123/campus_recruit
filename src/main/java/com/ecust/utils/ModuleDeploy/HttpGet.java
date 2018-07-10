package com.ecust.utils.ModuleDeploy;

import com.ecust.pojo.BranchInfo;
import com.ecust.pojo.ModuleInfo;
import com.ecust.pojo.PipelineInfo;
import com.ecust.pojo.Test;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class HttpGet {
    public static String httpGet(String url,String params,String cookie) throws IOException {
        StringBuilder response = new StringBuilder();
        String finalUrl = url+"?"+params;
        URL httpurl = new URL(finalUrl);
        HttpURLConnection con = (HttpURLConnection) httpurl.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Cookie",cookie);
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.62 Safari/537.36");
        con.setRequestProperty("Accept", "application/json, text/plain, */*");
        con.connect();
        if(con.getResponseCode() == 200){
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {// 循环读取流
                response.append(line);
            }
            br.close();
        }else{
            response.append("请求失败");
        }


        return response.toString();

    }
    public static void main(String[] args) throws IOException {
        String url = "http://agile.baidu.com/agile/commitInfo";
        String param = "triggerId=10112775&compileBuildId=10344086&isGitModule=true";
        String cookie ="BIDUPSID=7C8A2602CE84A9E7A83BC07425D4949C; PSTM=1527658548; BAIDUID=E1DFE3C4DDD7BA176FDAFD9D84CBA035:FG=1; BDUSS=ZhVkxneFp5M09nVFN1VjFyQk1xMnVHTkxmTmdpWkNJS05FVmp3bDhwTEt6bEpiQVFBQUFBJCQAAAAAAAAAAAEAAADIRJcfusO6w7XEusMxMjMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMpBK1vKQStbVl; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; SESSION=12f708c7-f19b-496d-9e60-1935719c3cdb; Hm_lvt_af7062a9f07c74788ac9c77dd860b064=1529547328,1529633711,1529898472,1529983045; m_name=\"baidu%2Ftrade%2Fpay-platform\"; Hm_lpvt_af7062a9f07c74788ac9c77dd860b064=1529990426";
        String pipelineResp = httpGet(url,param,cookie);
        //数据转换
        //json转java bean
        JSONObject jsonBuildResp = JSONObject.fromObject(pipelineResp);
        //BuildInfo buildInfo = (BuildInfo) JSONObject.toBean(jsonBuildResp,BuildInfo.class);
        //获取编译信息
        String buildResult = (String) jsonBuildResp.get("buildResult");
        System.out.println(buildResult);

    }
}
