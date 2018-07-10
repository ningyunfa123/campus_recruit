package com.ecust.service;

import com.ecust.pojo.ProductLine;

import java.util.List;
import java.util.Map;

public interface ProductLineService {

    Map<String,Object> queryAllProduct();
    Map<String,String> addProduct(ProductLine productLine);
}
