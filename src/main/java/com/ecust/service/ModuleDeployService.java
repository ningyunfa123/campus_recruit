package com.ecust.service;

import java.io.IOException;
import java.util.Map;

public interface ModuleDeployService {
    Map<String,Object> deploy(String productName, String pipelineName, String branch) throws IOException;
    Map<String,Object> getBranchInfo(String productName,String pipeLineName) throws IOException;
}
