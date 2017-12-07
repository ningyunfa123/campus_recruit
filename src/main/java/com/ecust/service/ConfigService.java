package com.ecust.service;

import com.ecust.pojo.Config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by ningyunfa on 2017/9/11.
 */
public interface ConfigService {
    boolean saveConfig(Config config) throws IOException;
    Map<String,Object> queryConfig(int pageNumber, int pageSize) throws FileNotFoundException;
}
