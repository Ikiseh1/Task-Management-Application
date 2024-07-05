package com.ikiseh.My_Task_Management_System.payLoad.request.user;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginRequest {

    private String email;
    private String password;
}
