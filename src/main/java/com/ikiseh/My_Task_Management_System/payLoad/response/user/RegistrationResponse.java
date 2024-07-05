package com.ikiseh.My_Task_Management_System.payLoad.response.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationResponse {
    private String responseCode;
    private String responseMessage;
    private UserSignUpResponse userSignUpResponse;

}
