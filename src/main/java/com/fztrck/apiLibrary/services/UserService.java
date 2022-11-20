package com.fztrck.apiLibrary.services;

import com.fztrck.apiLibrary.model.dto.ResponseData;
import com.fztrck.apiLibrary.model.dto.UserDetailDto;
import com.fztrck.apiLibrary.model.dto.UserDto;
import com.fztrck.apiLibrary.model.entity.UserDetails;

public interface UserService {
    ResponseData<Object> register(UserDto request);
    ResponseData<Object> updateUser(long id, UserDetailDto request);
    ResponseData<Object> login(UserDto request);
    ResponseData<Object> insertDetails(long id, UserDetailDto request);
}
