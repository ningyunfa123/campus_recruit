package com.ecust.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by ningyunfa on 2017/10/19.
 */
public interface LogDao {
    void addLog(@Param("show") String show);
    List<Map<String, Object>> queryLogByType(@Param("id") int id);
    List<Map<String, Object>> queryAllLog();
    List<Map<String, Object>> queryLatestLog();
    void updateLogByType(@Param("id") int id, @Param("show") String show);
}
