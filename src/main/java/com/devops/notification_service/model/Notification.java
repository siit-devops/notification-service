package com.devops.notification_service.model;

import com.devops.notification_service.model.enums.NotificationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Notification implements Serializable {
    @Id
    @Field("_id")
    private String id;
    private NotificationType notificationType;
    private UUID subjectId;
    private UUID receiverId;
    private String message;
    private LocalDateTime createdAt;
    private Boolean processed;
}
