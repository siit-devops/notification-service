package com.devops.notification_service.kafka;

import com.devops.notification_service.model.Notification;
import com.devops.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final NotificationService notificationService;

    @KafkaListener(topics = "notifications-topic", containerFactory = "kafkaListenerContainerFactory")
    public void newNotification(Notification message) {
        notificationService.addNewNotification(message);
    }

}
