package com.prem.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto implements Serializable {

    public static final Long serialVersionUID = 1L;
    
    private Integer id;
    private String message;
    private String description;
}
