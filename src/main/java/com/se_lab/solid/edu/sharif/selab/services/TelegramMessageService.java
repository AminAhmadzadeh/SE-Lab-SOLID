package com.se_lab.solid.edu.sharif.selab.services;

import com.se_lab.solid.edu.sharif.selab.models.EmailMessage;
import com.se_lab.solid.edu.sharif.selab.models.SmsMessage;
import com.se_lab.solid.edu.sharif.selab.models.TelegramMessage;

import java.util.Objects;
import java.util.regex.Pattern;

public class TelegramMessageService implements MessageService{

    @Override
    public void sendSmsMessage(SmsMessage smsMessage) {
        //Empty Body
    }

    @Override
    public void sendEmailMessage(EmailMessage emailMessage) {
        //Empty Body
    }

    @Override
    public void sendTelegramMessage(TelegramMessage telegramMessage) {
        if (Objects.nonNull(telegramMessage.getSourceId())
                && Objects.nonNull(telegramMessage.getTargetId())) {
            if(validateTelegramId(telegramMessage.getSourceId())
                    && validateTelegramId(telegramMessage.getTargetId())){
                System.out.println("Sending a telegram message from " + telegramMessage.getSourceId() + " to " + telegramMessage.getTargetId() + " with content : " + telegramMessage.getContent());
            } else {
                throw new IllegalArgumentException("Id is Not Correct!");
            }
        } else {
            if(validatePhoneNumber(telegramMessage.getSourcePhoneNumber())
                    && validatePhoneNumber(telegramMessage.getTargetPhoneNumber())){
                System.out.println("Sending a telegram message from " + telegramMessage.getSourcePhoneNumber() + " to " + telegramMessage.getTargetPhoneNumber() + " with content : " + telegramMessage.getContent());
            } else {
                throw new IllegalArgumentException("Phone Number is Not Correct!");
            }
        }

    }

    public boolean validateTelegramId(String id) {
        // Regular expression pattern for validating id
        String idRegex = "^t.me/[a-zA-Z0-9-]{4,}$";

        // Compile the pattern into a regex Pattern object
        Pattern pattern = Pattern.compile(idRegex);

        // Check if the id string matches the regex pattern
        return pattern.matcher(id).matches();
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        // Check if the phone number is exactly 11 characters long
        if (phoneNumber.length() != 11) {
            return false; // Phone number length is not valid
        }

        // Check if the phone number contains only numeric digits
        for (char digit : phoneNumber.toCharArray()) {
            if (!Character.isDigit(digit)) {
                return false; // Phone number contains non-numeric characters
            }
        }

        // If all checks pass, return true (valid phone number)
        return true;
    }
}
