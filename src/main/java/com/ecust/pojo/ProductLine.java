package com.ecust.pojo;

public class ProductLine {
    private Integer id;
    private String productname;
    private Integer userid;
    private String username;
    private int status;
    private String createtime;
    private String parentmodule;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getParentmodule() {
        return parentmodule;
    }

    public void setParentmodule(String parentmodule) {
        this.parentmodule = parentmodule;
    }
}
