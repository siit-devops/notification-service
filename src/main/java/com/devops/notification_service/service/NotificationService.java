package com.devops.notification_service.service;

import com.devops.notification_service.model.Notification;
import com.devops.notification_service.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final SimpMessagingTemplate messagingTemplate;

    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public void addNewNotification(Notification message) {
        saveNotification(message);

        if(!message.getProcessed()){
            sendNotificationToUser(message.getReceiverId(), message.getMessage());
        }
    }

    public List<Notification> getMyNotifications(UUID userId) {
        return notificationRepository.findAllByReceiverIdAndProcessedFalse(userId);
    }

    public void sendNotificationToUser(UUID userId, String message) {
        messagingTemplate.convertAndSend("/socket-publisher/" + userId, message);
    }
}
