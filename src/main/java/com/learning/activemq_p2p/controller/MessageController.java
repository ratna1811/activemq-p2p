package com.learning.activemq_p2p.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.activemq_p2p.model.Message;
import com.learning.activemq_p2p.producer.MessageProducer;

@RestController
public class MessageController {

    private final MessageProducer messageProducer;

    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping("/publishMessage")
    public ResponseEntity<String> publishMessages(@RequestBody String messageText) {
        Message message = new Message(messageText);
        try {
            messageProducer.sendMessage(message);
            return new ResponseEntity<>("Message Published Successfully", HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>("Error Publishing the Message.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
