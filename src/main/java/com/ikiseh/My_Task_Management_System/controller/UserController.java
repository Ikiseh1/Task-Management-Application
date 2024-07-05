package com.ikiseh.My_Task_Management_System.controller;

import com.ikiseh.My_Task_Management_System.payLoad.request.user.UserLoginRequest;
import com.ikiseh.My_Task_Management_System.payLoad.request.user.UserSignUpRequest;
import com.ikiseh.My_Task_Management_System.payLoad.response.user.LoginResponse;
import com.ikiseh.My_Task_Management_System.payLoad.response.user.RegistrationResponse;
import com.ikiseh.My_Task_Management_System.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


     @PostMapping("/register-user")
    public RegistrationResponse registerUser(@RequestBody UserSignUpRequest userSignUpRequest) {
         return userService.registerUser(userSignUpRequest);
     }

     @PostMapping("/login-user")
    public LoginResponse loginUser (@RequestBody UserLoginRequest userLoginRequest){
         return userService.loginUser(userLoginRequest);
     }
}
