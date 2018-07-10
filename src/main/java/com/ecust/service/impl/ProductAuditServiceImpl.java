package com.ecust.service.impl;

import com.ecust.dao.ProductAuditDao;
import com.ecust.dao.ProductLineDao;
import com.ecust.dto.ProductAuditForm;
import com.ecust.pojo.Page;
import com.ecust.pojo.ProductAudit;
import com.ecust.service.ProductAuditService;
import com.ecust.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductAuditServiceImpl implements ProductAuditService {

    @Autowired
    ProductAuditDao productAuditDao;

    @Autowired
    ProductLineDao productLineDao;
    /**
     * 创建审核记录
     * @param productAuditForm
     * @return
     */
    @Override
    public Map<String, Object> createAuditRecord(ProductAuditForm productAuditForm) throws Exception {

        Map<String,Object> result = new HashMap<>();
        int userId = Integer.valueOf(productAuditForm.getUserId());
        Map<String,Object> productResult = productLineDao.queryProductByName(productAuditForm.getProductName());
        productAuditForm.setProductId(productResult.get("id").toString());
        int productId = Integer.valueOf(productAuditForm.getProductId());
        Map<String,Object> dbResult = productAuditDao.queryAuditRecordByProductIdAndUserId(productId,userId);
        if(dbResult != null){
            int status = (int) dbResult.get("auditstatus");
            if( status == 0 ){
                result.put("errno","-1");
                result.put("msg","该模块正在审核中，请勿重复提交");
                return result;
            } else if (status == 1){
                result.put("errno","-1");
                result.put("msg","该模块已审核通过，无需重新审核");
                return result;
            }else if (status == 2){
                ProductAudit productAudit  = new ProductAudit();
                productAudit.setApplytime(Integer.valueOf(productAuditForm.getApplyTime()));
                productAudit.setType(Integer.valueOf(productAuditForm.getType()));
                productAudit.setReason(productAuditForm.getReason());
                productAudit.setUserid(Integer.valueOf(productAuditForm.getUserId()));
                productAudit.setProductid(Integer.valueOf(productAuditForm.getProductId()));
                productAudit.setAuditstatus(0);
                productAuditDao.updateAuditStatus(productAudit);
                result.put("errno","0");
                result.put("msg","审核已提交，注意审核理由书写");
                return result;
            }else{
                throw new Exception("status error");
            }
        }else{
            ProductAudit productAudit  = new ProductAudit();
            productAudit.setProductid(productId);
            productAudit.setUserid(userId);
            productAudit.setUsername(productAuditForm.getUserName());
            productAudit.setProductname(productAuditForm.getProductName());
            productAudit.setReason(productAuditForm.getReason());
            productAudit.setType(Integer.valueOf(productAuditForm.getType()));
            productAudit.setApplytime(Integer.valueOf(productAuditForm.getApplyTime()));
            productAuditDao.createAuditRecord(productAudit);
            result.put("errno","0");
            result.put("msg","success");
            return  result;
        }
    }

    @Override
    public Map<String, Object> queryRecordByUserId(int pageNo,int pageSize,int userId) {
        Page page = new Page();
        if (page.getPageNo() == null && page.getPageSize() == null) {
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);
        } else {
            page.setPageNo(1);
            page.setPageSize(10);
        }
        PageUtils.page(page);
        List<Map<String,Object>> result = productAuditDao.queryRecordByUserId(userId);
        return PageUtils.proccess(result);
    }

    @Override
    public Map<String, Object> queryProductByUserIdAndAuditStatus(int userId, int AuditStatus) {
        List<Map<String,Object>> dbResult = productAuditDao.queryProductByUserIdAndAuditStatus(userId,AuditStatus);
        Map<String,Object> returnResult = new HashMap<>();
        returnResult.put("data",dbResult);
        returnResult.put("errno","0");
        returnResult.put("msg","success");
        return returnResult;
    }
}
