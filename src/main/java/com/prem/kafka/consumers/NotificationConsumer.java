package com.prem.kafka.consumers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private static Long totalMessagesConsumed = 0L;

//    @KafkaListener(topics = NotificationConstants.TOPIC_NOTIFICATIONS_PRTS)
//    public void consumeNotification(String message) {
//        totalMessagesConsumed++;
//        log.info("consumeNotification(): Consuming message: {}", message);
//        log.info("consumeNotification(): Total messages consumed: {}", totalMessagesConsumed);
//    }
}