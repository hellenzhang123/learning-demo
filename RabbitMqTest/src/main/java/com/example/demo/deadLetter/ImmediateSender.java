package com.example.demo.deadLetter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Constants.Constants;
import com.example.demo.model.Booking;

@Service
public class ImmediateSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Booking booking, int delayTime) {
//        long delayTime = booking.getBookingTime().getTime() - System.currentTimeMillis();
        System.out.println("delayTime" + delayTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        rabbitTemplate.convertAndSend(Constants.DEAD_LETTER_EXCHANGE, Constants.DELAY_ROUTING_KEY, booking, new MessagePostProcessor() {
//            @Override
//            public Message postProcessMessage(Message message) throws AmqpException {
//                message.getMessageProperties().setDelay(1000);
//                System.out.println(sdf.format(new Date()) + " Delay sent.");
//                return message;
//            }
//        });
        this.rabbitTemplate.convertAndSend(Constants.DEAD_LETTER_EXCHANGE, Constants.DELAY_ROUTING_KEY, booking, message -> {
            // 如果配置了 params.put("x-message-ttl", 5 * 1000); 那么这一句也可以省略,具体根据业务需要是声明 Queue 的时候就指定好延迟时间还是在发送自己控制时间
            message.getMessageProperties().setExpiration(1 * 1000 + "");
            System.out.println(sdf.format(new Date()) + " Delay sent.");
            return message;
        });
    }
}
