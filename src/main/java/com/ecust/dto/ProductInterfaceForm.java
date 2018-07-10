package com.ecust.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class ProductInterfaceForm {
    private String id;
    private String productId;
    @NotEmpty(message = "interfaceName 不能为空！")
    private String interfaceName;
    @NotEmpty(message = "interfacePath 不能为空！")
    private String interfacePath;
    @NotEmpty(message = "interfaceParam 不能为空！")
    private String interfaceParam;
    private String interfaceResponse;
    @NotEmpty(message = "requestsType 不能为空！")
    private String requestsType;
    private String paramExam;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParamExam() {
        return paramExam;
    }

    public void setParamExam(String paramExam) {
        this.paramExam = paramExam;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getInterfacePath() {
        return interfacePath;
    }

    public void setInterfacePath(String interfacePath) {
        this.interfacePath = interfacePath;
    }

    public String getInterfaceParam() {
        return interfaceParam;
    }

    public void setInterfaceParam(String interfaceParam) {
        this.interfaceParam = interfaceParam;
    }

    public String getInterfaceResponse() {
        return interfaceResponse;
    }

    public void setInterfaceResponse(String interfaceResponse) {
        this.interfaceResponse = interfaceResponse;
    }

    public String getRequestsType() {
        return requestsType;
    }

    public void setRequestsType(String requestsType) {
        this.requestsType = requestsType;
    }
}
