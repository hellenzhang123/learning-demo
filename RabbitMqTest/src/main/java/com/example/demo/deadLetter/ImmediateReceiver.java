package com.example.demo.deadLetter;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.example.demo.Constants.Constants;
import com.example.demo.model.Booking;

@Component
@EnableRabbit
@Configuration
public class ImmediateReceiver {

    @RabbitListener(queues = Constants.IMMEDIATE_QUEUE)
    public void get(Booking booking) {
        System.out.println("kkkkkkkkkkkk");
        System.out.println(booking);
    }
}
