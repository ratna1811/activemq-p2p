package com.learning.activemq_p2p.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.learning.activemq_p2p.model.Message;

@Component
public class MessageConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    @JmsListener(destination = "queue-1")
    public void receiveMessage(Message message) {

        LOGGER.info("Message Received.." + message.getText());

    }
}
