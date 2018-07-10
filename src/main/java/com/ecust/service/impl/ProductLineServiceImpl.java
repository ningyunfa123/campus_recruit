package com.ecust.service.impl;

import com.ecust.dao.ProductLineDao;
import com.ecust.pojo.Page;
import com.ecust.pojo.ProductLine;
import com.ecust.service.ProductLineService;
import com.ecust.utils.PageUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductLineServiceImpl implements ProductLineService {
    //获取日志对象
   // Logger logger = Logger.getLogger(LogServiceImpl.class);

    @Autowired
    ProductLineDao productLineDao;

    @Override
    public Map<String, Object> queryAllProduct() {
        Map<String,Object> returnResult = new HashMap<>();
        //List<Map<String, Object>> result = logDao.queryAllLog();
        List<Map<String, Object>> result  = productLineDao.queryAllProduct();
        returnResult.put("data",result);
        return returnResult;
    }

    @Override
    public Map<String,String> addProduct(ProductLine productLine) {

        Map<String,Object> dbresultByNameAndUserId = productLineDao.queryProductByNameAndUserId(productLine.getProductname(),productLine.getUserid());
        Map<String,Object> dbresultByName = productLineDao.queryProductByName(productLine.getProductname());
        Map<String,String> returnResult = new HashMap();
        if(dbresultByNameAndUserId==null && dbresultByName==null){
            try{
                productLineDao.addProduct(productLine);
                returnResult.put("errno","0");
                returnResult.put("msg","success");
                return returnResult;
            }catch(Exception e){
                e.printStackTrace();
                throw e;
            }

        }else if(dbresultByNameAndUserId==null && dbresultByName!=null){
            returnResult.put("errno","-2");
            returnResult.put("msg","产品已存在，可能你没有权限访问");
            return returnResult;
        }else {
            returnResult.put("errno", "-1");
            returnResult.put("msg", "产品已存在");
            return returnResult;
        }
    }
}

