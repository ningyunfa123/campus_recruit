package com.ecust.pojo;

import net.sf.json.JSONObject;

public class ModuleInfo {
    private int compileBuildId;
    private int buildNumber;
    private String module;
    private String revision;
    private String svnType;
    private String triggerUser;
    private String mode;
    private String branch;
    private String remarks;
    private boolean isDepended;
    private JSONObject pipelineBuildBean;
    private String buildTime;
    private int triggerId;
    private JSONObject workFlow;
    private JSONObject versionInfo;
    private boolean releaseDependUpStream;
    private String packageBuildType;
    private boolean releaseDisabled;
    private int numberRevision;
    private int indexOfStageWithCompileBuild;
    private boolean outside;
    private boolean gitModule;
    private String realTIme;

    public int getCompileBuildId() {
        return compileBuildId;
    }

    public void setCompileBuildId(int compileBuildId) {
        this.compileBuildId = compileBuildId;
    }

    public int getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(int buildNumber) {
        this.buildNumber = buildNumber;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getSvnType() {
        return svnType;
    }

    public void setSvnType(String svnType) {
        this.svnType = svnType;
    }

    public String getTriggerUser() {
        return triggerUser;
    }

    public void setTriggerUser(String triggerUser) {
        this.triggerUser = triggerUser;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isDepended() {
        return isDepended;
    }

    public void setDepended(boolean depended) {
        isDepended = depended;
    }

    public JSONObject getPipelineBuildBean() {
        return pipelineBuildBean;
    }

    public void setPipelineBuildBean(JSONObject pipelineBuildBean) {
        this.pipelineBuildBean = pipelineBuildBean;
    }

    public String getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(String buildTime) {
        this.buildTime = buildTime;
    }

    public int getTriggerId() {
        return triggerId;
    }

    public void setTriggerId(int triggerId) {
        this.triggerId = triggerId;
    }

    public JSONObject getWorkFlow() {
        return workFlow;
    }

    public void setWorkFlow(JSONObject workFlow) {
        this.workFlow = workFlow;
    }

    public JSONObject getVersionInfo() {
        return versionInfo;
    }

    public void setVersionInfo(JSONObject versionInfo) {
        this.versionInfo = versionInfo;
    }

    public boolean isReleaseDependUpStream() {
        return releaseDependUpStream;
    }

    public void setReleaseDependUpStream(boolean releaseDependUpStream) {
        this.releaseDependUpStream = releaseDependUpStream;
    }

    public String getPackageBuildType() {
        return packageBuildType;
    }

    public void setPackageBuildType(String packageBuildType) {
        this.packageBuildType = packageBuildType;
    }

    public boolean isReleaseDisabled() {
        return releaseDisabled;
    }

    public void setReleaseDisabled(boolean releaseDisabled) {
        this.releaseDisabled = releaseDisabled;
    }

    public int getNumberRevision() {
        return numberRevision;
    }

    public void setNumberRevision(int numberRevision) {
        this.numberRevision = numberRevision;
    }

    public int getIndexOfStageWithCompileBuild() {
        return indexOfStageWithCompileBuild;
    }

    public void setIndexOfStageWithCompileBuild(int indexOfStageWithCompileBuild) {
        this.indexOfStageWithCompileBuild = indexOfStageWithCompileBuild;
    }

    public boolean isOutside() {
        return outside;
    }

    public void setOutside(boolean outside) {
        this.outside = outside;
    }

    public boolean isGitModule() {
        return gitModule;
    }

    public void setGitModule(boolean gitModule) {
        this.gitModule = gitModule;
    }

    public String getRealTIme() {
        return realTIme;
    }

    public void setRealTIme(String realTIme) {
        this.realTIme = realTIme;
    }
}
