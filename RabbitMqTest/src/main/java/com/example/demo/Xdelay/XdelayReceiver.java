//package com.example.demo.Xdelay;
//
//import org.springframework.amqp.rabbit.annotation.EnableRabbit;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//import com.example.demo.Constants.Constants;
//import com.example.demo.model.Booking;
//
//@Component
//@EnableRabbit
//@Configuration
//public class XdelayReceiver {
//
//    @RabbitListener(queues = Constants.IMMEDIATE_QUEUE_XDELAY)
//    public void get(Booking booking) {
//        System.out.println("mmmmmmmmmmmmm");
//        System.out.println(booking);
//    }
//}
