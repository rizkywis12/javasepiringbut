package com.fztrck.apiLibrary.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
