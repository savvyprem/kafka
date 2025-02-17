package com.prem.kafka.controller;

import com.prem.kafka.producers.NotificationProducer;
import com.prem.kafka.requests.MessageRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.IconUIResource;

@Slf4j
@RestController
@RequestMapping("/api/producer")
@RequiredArgsConstructor
public class MessageProducerController {

    private final NotificationProducer notificationProducer;

    @PostMapping("/send")
    public String sendMessage(@Valid @RequestBody MessageRequest messageRequest) {
        log.info("sendMessage(): Sending {} messages: {}", messageRequest.count(), messageRequest);
        notificationProducer.sendNotification(messageRequest.message(), messageRequest.count());
        return "Message sent successfully.";
    }
}
