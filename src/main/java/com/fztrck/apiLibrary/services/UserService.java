package com.fztrck.apiLibrary.services;

import com.fztrck.apiLibrary.model.dto.response.ResponseData;
import com.fztrck.apiLibrary.model.dto.request.UserDetailDto;
import com.fztrck.apiLibrary.model.dto.request.UserDto;

public interface UserService {
    ResponseData<Object> register(UserDto request);
    ResponseData<Object> updateUser(long id, UserDetailDto request);
    ResponseData<Object> login(UserDto request);
    ResponseData<Object> insertDetails(long id, UserDetailDto request);
}
