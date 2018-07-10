package com.ecust.controller;


import net.sf.json.JSONArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
       String path="http://agile.baidu.com/agile/pipeline/getPipelineBuilds?pipelineConfId=468301&branch=chenyiwen_pay-platform-gateway&offset=0&limit=10";
        URL url = new URL(path);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Cookie", "BIDUPSID=7C8A2602CE84A9E7A83BC07425D4949C; PSTM=1527658548; BAIDUID=E1DFE3C4DDD7BA176FDAFD9D84CBA035:FG=1; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; BKMASKSID=a44a119fbf3420e6a248c3a028c35522; FP_UID=a9ce43b591a2a6dd9e3ec93f0f498409; BDUSS=ZhVkxneFp5M09nVFN1VjFyQk1xMnVHTkxmTmdpWkNJS05FVmp3bDhwTEt6bEpiQVFBQUFBJCQAAAAAAAAAAAEAAADIRJcfusO6w7XEusMxMjMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMpBK1vKQStbVl; SESSION=832b00c2-dc1a-462c-9afb-941ad692233b; Hm_lvt_af7062a9f07c74788ac9c77dd860b064=1529385759,1529460309,1529547328,1529633711; m_name=\"baidu%2Ftrade%2Fpay-platform\"; H_PS_PSSID=1453_21091_18560_26350; BDRCVFR[feWj1Vr5u3D]=I67x6TjHwwYf0; PSINO=2; Hm_lpvt_af7062a9f07c74788ac9c77dd860b064=1529637510");
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.62 Safari/537.36");
        con.setRequestProperty("Accept", "application/json, text/plain, */*");
        con.connect();
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {// 循环读取流
            sb.append(line);
        }
        br.close();

        JSONArray jArray= JSONArray.fromObject(sb.toString());
        Collection collection = JSONArray.toCollection(jArray, com.ecust.pojo.Test.class);
        List<com.ecust.pojo.Test> userList = new ArrayList<>();
        for (Object aCollection : collection) {
            com.ecust.pojo.Test user = (com.ecust.pojo.Test) aCollection;
            userList.add(user);
        }
        //JavaType javaType = getCollectionType(mapper,ArrayList.class, JSONObject.class);
       // List list;
       // list=mapper.readValue(sb.toString(),javaType);

        String s=  userList.get(0).getModule();



        //GetMethod get = new GetMethod("http://agile.baidu.com/#/builds/baidu/trade/pay-platform@BranchPipeline@chenyiwen_pay-platform-gateway");

        System.out.println(con.getResponseCode());
        System.out.println("=========================================");
        System.out.println(s);
    }
}
