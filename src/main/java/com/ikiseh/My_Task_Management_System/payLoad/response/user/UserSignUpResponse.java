package com.ikiseh.My_Task_Management_System.payLoad.response.user;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSignUpResponse {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;


}
