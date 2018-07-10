package com.ecust.dto;

public class Deploy {
    private String productName;
    private String pipeLineName;
    private String branch;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPipeLineName() {
        return pipeLineName;
    }

    public void setPipeLineName(String pipeLineName) {
        this.pipeLineName = pipeLineName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
