package com.devops.notification_service.controller;

import com.devops.notification_service.model.Notification;
import com.devops.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping()
    // TODO: @HasRole("GUEST,HOST")
    public List<Notification> getMyNotifications(UUID userId) {
        return notificationService.getMyNotifications(userId);
    }

    @GetMapping("/test/{id}")
    public void testNotifications(@PathVariable UUID id) {
        notificationService.sendNotificationToUser(id, "test");
    }
}
