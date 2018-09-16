package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.deadLetter.ImmediateSender;
import com.example.demo.model.Booking;

@RestController
public class BookingController {

    @Autowired
    ImmediateSender sender;
//    @Autowired
//    XdelaySender sender2;

    @RequestMapping(value="/test")
    public void test() {
        Booking booking = new Booking();
        booking.setBookingContent("hhaha");
        booking.setBookingName("预定房子");
        booking.setBookingTime(new Date());
        booking.setOperatorName("hellen");
        sender.send(booking, 10000);
    }

//    @RequestMapping(value="/test2")
//    public void test2() {
//        Booking booking = new Booking();
//        booking.setBookingContent("hhaha");
//        booking.setBookingName("预定房子");
//        booking.setBookingTime(new Date());
//        booking.setOperatorName("hellen");
//        sender2.send(booking, 10000);
//    }
}
