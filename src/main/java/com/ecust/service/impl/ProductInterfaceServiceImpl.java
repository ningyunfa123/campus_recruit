package com.ecust.service.impl;

import com.ecust.dao.ProductInterfaceDao;
import com.ecust.pojo.Page;
import com.ecust.pojo.ProductInterface;
import com.ecust.service.ProductInterfaceService;
import com.ecust.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

@Service
public class ProductInterfaceServiceImpl implements ProductInterfaceService {

    private Logger logger = Logger.getLogger(ProductInterfaceServiceImpl.class);
    @Autowired
    ProductInterfaceDao productInterfaceDao;

    /**
     * 获取所有有效接口信息
     * @param pageNo
     * @param pageSize
     * @return
     *
     */
    @Override
    public Map<String, Object> queryAllProductInterface(int pageNo,int pageSize) {
        // 分页，并判断分页参数是否存在
        Page page = new Page();
        if (page.getPageNo() == null && page.getPageSize() == null) {
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);
        } else {
            page.setPageNo(1);
            page.setPageSize(10);
        }
        PageUtils.page(page);
        //Map<String,Object> returnResult = new HashMap<>();
        //List<Map<String, Object>> result = logDao.queryAllLog();
        List<Map<String, Object>> result  = productInterfaceDao.queryAllInterface();
        //returnResult.put("data",result);
        return PageUtils.proccess(result);
    }

    /**
     * 新增接口
     * @param productInterface
     * @return
     */
    @Override
    public Map<String, String> addInterface(ProductInterface productInterface) {
        Map<String,String> result = new HashMap<>();
        int productId = productInterface.getProductid();
        logger.debug("productId:"+productId);
        String interfaceName = productInterface.getInterfacename();
        if(productInterfaceDao.querInterfaceByProductIdAndInterfaceName(productId,interfaceName)==null){
            productInterfaceDao.addInterface(productInterface);
            result.put("errno","0");
            result.put("msg","success");
            return result;
        }else{
            result.put("errno","-1");
            result.put("msg","接口已存在");
            return result;
        }


    }

    /**
     * 获取模块中所有接口
     * @param pageNo
     * @param pageSize
     * @param productId
     * @return
     */
    @Override
    public Map<String, Object> queryInterfaceByProductId(int pageNo, int pageSize, int productId) {
        Page page = new Page();
        if (page.getPageNo() == null && page.getPageSize() == null) {
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);
        } else {
            page.setPageNo(1);
            page.setPageSize(10);
        }
        PageUtils.page(page);
        List<Map<String, Object>> result  = productInterfaceDao.queryInterfaceByProductId(productId);
        return PageUtils.proccess(result);
    }

    /**
     * 查找单个接口
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> queryInterfaceById(int id) {
        Map<String,Object> result = productInterfaceDao.queryInterfaceById(id);
        if(result !=null){
            result.put("errno","0");
            result.put("msg","success");
            return result;
        }else{
            result.put("errno","-2");
            result.put("msg","数据返回空，请确认该接口是否存在");
            return result;
        }
    }

    /**
     * 更新接口信息
     * @param productInterface
     * @return
     */
    @Override
    public Map<String, Object> updateInteface(ProductInterface productInterface) {
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> interfaceInfo = productInterfaceDao.queryInterfaceById(productInterface.getId());
        if(interfaceInfo==null){
            result.put("errno","-2");
            result.put("msg","没有改接口信息，请重试！");
            return result;
        }else{
            productInterfaceDao.updateInterface(productInterface);
            result.put("errno","0");
            result.put("msg","success");
            return result;
        }
    }

    @Override
    public Map<String, Object> queryInterfaceByProductIdAndInterfaceName(int pageNo, int pageSize, String interfaceName, int productId) {
        Page page = new Page();
        List<Object> list = new ArrayList<>();
        if (page.getPageNo() == null && page.getPageSize() == null) {
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);
        } else {
            page.setPageNo(1);
            page.setPageSize(10);
        }
        PageUtils.page(page);
        Map<String,Object> result = productInterfaceDao.querInterfaceByProductIdAndInterfaceName(productId,interfaceName);
        list.add(result);
        return PageUtils.proccess(list);
    }
}
