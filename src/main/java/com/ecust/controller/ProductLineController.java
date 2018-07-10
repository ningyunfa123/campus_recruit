package com.ecust.controller;

import com.ecust.dao.UserDao;
import com.ecust.dto.Deploy;
import com.ecust.dto.ProductAuditForm;
import com.ecust.dto.ProductInfoForm;
import com.ecust.pojo.ProductLine;
import com.ecust.pojo.User;
import com.ecust.service.ModuleDeployService;
import com.ecust.service.ProductAuditService;
import com.ecust.service.ProductLineService;
import com.ecust.utils.ProductUtil;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/productline")
public class ProductLineController {
    private final Logger logger = Logger.getLogger(ProductLineController.class);

    @Autowired
    private ProductLineService productLineService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductAuditService productAuditService;

    @Autowired
    private ModuleDeployService moduleDeployService;

    private Map<String,Object> returnResult;

    @ResponseBody
    @RequestMapping(value = "/queryallproduct",method = RequestMethod.GET)
    public Map<String, Object> queryAllProductLine(HttpServletRequest request){

        //登录校验
        HttpSession httpSession = request.getSession();
        User currentUser = (User) httpSession.getAttribute("currentUser");
        if(currentUser==null){
            returnResult = new HashMap<>();
            returnResult.put("errno","-1");
            returnResult.put("msg","用户未登录，请登录再试");
            return returnResult;
        }
        //获取数据
        returnResult = productLineService.queryAllProduct();
        if(returnResult.get("data")==null){
            returnResult.put("errmo","-2");
            returnResult.put("msg","返回结果为空");
            return returnResult;
        }else{
            returnResult.put("errno","0");
            returnResult.put("msg","success");
            return returnResult;
        }
    }

    @ResponseBody
    @RequestMapping("/addproduct")
    public Map<String,String> addProduct(HttpServletRequest request){

        String productLineName = request.getParameter("productLineName");
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        String userName = currentUser.getUserName();
        Map<String,Object> userInfo = userDao.queryUserByName(userName);
        ProductLine productLine = ProductUtil.parameterDeal(productLineName,userInfo);
        return productLineService.addProduct(productLine);
    }

    /**
     * 创建审核记录
     * @param productAuditForm
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/createauditrecord")
    public Map<String,Object> productAudit( @RequestBody @Valid ProductAuditForm productAuditForm, HttpServletRequest request) throws Exception {
        logger.error(productAuditForm.getId()+"ID");
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser == null){
            returnResult = new HashMap<>();
            returnResult.put("errno","-2");
            returnResult.put("msg","用户未登录");
            return returnResult;
        }
        if(productAuditForm.getReason()=="" || productAuditForm.getApplyTime()=="" || productAuditForm.getProductName()=="" || productAuditForm.getType() =="" ||
                productAuditForm.getReason()=="-1" || productAuditForm.getApplyTime()=="-1" || productAuditForm.getProductName()=="-1"){
            returnResult = new HashMap<>();
            returnResult.put("errno","-2");
            returnResult.put("msg","参数不能为空");
            return returnResult;
        }
        Integer userId = currentUser.getId();
        String userName = currentUser.getUserName();
        productAuditForm.setUserId(userId.toString());
        productAuditForm.setUserName(userName);

        return productAuditService.createAuditRecord(productAuditForm);
    }

    /**
     * 跳转模块审核页面
     * @return
     */
    @RequestMapping(value = "/productauditpage",method = RequestMethod.GET)
    public String productAuditPage(){

        return "/audit/productaudit";
    }

    /**
     * 跳转模块部署页面
     * @return
     */
    @RequestMapping(value = "prodecudeployment",method = RequestMethod.GET)
    public String productDeploymentPage(){
        return "/deployment1/productdeploy";
    }

    @ResponseBody
    @RequestMapping("/queryrecord")
    public Map<String,Object> queryRecordByUserId(HttpServletRequest request,@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
        if(pageNo<=0 || pageSize<=0){
            returnResult = new HashMap<>();
            returnResult.put("errno","-1");
            returnResult.put("msg","页面格式错误");
            return returnResult;
        }
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser == null){
            returnResult = new HashMap<>();
            returnResult.put("errno","-2");
            returnResult.put("msg","用户未登录");
            return returnResult;
        }
        int userId = currentUser.getId();
        returnResult = productAuditService.queryRecordByUserId(pageNo,pageSize,userId);
        returnResult.put("errno","0");
        returnResult.put("msg","获取数据成功");
        return returnResult;
    }

    /**
     * 获取用户有权限的模块
     */
    @ResponseBody
    @RequestMapping("/queryproductbyuseridandauditstatus")
    public Map<String,Object> queryProductByUserIdAndAuditStatus(@RequestParam("auditStatus") int auditStatus,HttpServletRequest request){
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser.getId() == null){
            returnResult = new HashMap<>();
            returnResult.put("errno","-2");
            returnResult.put("msg","用户未登录");
            return returnResult;
        }
        int userId = currentUser.getId();
        returnResult = productAuditService.queryProductByUserIdAndAuditStatus(userId,auditStatus);
        return returnResult;
    }

    /**
     * 获取分支信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/getbranchinfo")
    public Map<String,Object> getBranchInfo(@RequestBody ProductInfoForm productInfoForm) throws IOException {
        String productName = productInfoForm.getProductName();
        String pipeLineName = productInfoForm.getPipeLineName();
        //String productName1 = URLDecoder.decode(productName,"UTF-8");
        //String pipeLineName1 = URLDecoder.decode(pipeLineName,"UTF-8");

        return moduleDeployService.getBranchInfo(productName,pipeLineName);
    }

    /**
     * 模块部署
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/deploy",method = RequestMethod.POST)
    public Map<String,Object> deploy(@RequestBody Deploy deploy) throws IOException {
        String productName = deploy.getProductName();
        String pipeLineName = deploy.getPipeLineName();
        String branch = deploy.getBranch();
        return moduleDeployService.deploy(productName,pipeLineName,branch);
    }
}
