package com.abhishek.learning.jmsproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jms.Queue;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/jmsSenderApi")
public class RestController {

    @Autowired
    Queue queue;

    @Autowired
    JmsTemplate jmsTemplate;

    @GetMapping("/msg/{message}")
    public String sendJMSMessage(@PathVariable String message){

        jmsTemplate.convertAndSend(queue,message);

        return "Message published successfully";
    }

}
