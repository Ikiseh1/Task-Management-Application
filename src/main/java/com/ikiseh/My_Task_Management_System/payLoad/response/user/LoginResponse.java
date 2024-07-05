package com.ikiseh.My_Task_Management_System.payLoad.response.user;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class LoginResponse {

    private String responseCode;

    private String responseMessage;

    private LoginInfo loginInfo;

    public LoginResponse(String responseCode, String responseMessage, LoginInfo loginInfo) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.loginInfo = loginInfo;
    }
}
