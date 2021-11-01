package com.secretescapes.paymentapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    AccountService accountService;

    @Autowired
    JavaMailSender javaMailSender;

    /* sendEmail method sends email to the recipient and sender
     * JavaMailSender service is used
     */
    public void sendEmail(Integer fromAccountId, Integer toAccountId) {
        String fromEmailAddress = accountService.findEmailByAccountId(fromAccountId);
        String toEmailAddress = accountService.findEmailByAccountId(toAccountId);

        SimpleMailMessage messageToSender = new SimpleMailMessage();
        SimpleMailMessage messageToReceiver = new SimpleMailMessage();

        messageToSender.setTo(toEmailAddress);
        messageToSender.setFrom(fromEmailAddress);
        messageToSender.setSubject("Payment successful");
        messageToSender.setText("You have received money!");

        messageToReceiver.setTo(fromEmailAddress);
        messageToReceiver.setFrom(toEmailAddress);
        messageToReceiver.setSubject("Payment successful");
        messageToReceiver.setText("Your transaction is successful!");
        try {
            javaMailSender.send(messageToSender);
            javaMailSender.send(messageToReceiver);
            LOGGER.info("Emails sent to the sender and receiver!");
        } catch (MailException e) {
            LOGGER.error("Error occured during the email sending process", e);
        }
    }

}
