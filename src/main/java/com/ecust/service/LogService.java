package com.ecust.service;

import java.util.Map;

/**
 * Created by ningyunfa on 2017/10/19.
 */
public interface LogService {
    boolean addLog(String show);
    Map<String, Object> queryAllLog(int pageNo, int pageSize);
}
