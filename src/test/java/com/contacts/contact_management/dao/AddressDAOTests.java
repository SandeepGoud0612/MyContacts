/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.contacts.contact_management.enums.Gender;
import com.contacts.contact_management.model.Address;
import com.contacts.contact_management.model.Person;
import com.contacts.utils.MyLogger;

/**
 * @author manoj
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressDAOTests {

	private static Logger log;
	
	@BeforeClass
	public static void setUp(){
		log = MyLogger.getLogger();
	}
	
	@Autowired
	private AddressDAO addressDAO;
	@Autowired
	private PersonDAO personDAO;
	
	@Test
	public void createAddress(){
		Person personTransient = TestUtils.getPersonObject("createAddress");
		Person personPersisted = personDAO.save(personTransient);
		Address addressTransient = TestUtils.getAddressObject("createAddress");
		addressTransient.setPerson(personPersisted);
		Address addressPersisted = addressDAO.save(addressTransient);
		assertNotNull(addressPersisted);
		assertEquals(addressPersisted.getAddressLine1(), "Address Line 1 createAddress");
	}
	
	public void updateAddress(){		
		Person personTransient = TestUtils.getPersonObject("updateAddress");
		Person personPersisted = personDAO.save(personTransient);
		Address addressTransient = TestUtils.getAddressObject("updateAddress");
		addressTransient.setPerson(personPersisted);
		
		
		
	}
	
	

}
