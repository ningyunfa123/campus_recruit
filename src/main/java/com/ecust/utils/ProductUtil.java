package com.ecust.utils;

import com.ecust.pojo.ProductLine;

import java.util.Map;

public class ProductUtil {


    //数据整理
    public static ProductLine parameterDeal(String productLineName, Map<String,Object> userInfo){

        ProductLine productLine = new ProductLine();
        productLine.setProductname(productLineName);
        productLine.setUserid((Integer) userInfo.get("id"));
        productLine.setUsername((String) userInfo.get("userName"));


        return productLine;
    }
}
