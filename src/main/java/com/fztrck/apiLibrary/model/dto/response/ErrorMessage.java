package com.fztrck.apiLibrary.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage<T> {
    private Integer status;
    private LocalDateTime timestamp;
    private String message;
    private T errors;
}
