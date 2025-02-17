package com.prem.kafka.requests;

import jakarta.validation.constraints.NotEmpty;

public record MessageRequest(@NotEmpty(message = "Message is required.") String message) {
}
