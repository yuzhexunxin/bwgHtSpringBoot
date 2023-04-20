package com.example.demo.entity;

import java.util.Date;

public class Zl {
    private Integer id;
    private String title;
    private String content;
    private String floor;
    private Date time;
    private String headimg;
    private String imglist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getImglist() {
        return imglist;
    }

    public void setImglist(String imglist) {
        this.imglist = imglist;
    }
}
