package com.prem.kafka.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record MessageRequest(@NotEmpty(message = "Message is required.") String message, @NotNull Integer count) {
}
