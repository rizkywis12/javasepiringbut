package com.fztrck.apiLibrary.validator;

import com.fztrck.apiLibrary.exception.custom.CustomNotFoundException;
import com.fztrck.apiLibrary.model.entity.Book;
import com.fztrck.apiLibrary.model.entity.User;

import java.util.Optional;

public class UserValidator {
    public void validateUserNotFound(Optional<User> userOptional) throws Exception {
        if (userOptional.isEmpty()) {
            throw new CustomNotFoundException("User Tidak Ditemukan");
        }
    }
}
