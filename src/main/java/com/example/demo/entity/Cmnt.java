package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;

public class Cmnt {
    private Integer id;
    private String type;
    private String text;
    private String userid;
    private String exhid;
    private String zlid;
    private String newid;
    private Date date;
    //    评论的用户
    @TableField(exist = false)
    private User user;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getExhid() {
        return exhid;
    }

    public void setExhid(String exhid) {
        this.exhid = exhid;
    }

    public String getZlid() {
        return zlid;
    }

    public void setZlid(String zlid) {
        this.zlid = zlid;
    }

    public String getNewid() {
        return newid;
    }

    public void setNewid(String newid) {
        this.newid = newid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
