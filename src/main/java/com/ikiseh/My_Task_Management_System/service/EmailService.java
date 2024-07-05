package com.ikiseh.My_Task_Management_System.service;

import com.ikiseh.My_Task_Management_System.payLoad.request.EmailDetails;

public interface EmailService {

     void sendVerificationEmail(EmailDetails emailDetails);

}
