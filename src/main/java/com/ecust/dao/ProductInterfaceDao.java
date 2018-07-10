package com.ecust.dao;

import com.ecust.pojo.ProductInterface;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductInterfaceDao {
    List<Map<String,Object>> queryAllInterface();
    void addInterface(ProductInterface productInterface);
    Map<String,Object> querInterfaceByProductIdAndInterfaceName(@Param("productid") int productid, @Param("interfacename") String interfacename);
    List<Map<String,Object>> queryInterfaceByProductId(@Param("productId") int productId);
    Map<String,Object> queryInterfaceById(@Param("id") int id);
    void updateInterface(ProductInterface productInterface);

}
