package com.se_lab.solid.edu.sharif.selab.services;

import com.se_lab.solid.edu.sharif.selab.models.EmailMessage;
import com.se_lab.solid.edu.sharif.selab.models.SmsMessage;

public interface MessageService {

    void sendSmsMessage(SmsMessage smsMessage);
    void sendEmailMessage(EmailMessage emailMessage);

}
