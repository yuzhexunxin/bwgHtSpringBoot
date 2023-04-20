package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("likes")
public class Like {
    private Integer id;
    private Integer userid;
    private String type;
    private Integer exhid;
    private Integer zlid;
    private Integer newid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getExhid() {
        return exhid;
    }

    public void setExhid(Integer exhid) {
        this.exhid = exhid;
    }

    public Integer getZlid() {
        return zlid;
    }

    public void setZlid(Integer zlid) {
        this.zlid = zlid;
    }

    public Integer getNewid() {
        return newid;
    }

    public void setNewid(Integer newid) {
        this.newid = newid;
    }
}
