package com.contacts.notification_management.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class EmilService {
	
	private static final Logger log = LoggerFactory.getLogger(EmilService.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 10000)
	public void invoke() {
		log.info("The time is now {}", dateFormat.format(new Date()));
	}


}
