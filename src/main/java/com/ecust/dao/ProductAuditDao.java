package com.ecust.dao;

import com.ecust.pojo.ProductAudit;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductAuditDao {
    void createAuditRecord(ProductAudit productAudit);
    Map<String,Object> queryAuditRecordByProductIdAndUserId(@Param("productid") int productid,@Param("userid") int userid);
    void updateAuditStatus(ProductAudit productAudit);
    List<Map<String,Object>> queryRecordByUserId(@Param("userid") int userid);
    List<Map<String,Object>> queryProductByUserIdAndAuditStatus(@Param("userid") int userid,@Param("auditstatus") int auditstatus);
}
