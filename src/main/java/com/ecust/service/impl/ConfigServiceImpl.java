package com.ecust.service.impl;

import com.ecust.pojo.Config;
import com.ecust.pojo.Page;
import com.ecust.service.ConfigService;
import com.ecust.utils.DataTrans;
import com.ecust.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by ningyunfa on 2017/9/11.
 */
@Service("configService")
public class ConfigServiceImpl implements ConfigService {
    private Properties properties;
//    @Value("#{configPro['filePath']}")
    private String filePath;
//    @Value("#{configPro['fileName']}")
    private String fileName;
//    @Value("#{configPro['fileFormat']}")
    private String fileFormat;
    private File path;

    public ConfigServiceImpl() throws IOException {
        if(properties==null){
            properties = new Properties();
        }
        try {
            properties.load(this.getClass().getResourceAsStream("/file.properties"));
            filePath = properties.getProperty("filePath");
            fileName = properties.getProperty("fileName");
            fileFormat = properties.getProperty("fileFormat");
            if(path==null)
                path = new File(filePath);
            if(!path.exists() && !path.isDirectory()){
                path.mkdirs();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    @Override
    public boolean saveConfig(Config config) throws IOException {
        File file;
        FileOutputStream paramsSave;
        if(config.getFileName() == null || config.getFileName() == "")
            file = new File(filePath+fileName+System.currentTimeMillis()+"."+fileFormat);
        else
            file = new File(filePath+config.getFileName()+"."+fileFormat);
        try {
            paramsSave = new FileOutputStream(file,true);
        } catch (FileNotFoundException e) {
            e.getStackTrace();
            throw e;
        }
        List<String> list = DataTrans.transToList(config);
        try {
            for (String param:list) {
                if (param!= null && param != ""){
                    paramsSave.write(param.getBytes());
                }else {
                    paramsSave.write("\r\n".getBytes());
                    continue;
                }
                paramsSave.write("\r\n".getBytes());
            }
        } catch (IOException e){
            e.getStackTrace();
            throw e;
        } finally {
            try {
                paramsSave.close();
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
        return true;
    }

    @Override
    public Map<String,Object> queryConfig(int pageNumber,int pageSize) throws FileNotFoundException {
        List<String> fileNameList = new ArrayList<>();

        // 分页，并判断分页参数是否存在
        Page page = new Page();
        if (page.getPageNo() == null && page.getPageSize() == null) {
            page.setPageNo(pageNumber);
            page.setPageSize(pageSize);
        } else {
            page.setPageNo(1);
            page.setPageSize(10);
        }
        PageUtils.page(page);
        if(!path.exists()){
            throw new FileNotFoundException("未找到相应文件夹");
        }
        File[] subFile = path.listFiles();
        if(subFile != null && subFile.length>0) {
            for (File f : subFile) {
                if (!f.isDirectory()) {
                    fileNameList.add(f.getName());
                    System.out.println(f.getName());
                }
            }
        }

        return PageUtils.proccess(fileNameList);
    }

}
