package com.ecust.utils;

import com.ecust.dto.CompanyForm;
import com.ecust.dto.ConfigForm;
import com.ecust.pojo.Company;
import com.ecust.pojo.Config;
import com.ecust.pojo.RUser;
import com.ecust.pojo.User;
import com.google.common.collect.Maps;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cheng on 2017/8/18.
 */
public class DataTrans {
    private static Logger logger = Logger.getLogger(DataTrans.class);
    public static Company toCompany(CompanyForm companyForm) {
        Company company = new Company();
        company.setName(companyForm.getName());
        company.setPosition(companyForm.getPosition());
        company.setLink((companyForm.getLink()=="" || companyForm.getLink()== null )?"δ֪":companyForm.getLink());
        company.setDeadline((companyForm.getDeadline() == ""||  companyForm.getDeadline() == null)? "δ֪" : companyForm.getDeadline());
        if (companyForm.getPush_code() == "" || companyForm.getPush_code() == null) {
            company.setPush(0);  // 1 push; 0 not push
            company.setPush_code("");
        }else {
            company.setPush(1);
            company.setPush_code(companyForm.getPush_code());
        }
        company.setStatus(0); // 0 :δͶ�� 1: ��Ͷ��
        return company;
    }

    public static User toUser(RUser rUser) {
        User user = new User();
        user.setUserName(rUser.getUserName());
        user.setPassword(rUser.getPassword());
        user.setRoleName("�û�");
        return user;
    }
    public static Config transToConfig(ConfigForm configForm){
        Config config = new Config();
        String params = configForm.getExtraParams();
        String[] extraPramas ;
        if(params !=null && params !="") {
            extraPramas = params.split(",");
            if(extraPramas.length==1){
                config.setExtraParam1(extraPramas[0]);
            }else if(extraPramas.length==2){
                config.setExtraParam1(extraPramas[0]);
                config.setExtraParam2(extraPramas[1]);
            }else if(extraPramas.length>2){
                config.setExtraParam1(extraPramas[0]);
                config.setExtraParam2(extraPramas[1]);
                config.setExtraParam3(extraPramas[2]);
            }
            logger.error(extraPramas.length);
        }
        config.setURI(configForm.getUriConfig());
        config.setKeyWordForReq(configForm.getKeyWordForReq());
        config.setKeyWordForResp(configForm.getKeyWordForResp());
        config.setTagWordForReq(configForm.getTagWordForReq());
        config.setTagWordForResp(configForm.getTagWordForResp());
        config.setFileName(configForm.getFileName());
        return config;
    }
    public static List<String> transToList(Config config){
        List<String> list = new ArrayList<>();
        list.add(config.getURI());
        list.add(config.getKeyWordForReq());
        list.add(config.getKeyWordForResp());
        list.add(config.getTagWordForReq());
        list.add(config.getTagWordForResp());
        list.add(config.getExtraParam1());
        list.add(config.getExtraParam2());
        list.add(config.getExtraParam3());
        return list;
    }
    public static Map<String, String> beanToMap(Object object, Boolean isExcludeNullValue) {
        Map<String, String> map = new HashMap();
        Class<?> clazz = object.getClass();

        for(Class currentClazz = clazz; currentClazz != Object.class; currentClazz = currentClazz.getSuperclass()) {
            Field[] fields = currentClazz.getDeclaredFields();

            try {
                Field[] var6 = fields;
                int var7 = fields.length;

                for(int var8 = 0; var8 < var7; ++var8) {
                    Field field = var6[var8];
                    field.setAccessible(true);

                    Method method;
                    try {
                        method = currentClazz.getMethod("get" + CommonUtils.toUpperFirstChar(field.getName()));
                    } catch (NoSuchMethodException var12) {
                        continue;
                    } catch (Exception var13) {
                        var13.printStackTrace();
                        return Maps.newHashMap();
                    }

                    Object value = method.invoke(object);
                    if (!isExcludeNullValue || value != null) {
                        map.put(field.getName(), String.valueOf(value));
                    }
                }
            } catch (Exception var14) {
                var14.printStackTrace();
                return Maps.newHashMap();
            }
        }

        return map;
    }
    public static void main(String[] args) {
        System.out.println("\" nihao \"");
    }
}
