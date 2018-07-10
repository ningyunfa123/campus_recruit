package com.ecust.utils.ModuleDeploy;

import org.apache.http.util.TextUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpPost {
     private final static Logger logger = Logger.getLogger(HttpPost.class);
    public static String httpPost(String urlPath, String param,String cookie) {
        // HttpClient 6.0被抛弃了
        String result = "";
        BufferedReader reader = null;
        try {
            URL url = new URL(urlPath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");
            // 设置文件类型:
            //conn.setRequestProperty("Content-Type","application/json; charset=UTF-8");
            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
            conn.setRequestProperty("Accept","application/json");
            conn.setRequestProperty("Cookie",cookie);

            // 往服务器里面发送数据
            if (param != null && !TextUtils.isEmpty(param)) {
                byte[] writebytes = param.getBytes();
                // 设置文件长度
                conn.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
                OutputStream outwritestream = conn.getOutputStream();
                outwritestream.write(param.getBytes());
                outwritestream.flush();
                outwritestream.close();
                logger.debug("doJsonPost: conn:"+conn.getResponseCode());
            }
            if (conn.getResponseCode() == 200) {
                reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                result = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    public static void main(String[] args)  {
        String urlpath = "http://nminst.baidu.com/nminst/createenv";
        String param = "machine_host=cp01-wise-baino01.cp01.baidu.com&machine_user=nuomi&machine_passwd=nuomi@baidu&source=online&env_type=TEST_FOR_TEST&user=ningyunfa&module_name=trade";
        //String params = URLEncoder.encode(param,"UTF-8");
        //System.out.println(httpPost(urlpath,param));
    }
}
