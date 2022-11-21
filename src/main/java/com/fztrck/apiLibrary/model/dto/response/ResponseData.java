package com.fztrck.apiLibrary.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseData<T> {
    private Integer status;
    private String message;
    private T data;
}
