package com.ecust.dto;

import java.io.Serializable;

/**
 * Created by ningyunfa on 2017/9/11.
 */
public class ConfigForm implements Serializable{
    private String uriConfig;
    private String keyWordForResp;
    private String keyWordForReq;
    private String tagWordForReq;
    private String tagWordForResp;
    private String extraParams;
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUriConfig() {
        return uriConfig;
    }

    public void setUriConfig(String uriConfig) {
        this.uriConfig = uriConfig;
    }

    public String getKeyWordForResp() {
        return keyWordForResp;
    }

    public void setKeyWordForResp(String keyWordForResp) {
        this.keyWordForResp = keyWordForResp;
    }

    public String getKeyWordForReq() {
        return keyWordForReq;
    }

    public void setKeyWordForReq(String keyWordForReq) {
        this.keyWordForReq = keyWordForReq;
    }

    public String getTagWordForReq() {
        return tagWordForReq;
    }

    public void setTagWordForReq(String tagWordForReq) {
        this.tagWordForReq = tagWordForReq;
    }

    public String getTagWordForResp() {
        return tagWordForResp;
    }

    public void setTagWordForResp(String tagWordForResp) {
        this.tagWordForResp = tagWordForResp;
    }

    public String getExtraParams() {
        return extraParams;
    }

    public void setExtraParams(String extraParams) {
        this.extraParams = extraParams;
    }
}
