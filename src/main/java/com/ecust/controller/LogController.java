package com.ecust.controller;

import com.ecust.service.LogService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ningyunfa on 2017/10/19.
 */
@Controller
@RequestMapping("/log")
public class LogController {
    Logger logger = Logger.getLogger(LogController.class);
    @Autowired
    LogService logService;
    @ResponseBody
    @RequestMapping(value="/addlog",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public boolean addLog(@RequestParam("logShow") String show){
        logger.error(show);
        return logService.addLog(show);
    }
    @ResponseBody
    @RequestMapping(value="/queryalllog",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String,Object> queryAllLog(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize){

        if(pageNo<=0 || pageSize<=0){
            Map<String,Object> result = new HashMap<>();
            result.put("errNo","-1");
            result.put("errMsg","页面格式错误");
            return result;
        }
        Map<String,Object> returnResult = logService.queryAllLog(pageNo,pageSize);
        if(returnResult.get("data")==null){
            returnResult.put("errNo","-2");
            returnResult.put("errMsg","返回结果为空");
            return returnResult;
        }else{
            returnResult.put("errNo","0");
            returnResult.put("errMsg","success");
            return returnResult;
        }
    }
}
