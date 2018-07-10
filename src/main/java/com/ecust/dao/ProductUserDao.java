package com.ecust.dao;

import com.ecust.pojo.ProductUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductUserDao {
    List<Map<String,Object>> queryUserByProduct(@Param("productid") int productId);
    List<Map<String,Object>> queryProductByUser(@Param("userid") int userId);
    Map<String,Object> queryByProductAndUser(@Param("productid") int product,@Param("userid") int userId);
    void addData(ProductUser productUser);
    void modifyDATA(ProductUser productUser);
    void modifyStatus(@Param("status") int status,@Param("id") int id);
}
