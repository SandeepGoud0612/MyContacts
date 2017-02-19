/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
	public static void setUp() {
		log = MyLogger.getLogger();
	}

	@Autowired
	private AddressDAO addressDAO;
	@Autowired
	private PersonDAO personDAO;

	@Ignore
	@Test
	public void createAddress() {
		Person personTransient = TestUtils.getPersonObject("createAddress");
		Person personPersisted = personDAO.save(personTransient);
		Address addressTransient = TestUtils.getAddressObject("createAddress");
		addressTransient.setPerson(personPersisted);
		Address addressPersisted = addressDAO.save(addressTransient);
		assertNotNull(addressPersisted);
		assertEquals(addressPersisted.getAddressLine1(), "Address Line 1 createAddress");
	}

	@Ignore
	@Test
	public void updateAddress() {
		Person personTransient = TestUtils.getPersonObject("updateAddress");
		Person personPersisted = personDAO.save(personTransient);
		Address addressTransient = TestUtils.getAddressObject("updateAddress");
		addressTransient.setPerson(personPersisted);
		Address addressPersisted = addressDAO.save(addressTransient);

		Address addressFromDB = addressDAO.findOne(addressPersisted.getId());
		addressFromDB.setAddressLine1(addressFromDB.getAddressLine1() + "updated");
		LocalDateTime ldt = LocalDateTime.now();
		Instant instant = ldt.toInstant(ZoneOffset.UTC);
		addressFromDB.setUpdatedDate(Date.from(instant));
		addressFromDB.setUpdatedUser("JavaTraining Update");
		Address addressFromDB2 = addressDAO.save(addressFromDB);

		assertNotNull(addressFromDB2);
		assertEquals(addressFromDB2.getAddressLine1(), "Address Line 1 updateAddress");

	}

	@Ignore
	@Test
	public void createAddresWithOutAddressLine2() {
		Person personTransient = TestUtils.getPersonObject("createAddresWithOutAddressLine2");
		Person personPersisted = personDAO.save(personTransient);
		Address addressTransient = TestUtils.getAddressObject("createAddresWithOutAddressLine2");
		addressTransient.setPerson(personPersisted);
		addressTransient.setAddressLine2(null);
		Address addressPersisted = addressDAO.save(addressTransient);

		assertNotNull(addressPersisted);
		assertEquals(addressPersisted.getAddressLine1(), "AddressLine1 createAddresWithOutAddressLine2");

	}

	@Ignore
	@Test
	public void findAll() {
		List<Address> addressList = addressDAO.findAll();

		log.info(addressList);

		assertNotNull(addressList);
	}

	@Ignore
	@Test(expected = javax.validation.ConstraintViolationException.class)
	public void createAddressLine1Empty() {
		Person personTransient = TestUtils.getPersonObject("createAddressLine1Empty");
		Person personPersisted = personDAO.save(personTransient);
		Address addressTransient = TestUtils.getAddressObject("createAddressLine1Empty");
		addressTransient.setPerson(personPersisted);
		addressTransient.setAddressLine1(null);
		addressDAO.save(addressTransient);

	}

	@Ignore
	@Test(expected = javax.validation.ConstraintViolationException.class)
	public void createCityWithMoreThanMax() {
		Person personTransient = TestUtils.getPersonObject("createCityWithMoreThanMax");
		Person personPersisted = personDAO.save(personTransient);
		Address addressTransient = TestUtils.getAddressObject("createCityWithMoreThanMax");
		addressTransient.setPerson(personPersisted);
		addressTransient.setCity(
				"olyxnbhbrgwogixciddtwahlphrrpmjjtghjprxbcvyoqhwgrctpipfirhdmuhpfovifcwccstkvqznpxrsldtmjekoduzuzhhiaebxhsub");
		addressDAO.save(addressTransient);
	}
	
	@Ignore
	@Test
	public void findAddressById() {
		Person personTransient = TestUtils.getPersonObject("addressFromDB");
		Person personPersisted = personDAO.save(personTransient);
		Address addressTransient = TestUtils.getAddressObject("addressFromDB");
		addressTransient.setPerson(personPersisted);
		Address addressPersisted = addressDAO.save(addressTransient);

		Address addressFromDB = addressDAO.findOne(addressPersisted.getId());

		log.info(addressFromDB);
	}
	
	@Ignore
	@Test
	public void deleteAddressById(){
		Person personTransient = TestUtils.getPersonObject("deleteAddressById");
		Person personPersisted = personDAO.save(personTransient);
		Address addressTransient = TestUtils.getAddressObject("deleteAddressById");
		addressTransient.setPerson(personPersisted);
		Address addressPersisted = addressDAO.save(addressTransient);
		addressDAO.delete(addressPersisted.getId());
		log.info("Deleting Address By Id" + addressPersisted.getId());
		
	}
}
