package com.prem.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto implements Serializable {

    private String notificationId;
    private String message;
    private String userId;
    private String deviceId;
    private String email;
    private String phone;
    private String notificationType;
    private String purposeCode;
}
