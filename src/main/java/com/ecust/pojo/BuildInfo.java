package com.ecust.pojo;

import net.sf.json.JSONObject;

import java.util.List;

public class BuildInfo {
    private String urlPath;
    private String revision;
    private String triggerUser;
    private List<String> comments;
    private String buildResult;
    private String wgetOutput;
    private Long triggerTime;
    private JSONObject changes;
    private String commentText;
    private List<JSONObject> issues;
    private String commentLinksMap;
    private List<JSONObject> commitChanges;
    private boolean isSvn;

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getTriggerUser() {
        return triggerUser;
    }

    public void setTriggerUser(String triggerUser) {
        this.triggerUser = triggerUser;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public String getBuildResult() {
        return buildResult;
    }

    public void setBuildResult(String buildResult) {
        this.buildResult = buildResult;
    }

    public String getWgetOutput() {
        return wgetOutput;
    }

    public void setWgetOutput(String wgetOutput) {
        this.wgetOutput = wgetOutput;
    }

    public Long getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(Long triggerTime) {
        this.triggerTime = triggerTime;
    }

    public JSONObject getChanges() {
        return changes;
    }

    public void setChanges(JSONObject changes) {
        this.changes = changes;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public List<JSONObject> getIssues() {
        return issues;
    }

    public void setIssues(List<JSONObject> issues) {
        this.issues = issues;
    }

    public String getCommentLinksMap() {
        return commentLinksMap;
    }

    public void setCommentLinksMap(String commentLinksMap) {
        this.commentLinksMap = commentLinksMap;
    }

    public List<JSONObject> getCommitChanges() {
        return commitChanges;
    }

    public void setCommitChanges(List<JSONObject> commitChanges) {
        this.commitChanges = commitChanges;
    }

    public boolean isSvn() {
        return isSvn;
    }

    public void setSvn(boolean svn) {
        isSvn = svn;
    }
}
