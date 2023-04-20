package com.example.demo.entity;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("orders")
public class Order {
    private Integer id;
    private Integer userid;
    private String name;
    private Date date;
    private String idcard;
    private String phone;
    private Integer nump;
    private Integer statu;
    private String ordercode;
    private Date dodate;

    public Date getDodate() {
        return dodate;
    }

    public void setDodate(Date dodate) {
        this.dodate = dodate;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getNump() {
        return nump;
    }

    public void setNump(Integer nump) {
        this.nump = nump;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }
}
