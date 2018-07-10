package com.ecust.dao;

import com.ecust.pojo.ProductLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductLineDao {
    List<Map<String,Object>> queryAllProduct();
    void addProduct(ProductLine productLine);
    Map<String,Object> queryProductByNameAndUserId(@Param("productName") String productName,@Param("userId") int userId);
    Map<String,Object> queryProductByName(@Param("productName") String productName);
}
