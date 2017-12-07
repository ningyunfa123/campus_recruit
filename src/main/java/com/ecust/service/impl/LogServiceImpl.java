package com.ecust.service.impl;

import com.ecust.dao.LogDao;
import com.ecust.pojo.Page;
import com.ecust.service.LogService;
import com.ecust.utils.PageUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by ningyunfa on 2017/10/19.
 */
@Service
public class LogServiceImpl implements LogService {
    Logger logger = Logger.getLogger(LogServiceImpl.class);
    @Autowired
    LogDao logDao;
    @Override
    public boolean addLog(String show) {
        try{
            logger.error("comehere");
            logDao.addLog(show);
        }catch(Exception e){
            e.getStackTrace();
        }
        logger.error("addlogsuccess");
        return true;
    }

    @Override
    public Map<String, Object> queryAllLog(int pageNo, int pageSize) {
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
        List<Map<String, Object>> result = logDao.queryAllLog();
        return PageUtils.proccess(result);
    }
}
