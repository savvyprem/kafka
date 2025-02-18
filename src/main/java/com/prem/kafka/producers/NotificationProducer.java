package com.prem.kafka.producers;

import com.prem.kafka.constants.NotificationConstants;
import com.prem.kafka.dto.NotificationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationProducer {

    private final KafkaTemplate<String, NotificationDto> kafkaTemplate;

    @Async
    public void sendNotification(String message, Integer count) {
        log.info("sendNotification(): Sending message: {}", message);
        Thread thread = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                NotificationDto notificationDto = new NotificationDto();
                notificationDto.setMessage(message);
                notificationDto.setNotificationName("SIGN_UP");
                notificationDto.setNotificationId(UUID.randomUUID().toString());
                notificationDto.setUserId(UUID.randomUUID().toString());
                notificationDto.setDeviceId(UUID.randomUUID().toString());
                notificationDto.setEmail("test" + i + "@yopmail.com");
                notificationDto.setPhone("98232323" + i);
                notificationDto.setNotificationType("EMAIL");
                log.info("sendNotification(): Sending message: {}", notificationDto);
                kafkaTemplate.send(NotificationConstants.TOPIC_NOTIFICATIONS, notificationDto);
            }
        });
        thread.start();
        log.info("sendNotification(): Message sent successfully.");
    }
}