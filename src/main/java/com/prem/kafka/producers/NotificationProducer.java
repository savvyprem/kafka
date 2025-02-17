package com.prem.kafka.producers;

import com.prem.kafka.constants.NotificationConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Async
    public void sendNotification(String message) {
        log.info("sendNotification(): Sending message: {}", message);
        for (int i = 0; i < 100000000; i++) {
            String messageData = message + " : " + i;
            log.info("sendNotification(): Sending message: {}", messageData);
            kafkaTemplate.send(NotificationConstants.TOPIC_NOTIFICATIONS_PRTS, messageData);
        }
        log.info("sendNotification(): Message sent successfully.");
    }
}