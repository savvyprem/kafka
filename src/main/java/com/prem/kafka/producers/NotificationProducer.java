package com.prem.kafka.producers;

import com.prem.kafka.constants.NotificationConstants;
import com.prem.kafka.dto.NotificationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationProducer {

    private final KafkaTemplate<String, NotificationDto> kafkaTemplate;

    @Async
    public void sendNotification(String message, Integer count) {
        log.info("sendNotification(): Sending message: {}", message);
        for (int i = 0; i < count; i++) {
            NotificationDto notificationDto = new NotificationDto(i, message, "Description: " + message);
            log.info("sendNotification(): Sending message: {}", notificationDto);
            kafkaTemplate.send(NotificationConstants.TOPIC_NOTIFICATIONS_PRTS, notificationDto);
        }
        log.info("sendNotification(): Message sent successfully.");
    }
}