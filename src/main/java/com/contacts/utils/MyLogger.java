/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.utils;

import org.apache.log4j.Logger;

/**
 * @author JavaTraining
 *
 */
public class MyLogger {
	
	private static final Logger logger = Logger.getLogger(MyLogger.class);
	
	private MyLogger(){
		
	}

	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return logger;
	}
	
}
