package com.fztrck.apiLibrary.controller;

import com.fztrck.apiLibrary.model.dto.BookDto;
import com.fztrck.apiLibrary.model.dto.ResponseData;
import com.fztrck.apiLibrary.model.dto.UserDto;
import com.fztrck.apiLibrary.model.entity.UserDetails;
import com.fztrck.apiLibrary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    private ResponseData responseData;

    @PostMapping("/register")
    public ResponseEntity<Object>register(@RequestBody UserDto request){
        responseData = userService.register(request);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }
    @PostMapping("/login")
    public ResponseEntity<Object> signIn(@RequestBody UserDto request) {
        responseData = userService.login(request);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable long id, @RequestBody UserDetails request) {
        responseData = userService.updateUser(id, request);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

}
