package com.se_lab.solid;

import com.se_lab.solid.edu.sharif.selab.models.EmailMessage;
import com.se_lab.solid.edu.sharif.selab.models.Message;
import com.se_lab.solid.edu.sharif.selab.models.SmsMessage;
import com.se_lab.solid.edu.sharif.selab.models.TelegramMessage;
import com.se_lab.solid.edu.sharif.selab.services.EmailMessageService;
import com.se_lab.solid.edu.sharif.selab.services.MessageService;
import com.se_lab.solid.edu.sharif.selab.services.SmsMessageService;
import com.se_lab.solid.edu.sharif.selab.services.TelegramMessageService;

import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Hello and Welcome to SE Lab Messenger.");
        int userAnswer=0;
        do{
            Message message = null;
            MessageService messageService;
            String source;
            String target;
            String content;

            System.out.println("In order to send Sms message enter 1");
            System.out.println("In order to send Email message enter 2");
            System.out.println("In order to send Telegram message enter 3");
            System.out.println("In order to Exit, Enter 0");

            userAnswer= scanner.nextInt();

            if(userAnswer==0){
                break;
            }

            switch (userAnswer){
                case 1:
                    SmsMessage smsMessage = new SmsMessage();
                    System.out.print("Enter source phone : ");
                    source = scanner.next();
                    smsMessage.setSourcePhoneNumber(source);
                    System.out.print("Enter target phone : ");
                    target = scanner.next();
                    smsMessage.setTargetPhoneNumber(target);
                    System.out.println("Write Your Message : ");
                    content = scanner.next(".*$");
                    smsMessage.setContent(content);
                    message = smsMessage;
                    break;
                case 2:
                    EmailMessage emailMessage = new EmailMessage();
                    System.out.print("Enter source phone : ");
                    source = scanner.next();
                    emailMessage.setSourceEmailAddress(source);
                    System.out.print("Enter target phone : ");
                    target = scanner.next();
                    emailMessage.setTargetEmailAddress(target);
                    System.out.println("Write Your Message : ");
                    content = scanner.next();
                    emailMessage.setContent(content);
                    message = emailMessage;
                    break;
                case 3:
                    TelegramMessage telegramMessage = new TelegramMessage();
                    System.out.println("In order to send message by id enter 1 or by phone number enter 2");
                    source = scanner.next();
                    if (source.equalsIgnoreCase("1")) {
                        System.out.print("Enter source id : ");
                        source = scanner.next();
                        telegramMessage.setSourceId(source);
                        System.out.print("Enter target id : ");
                        target = scanner.next();
                        telegramMessage.setTargetId(target);
                    } else if (source.equalsIgnoreCase("2")) {
                        System.out.print("Enter source phone : ");
                        source = scanner.next();
                        telegramMessage.setSourcePhoneNumber(source);
                        System.out.print("Enter target phone : ");
                        target = scanner.next();
                        telegramMessage.setTargetPhoneNumber(target);
                    } else {
                        continue;
                    }
                    System.out.println("Write Your Message : ");
                    content = scanner.next();
                    telegramMessage.setContent(content);
                    message = telegramMessage;
                    break;

            }

            if(message instanceof SmsMessage){
                messageService = new SmsMessageService();
                messageService.sendMessage(message);
            }else if(message instanceof EmailMessage){
                messageService = new EmailMessageService();
                messageService.sendMessage(message);
            } else if (message instanceof TelegramMessage){
                messageService = new TelegramMessageService();
                messageService.sendMessage(message);
            }

        }while (true);
    }
}