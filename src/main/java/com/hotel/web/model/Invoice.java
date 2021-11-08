/*
 * Copyright (c) 2021 Birmingham City University. All rights reserved.
 * Author:  Reza Shams (rezashams86@gmail.com)
 */
package com.hotel.web.model;


import java.util.Date;

public class Invoice {
    private String roomName;
    private int price;
    private  String  studentDiscount;
    private  String  DateDiscount;
    private Date date;
    private Date fromDate;
    private Date toDate;
    private int total;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStudentDiscount() {
        return studentDiscount;
    }

    public void setStudentDiscount(String studentDiscount) {
        this.studentDiscount = studentDiscount;
    }

    public String getDateDiscount() {
        return DateDiscount;
    }

    public void setDateDiscount(String dateDiscount) {
        DateDiscount = dateDiscount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
