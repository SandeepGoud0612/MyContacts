package com.contacts.notification_management.service;

import java.time.Instant;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.contacts.contact_management.model.Occasion;
import com.contacts.contact_management.service.OccasionService;
import com.contacts.utils.MyLogger;

@Component
@PropertySource("classpath:mail.properties")
public class EmilService {

	private Logger log = MyLogger.getLogger();

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private OccasionService occasionService;

	@Value("${mail.to}")
	private String toAddress;

	@Scheduled(cron = "0 0 5 * * *")
	public void sendOccasionsRemainderMail() {
		log.info("Sending email");

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toAddress);
		message.setSubject("Occasions on :: " + Date.from(Instant.now()));

		StringBuilder builder = new StringBuilder("");
		for (Occasion occasion : occasionService.getAllOccasionsByCurrentDate()) {
			builder.append("Name :: " + occasion.getPerson().getFirstName() + " " + occasion.getPerson().getLastName() + "  Occasion :: " + occasion.getName());
			builder.append("\r\n");
			builder.append("\r\n");
		}

		message.setText(builder.toString());
		mailSender.send(message);
		log.info("Email sent");
	}

}
