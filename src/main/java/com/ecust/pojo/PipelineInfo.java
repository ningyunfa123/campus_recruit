package com.ecust.pojo;

import net.sf.json.JSONObject;

import java.util.List;

public class PipelineInfo {
    private String newVersion;
    private String configVersion;
    private String pipelineType;
    private int id;
    private String name;
    private JSONObject branches;
    private JSONObject branchInfos;
    private JSONObject pipelineBranchConfBeans;
    private JSONObject pipelineTriggerConfBeans;
    private String exeConditionConfBeans;
    private String module;
    private String svnType;
    private String branchName;
    private String bcloud;
    private String createUser;
    private Long createTime;
    private String lastModifiedUser;
    private Long lastModifiedTime;
    private boolean deleteStatus;
    private List stages;
    private boolean releaseDisabled;
    private String blockStatus;
    private String bcloudFile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(String newVersion) {
        this.newVersion = newVersion;
    }

    public String getConfigVersion() {
        return configVersion;
    }

    public void setConfigVersion(String configVersion) {
        this.configVersion = configVersion;
    }

    public String getPipelineType() {
        return pipelineType;
    }

    public void setPipelineType(String pipelineType) {
        this.pipelineType = pipelineType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JSONObject getBranches() {
        return branches;
    }

    public void setBranches(JSONObject branches) {
        this.branches = branches;
    }

    public JSONObject getBranchInfos() {
        return branchInfos;
    }

    public void setBranchInfos(JSONObject branchInfos) {
        this.branchInfos = branchInfos;
    }

    public JSONObject getPipelineBranchConfBeans() {
        return pipelineBranchConfBeans;
    }

    public void setPipelineBranchConfBeans(JSONObject pipelineBranchConfBeans) {
        this.pipelineBranchConfBeans = pipelineBranchConfBeans;
    }

    public JSONObject getPipelineTriggerConfBeans() {
        return pipelineTriggerConfBeans;
    }

    public void setPipelineTriggerConfBeans(JSONObject pipelineTriggerConfBeans) {
        this.pipelineTriggerConfBeans = pipelineTriggerConfBeans;
    }

    public String getExeConditionConfBeans() {
        return exeConditionConfBeans;
    }

    public void setExeConditionConfBeans(String exeConditionConfBeans) {
        this.exeConditionConfBeans = exeConditionConfBeans;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getSvnType() {
        return svnType;
    }

    public void setSvnType(String svnType) {
        this.svnType = svnType;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBcloud() {
        return bcloud;
    }

    public void setBcloud(String bcloud) {
        this.bcloud = bcloud;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getLastModifiedUser() {
        return lastModifiedUser;
    }

    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    public Long getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Long lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public boolean isDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public List getStages() {
        return stages;
    }

    public void setStages(List stages) {
        this.stages = stages;
    }

    public boolean isReleaseDisabled() {
        return releaseDisabled;
    }

    public void setReleaseDisabled(boolean releaseDisabled) {
        this.releaseDisabled = releaseDisabled;
    }

    public String getBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(String blockStatus) {
        this.blockStatus = blockStatus;
    }

    public String getBcloudFile() {
        return bcloudFile;
    }

    public void setBcloudFile(String bcloudFile) {
        this.bcloudFile = bcloudFile;
    }
}
