package com.ikiseh.My_Task_Management_System.service.impl;


import com.ikiseh.My_Task_Management_System.model.entity.User;
import com.ikiseh.My_Task_Management_System.payLoad.request.EmailDetails;
import com.ikiseh.My_Task_Management_System.payLoad.request.user.UserLoginRequest;
import com.ikiseh.My_Task_Management_System.payLoad.request.user.UserSignUpRequest;
import com.ikiseh.My_Task_Management_System.payLoad.response.user.LoginInfo;
import com.ikiseh.My_Task_Management_System.payLoad.response.user.LoginResponse;
import com.ikiseh.My_Task_Management_System.payLoad.response.user.RegistrationResponse;
import com.ikiseh.My_Task_Management_System.payLoad.response.user.UserSignUpResponse;
import com.ikiseh.My_Task_Management_System.repository.UserRepository;
import com.ikiseh.My_Task_Management_System.service.EmailService;
import com.ikiseh.My_Task_Management_System.service.UserService;
import com.ikiseh.My_Task_Management_System.utils.RegistrationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EmailService emailService;



    @Override
    public RegistrationResponse registerUser(UserSignUpRequest userSignUpRequest) {

        Optional<User> existingUsers = userRepository.findByEmail(userSignUpRequest.getEmail());
        if (!existingUsers.isEmpty()) {
            RegistrationResponse registrationResponse = RegistrationResponse.builder()
                    .responseCode(RegistrationUtils.EMAIL_EXISTS_CODE)
                    .responseMessage(RegistrationUtils.EMAIL_EXISTS_MESSAGE)
                    .build();
            return registrationResponse;
        }


        User user = User.builder()
                .firstName(userSignUpRequest.getFirstName())
                .lastName(userSignUpRequest.getLastName())
                .email(userSignUpRequest.getEmail())
                .phoneNumber(userSignUpRequest.getPhoneNumber())
                .password(userSignUpRequest.getPassword())
                .confirmPassword(userSignUpRequest.getPassword())
                .build();

        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(user.getEmail())
                .subject("ACCOUNT CREATED")
                .messageBody("ACCOUNT CREATED SUCCESSFULLY!!\n To Login, use your Email and Password")
                .build();

        emailService.sendVerificationEmail(emailDetails);

        userRepository.save(user);
        return RegistrationResponse.builder()
                //upon collecting the details from the user, we will show this details to the user as his login details
                .responseCode(RegistrationUtils.ACCOUNT_CREATED_SUCCESS_CODE)
                .responseMessage(RegistrationUtils.ACCOUNT_CREATION_SUCCESS_MESSAGE)
                .userSignUpResponse(UserSignUpResponse.builder()
                        .firstName(userSignUpRequest.getFirstName())
                        .lastName(userSignUpRequest.getLastName())
                        .email(userSignUpRequest.getEmail())
                        .phoneNumber(userSignUpRequest.getPhoneNumber())
                        .build())
                .build();
    }

    @Override
    public LoginResponse loginUser(UserLoginRequest userLoginRequest) {
        Optional<User> invalidUser = userRepository.findByEmail(userLoginRequest.getEmail());
        if(invalidUser.isEmpty()){
            LoginResponse loginResponse = LoginResponse.builder()
                    .responseCode(RegistrationUtils.USER_DOES_NOT_EXIST_CODE)
                    .responseMessage(RegistrationUtils.USER_DOES_NOT_EXIST_MESSAGE)
                    .build();
            return loginResponse;

        }User user = invalidUser.get();
        if(!user.getPassword().equals(userLoginRequest.getPassword())){
            LoginResponse loginResponse = LoginResponse.builder()
                    .responseCode(RegistrationUtils.PASSWORD_DOES_NOT_MATCH_CODE)
                    .responseMessage(RegistrationUtils.PASSWORD_DOES_NOT_MATCH_MESSAGE)
                    .build();
            return loginResponse;
        }
        User logUser = User.builder()
                .email(userLoginRequest.getEmail())
                .password(userLoginRequest.getPassword())
                .build();

        return LoginResponse.builder()
                .responseCode(RegistrationUtils.USER_LOGIN_SUCCESS_CODE)
                .responseMessage(RegistrationUtils.USER_LOGIN_SUCCESS_MESSAGE)
                .loginInfo(LoginInfo.builder()
                        .email(logUser.getEmail())
                        .fullName(logUser.getFirstName()+" "+ logUser.getLastName())
                        .build())
                .build();
    }

}
