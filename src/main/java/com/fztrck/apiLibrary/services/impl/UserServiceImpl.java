package com.fztrck.apiLibrary.services.impl;

import com.fztrck.apiLibrary.model.dto.ResponseData;
import com.fztrck.apiLibrary.model.dto.UserDto;
import com.fztrck.apiLibrary.model.entity.User;
import com.fztrck.apiLibrary.model.entity.UserDetails;
import com.fztrck.apiLibrary.repository.UserDetailsRepository;
import com.fztrck.apiLibrary.repository.UserRepository;
import com.fztrck.apiLibrary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    private ResponseData<Object> responseData;
    private User user;
    private UserDetails userDetails;
    private Map<Object,Object> data;


    @Override
    public ResponseData<Object> register(UserDto request) {
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());
        if (userOptional.isPresent()){
            responseData = new ResponseData<Object>(HttpStatus.BAD_REQUEST.value(), "Email has been regist, Please Login!",null);
        }else {
            user = new User(request.getEmail(),request.getPassword());
//            save method
            userRepository.save(user);

            data = new HashMap<>();
            data.put("email", user.getEmail());
            responseData = new ResponseData<Object>(HttpStatus.CREATED.value(), "Register Success, Happy Login!",data);
        }
        return responseData;
    }

    @Override
    public ResponseData<Object> updateUser(long id, UserDetails request) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            user = userOptional.get();

            // update buku
            userDetails = new UserDetails(request.getFirstName(), request.getLastName(), request.getPhoneNumber());
            userDetails.setUserId(user);
            userDetails.setFirstName(request.getFirstName());
            userDetails.setLastName(request.getLastName());
            userDetailsRepository.save(userDetails);


            // response data
            responseData = new ResponseData<Object>(HttpStatus.OK.value(), "Berhasil Menambahkan Details", userDetails);
        } else {
            responseData = new ResponseData<Object>(HttpStatus.NOT_FOUND.value(), "User Id Tidak Ada", null);
        }
        return responseData;
    }

    @Override
    public ResponseData<Object> login(UserDto request) {
     Optional<User> userOptional = userRepository.findByEmail(request.getEmail());
     if (userOptional.isPresent()){
         if (request.getPassword().equals(request.getPassword())){
             data = new HashMap<>();
             data.put("email", user.getEmail());
             responseData = new ResponseData<Object>(HttpStatus.OK.value(), "Login Success!!", data);
         }else {
             responseData = new ResponseData<Object>(HttpStatus.BAD_REQUEST.value(), "Wrong Password!", null);
         }
     }else {
         responseData = new ResponseData<Object>(HttpStatus.BAD_REQUEST.value(), "User Not Found, Please Register First!",null);
     }
     return responseData;
    }
}
