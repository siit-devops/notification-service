package com.devops.notification_service.repository;

import com.devops.notification_service.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, UUID> {

    List<Notification> findAllByReceiverIdAndProcessedFalse(UUID userId);

}
