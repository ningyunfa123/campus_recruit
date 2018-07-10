package com.ecust.service;

import com.ecust.dto.ProductAuditForm;

import java.util.Map;

public interface ProductAuditService {

    Map<String,Object> createAuditRecord(ProductAuditForm productAuditForm) throws Exception;
    Map<String,Object> queryRecordByUserId(int pageNo,int pageSize,int userId);
    Map<String,Object> queryProductByUserIdAndAuditStatus(int userId,int AuditStatus);
}
