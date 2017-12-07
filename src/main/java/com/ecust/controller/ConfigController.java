package com.ecust.controller;

import com.ecust.dto.ConfigForm;
import com.ecust.pojo.Config;
import com.ecust.service.ConfigService;
import com.ecust.utils.DataTrans;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;


/**
 * Created by ningyunfa on 2017/9/11.
 */
@Controller
@RequestMapping("config")
public class ConfigController {
    @Autowired
    private ConfigService configService;
    private Logger logger = Logger.getLogger(ConfigController.class);
    @ResponseBody
    @RequestMapping(value="/saveConfig",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public boolean saveConfig(@RequestBody ConfigForm configForm) throws IOException {
        logger.error(configForm.getUriConfig());
        Config config = DataTrans.transToConfig(configForm);
        return configService.saveConfig(config);
    }

    @ResponseBody
    @RequestMapping(value = "/queryConfig", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String,String> queryConfig(@RequestBody Map<String,String> param){
        int pageNumber = Integer.parseInt(param.get("pageNumber"));
        int pageSize = Integer.parseInt(param.get("pageSize"));
        return null;
    }
}
