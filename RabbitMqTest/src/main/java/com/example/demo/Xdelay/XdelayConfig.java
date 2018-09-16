//package com.example.demo.Xdelay;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.CustomExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.example.demo.Constants.Constants;
//
//@Configuration
//public class XdelayConfig {
//
//    // 创建一个立即消费队列
//    @Bean
//    public Queue immediateQueue() {
//        // 第一个参数是创建的queue的名字，第二个参数是是否支持持久化
//        return new Queue(Constants.IMMEDIATE_QUEUE_XDELAY, true);
//    }
//
//    @Bean
//    public CustomExchange delayExchange() {
//        Map<String, Object> args = new HashMap<String, Object>();
//        args.put("x-delayed-type", "direct");
//        return new CustomExchange(Constants.DELAYED_EXCHANGE_XDELAY, "x-delayed-message", true, false, args);
//    }
//
//    @Bean
//    public Binding bindingNotify() {
//        return BindingBuilder.bind(immediateQueue()).to(delayExchange()).with(Constants.DELAY_ROUTING_KEY_XDELAY).noargs();
//    }
//}
