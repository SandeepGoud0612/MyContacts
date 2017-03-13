package com.contacts.notification_management.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmilService {
	
	private static final Logger log = LoggerFactory.getLogger(EmilService.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 5000)
	public void invoke() {
		log.info("The time is now {}", dateFormat.format(new Date()));
		//prepareAndSend();
	}
	
	private JavaMailSender mailSender;
	 
    @Autowired
    public EmilService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
	
	public void prepareAndSend() {
		SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("foo@example.com");
        message.setTo("sandeepgoud0612@gmail.com");
        message.setSubject("hello");
        mailSender.send(message);
	}


}
