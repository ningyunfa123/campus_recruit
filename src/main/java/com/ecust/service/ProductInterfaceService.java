package com.ecust.service;

import com.ecust.pojo.ProductInterface;

import java.util.Map;

public interface ProductInterfaceService {
    Map<String,Object> queryAllProductInterface(int pageNo,int pageSize);
    Map<String,String> addInterface(ProductInterface productInterface);
    Map<String,Object> queryInterfaceByProductId(int pageNo,int pageSize, int productId);
    Map<String,Object> queryInterfaceById(int id);
    Map<String, Object> updateInteface(ProductInterface productInterface);
    Map<String,Object> queryInterfaceByProductIdAndInterfaceName(int pageNo,int pageSize,String interfaceName, int productId);
}
