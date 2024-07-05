package com.ikiseh.My_Task_Management_System.service;

import com.ikiseh.My_Task_Management_System.payLoad.request.user.UserLoginRequest;
import com.ikiseh.My_Task_Management_System.payLoad.request.user.UserSignUpRequest;
import com.ikiseh.My_Task_Management_System.payLoad.response.user.LoginResponse;
import com.ikiseh.My_Task_Management_System.payLoad.response.user.RegistrationResponse;

public interface UserService {

     RegistrationResponse registerUser (UserSignUpRequest userSignUpRequest);

     LoginResponse loginUser (UserLoginRequest userLoginRequest);
    // void enableUser(String token);
}
