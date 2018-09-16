package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String bookingName;
    private Date bookingTime;
    private String bookingContent;
    private String operatorName;

    public Booking() {
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getBookingContent() {
        return bookingContent;
    }

    public void setBookingContent(String bookingContent) {
        this.bookingContent = bookingContent;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
