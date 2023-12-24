package com.example.producer.service;

import com.example.producer.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqSender {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitmqSender(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingKey}")
    private String routingKey;

    public void send(User user){
        rabbitTemplate.convertAndSend(exchange, routingKey, user);
    }
}
