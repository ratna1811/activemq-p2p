package com.learning.activemq_p2p.producer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.learning.activemq_p2p.model.Message;

//using @component register the bean in the Spring Container
@Component
public class MessageProducer {
    private final JmsTemplate jmsTemplate;

    public MessageProducer(org.springframework.jms.core.JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(Message message) {
        jmsTemplate.convertAndSend("queue-1", message);
    }
}
