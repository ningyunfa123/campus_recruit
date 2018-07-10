package com.ecust.controller;


import com.ecust.dto.ProductInterfaceForm;
import com.ecust.pojo.ProductInterface;
import com.ecust.pojo.User;
import com.ecust.service.ProductInterfaceService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

@Controller
@RequestMapping("/interface")
public class ProductInterfaceController {

    private Logger logger = Logger.getLogger(ProductInterfaceController.class);
    @Autowired
    ProductInterfaceService productInterfaceService;

    @ResponseBody
    @RequestMapping(value="/queryallinterface", method = RequestMethod.POST)
    public Map<String,Object> queryAllProductInterface(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize){

        if(pageNo<=0 || pageSize<=0){
            Map<String,Object> result = new HashMap<>();
            result.put("errno","-1");
            result.put("msg","页面格式错误");
            return result;
        }
        Map<String,Object> returnResult = productInterfaceService.queryAllProductInterface(pageNo,pageSize);
        logger.error(returnResult);
        if(returnResult.get("data")==null){
            returnResult.put("errno","-2");
            returnResult.put("msg","返回结果为空");
            return returnResult;
        }else{
            returnResult.put("errno","0");
            returnResult.put("msg","success");
            return returnResult;
        }
    }
    @ResponseBody
    @RequestMapping(value="/addinterface",method = RequestMethod.POST)
    public Map<String,String> addInterface(@RequestBody @Validated ProductInterfaceForm productInterfaceForm, HttpServletRequest request){
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        Map<String,String> result = new HashMap<>();
        logger.debug("cometohere");
        if(currentUser == null){
            result.put("errno","-2");
            result.put("msg","用户未登录，请登录后再试");
            return result;
        }
        if(org.apache.commons.lang.StringUtils.isEmpty(productInterfaceForm.getProductId())){
            result.put("errno","-3");
            result.put("msg","productId不能为空");
            return result;
        }
        ProductInterface productInterface = new ProductInterface();
        productInterface.setProductid(Integer.valueOf(productInterfaceForm.getProductId()));
        productInterface.setInterfacename(productInterfaceForm.getInterfaceName());
        productInterface.setInterfaceparam(productInterfaceForm.getInterfaceParam());
        productInterface.setInterfacepath(productInterfaceForm.getInterfacePath());
        productInterface.setInterfaceresponse(productInterfaceForm.getInterfaceResponse());
        productInterface.setRequeststype(productInterfaceForm.getRequestsType());
        productInterface.setParamexam(productInterfaceForm.getParamExam());
        result = productInterfaceService.addInterface(productInterface);
        logger.debug("result:"+result);
        return result;
    }

    @RequestMapping(value = "/getinterfacepage",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getIntefacePage(@RequestParam("productId") String productid,HttpServletRequest request){
        request.setAttribute("productId",productid);
        HttpSession httpSession = request.getSession();
        User currentUser = (User) httpSession.getAttribute("currentUser");
        if(currentUser == null){
            return "/error";
        }
        httpSession.setAttribute("productId",productid);
        logger.error("productId:"+productid);
        return "/interface/allinterface";
    }

    @ResponseBody
    @RequestMapping(value = "queryinterfacebyproductid",method = RequestMethod.POST)
    public Map<String,Object> queryInterfaceByProductId(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize,@RequestParam("productId") String productId,@RequestParam("interfaceName") String interfaceName){
        logger.error("nextProductId"+productId);
        Map<String,Object> returnResult = new HashMap<>();
        if(pageNo<=0 || pageSize<=0){
            returnResult.put("errno","-1");
            returnResult.put("msg","页面格式错误");
            return returnResult;
        }

        if(StringUtils.isEmpty(interfaceName)){
            returnResult = productInterfaceService.queryInterfaceByProductId(pageNo,pageSize,Integer.valueOf(productId));
        }else
            returnResult = productInterfaceService.queryInterfaceByProductIdAndInterfaceName(pageNo,pageSize,interfaceName,Integer.valueOf(productId));
        logger.error(returnResult);
        if(returnResult.get("data")==null){
            returnResult.put("errno","-2");
            returnResult.put("msg","返回结果为空");
            return returnResult;
        }else{
            returnResult.put("errno","0");
            returnResult.put("msg","success");
            return returnResult;
        }
    }

    @ResponseBody
    @RequestMapping("/queryinterfacebyid")
    public Map<String,Object> queryInterfaceById(@RequestParam("interfaceId") String interfaceId){
        int id = Integer.valueOf(interfaceId);
        return productInterfaceService.queryInterfaceById(id);

    }

    @ResponseBody
    @RequestMapping(value = "/updateinterface",method =RequestMethod.POST)
    public Map<String,Object> updateInterface(@RequestBody ProductInterfaceForm productInterfaceForm,HttpServletRequest request){
        HttpSession session = request.getSession();
        Map<String,Object> result = new HashMap<>();

        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser ==null){
            result.put("errno","-1");
            result.put("msg","用户未登录");
            return result;
        }else{
            if(StringUtils.isEmpty(productInterfaceForm.getId())){
                result.put("errno","-3");
                result.put("msg","interfaceId不能为空");
                return result;
            }
            if(StringUtils.isEmpty(productInterfaceForm.getInterfaceName())){
                result.put("errno","-3");
                result.put("msg","interfaceName不能为空");
                return result;
            }
            if(StringUtils.isEmpty(productInterfaceForm.getInterfaceParam())){
                result.put("errno","-3");
                result.put("msg","interfaceParam不能为空");
                return result;
            }
            if(StringUtils.isEmpty(productInterfaceForm.getRequestsType())){
                result.put("errno","-3");
                result.put("msg","requestType不能为空");
                return result;
            }
            if(StringUtils.isEmpty(productInterfaceForm.getInterfacePath())){
                result.put("errno","-3");
                result.put("msg","interfacePath不能为空");
                return result;
            }
            logger.error("parameters:"+productInterfaceForm.getId()+","+productInterfaceForm.getRequestsType()+","+productInterfaceForm.getInterfaceParam());
            ProductInterface productInterface = new ProductInterface();
            productInterface.setRequeststype(productInterfaceForm.getRequestsType());
            productInterface.setId(Integer.valueOf(productInterfaceForm.getId()));
            productInterface.setInterfaceresponse(productInterfaceForm.getInterfaceResponse());
            productInterface.setInterfacepath(productInterfaceForm.getInterfacePath());
            productInterface.setInterfaceparam(productInterfaceForm.getInterfaceParam());
            productInterface.setInterfacename(productInterfaceForm.getInterfaceName());
            productInterface.setParamexam(productInterfaceForm.getParamExam());
            return productInterfaceService.updateInteface(productInterface);
        }
    }

}
