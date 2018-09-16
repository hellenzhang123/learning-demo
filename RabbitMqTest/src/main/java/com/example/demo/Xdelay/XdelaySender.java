//package com.example.demo.Xdelay;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.springframework.amqp.AmqpException;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.core.MessagePostProcessor;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.Constants.Constants;
//import com.example.demo.model.Booking;
//
//@Service
//public class XdelaySender {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    public void send(Booking booking, int delayTime) {
////        long delayTime = booking.getBookingTime().getTime() - System.currentTimeMillis();
//        System.out.println("delayTime" + delayTime);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        this.rabbitTemplate.convertAndSend(Constants.DELAYED_EXCHANGE_XDELAY, Constants.DELAY_ROUTING_KEY_XDELAY, booking, new MessagePostProcessor() {
//            @Override
//            public Message postProcessMessage(Message message) throws AmqpException {
//                message.getMessageProperties().setDelay(delayTime);
//                System.out.println(sdf.format(new Date()) + " Delay sent.");
//                return message;
//            }
//        });
//    }
//}
