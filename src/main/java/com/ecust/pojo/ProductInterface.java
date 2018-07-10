package com.ecust.pojo;

public class ProductInterface {
    private Integer id;
    private int productid;
    private String interfacename;
    private String interfacepath;
    private String interfaceparam;
    private String interfaceresponse;
    private Integer status;
    private String requeststype;
    private String createtime;
    private String paramexam;
    private String updatetime;

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getParamexam() {
        return paramexam;
    }

    public void setParamexam(String paramexam) {
        this.paramexam = paramexam;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getInterfacename() {
        return interfacename;
    }

    public void setInterfacename(String interfacename) {
        this.interfacename = interfacename;
    }

    public String getInterfacepath() {
        return interfacepath;
    }

    public void setInterfacepath(String interfacepath) {
        this.interfacepath = interfacepath;
    }

    public String getInterfaceparam() {
        return interfaceparam;
    }

    public void setInterfaceparam(String interfaceparam) {
        this.interfaceparam = interfaceparam;
    }

    public String getInterfaceresponse() {
        return interfaceresponse;
    }

    public void setInterfaceresponse(String interfaceresponse) {
        this.interfaceresponse = interfaceresponse;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRequeststype() {
        return requeststype;
    }

    public void setRequeststype(String requeststype) {
        this.requeststype = requeststype;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
