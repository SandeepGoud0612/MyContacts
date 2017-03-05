/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

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
		Person personTransient = TestUtils.getPersonObject();
		Person personPersisted = personDAO.save(personTransient);
		Address addressTransient = TestUtils.getAddressObject();
		addressTransient.setPerson(personPersisted);
		Address addressPersisted = addressDAO.save(addressTransient);
		assertNotNull(addressPersisted);
		assertEquals("Address Line 1 createAddress", addressPersisted.getAddressLine1());
	}

	@Ignore
	@Test
	public void updateAddress() {
		Person personTransient = TestUtils.getPersonObject();
		Person personPersisted = personDAO.save(personTransient);
		Address addressTransient = TestUtils.getAddressObject();
		addressTransient.setPerson(personPersisted);
		Address addressPersisted = addressDAO.save(addressTransient);

		Address addressFromDB = addressDAO.findOne(addressPersisted.getId());
		addressFromDB.setAddressLine1(addressFromDB.getAddressLine1() + " updated");
		addressFromDB.setUpdatedDate(Date.from(Instant.now()));
		addressFromDB.setUpdatedUser("JavaTraining Update");
		Address addressFromDB2 = addressDAO.save(addressFromDB);

		assertNotNull(addressFromDB2);
		assertEquals("Address Line 1 updateAddress updated", addressFromDB2.getAddressLine1());
	}

	@Ignore
	@Test
	public void createAddressWithOutAddressLine2() {
		Person personTransient = TestUtils.getPersonObject();
		Person personPersisted = personDAO.save(personTransient);
		Address addressTransient = TestUtils.getAddressObject();
		addressTransient.setPerson(personPersisted);
		addressTransient.setAddressLine2(null);
		Address addressPersisted = addressDAO.save(addressTransient);

		assertNotNull(addressPersisted);
		assertEquals("Address Line 1 createAddresWithOutAddressLine2", addressPersisted.getAddressLine1());
	}

	@Ignore
	@Test
	public void findAll() {
		List<Address> addressList = addressDAO.findAll();
		for (Address address : addressList) {
			log.info(address);
		}
		assertNotNull(addressList);
	}

	@Ignore
	@Test(expected = javax.validation.ConstraintViolationException.class)
	public void createAddressLine1Empty() {
		Person personTransient = TestUtils.getPersonObject();
		Person personPersisted = personDAO.save(personTransient);
		Address addressTransient = TestUtils.getAddressObject();
		addressTransient.setPerson(personPersisted);
		addressTransient.setAddressLine1(null);
		addressDAO.save(addressTransient);
	}

	@Ignore
	@Test(expected = javax.validation.ConstraintViolationException.class)
	public void createCityWithMoreThanMax() {
		Person personTransient = TestUtils.getPersonObject();
		Person personPersisted = personDAO.save(personTransient);
		Address addressTransient = TestUtils.getAddressObject();
		addressTransient.setPerson(personPersisted);
		addressTransient.setCity(
				"olyxnbhbrgwogixciddtwahlphrrpmjjtghjprxbcvyoqhwgrctpipfirhdmuhpfovifcwccstkvqznpxrsldtmjekoduzuzhhiaebxhsub");
		addressDAO.save(addressTransient);
	}

	@Ignore
	@Test
	public void findAddressById() {
		Person personTransient = TestUtils.getPersonObject();
		Person personPersisted = personDAO.save(personTransient);
		Address addressTransient = TestUtils.getAddressObject();
		addressTransient.setPerson(personPersisted);
		Address addressPersisted = addressDAO.save(addressTransient);
		Address addressFromDB = addressDAO.findOne(addressPersisted.getId());

		assertNotNull(addressFromDB);
		assertEquals("Address Line 1 addressFromDB", addressFromDB.getAddressLine1());
	}

	@Ignore
	@Test
	public void deleteAddressById() {
		Person personTransient = TestUtils.getPersonObject();
		Person personPersisted = personDAO.save(personTransient);
		Address addressTransient = TestUtils.getAddressObject();
		addressTransient.setPerson(personPersisted);
		Address addressPersisted = addressDAO.save(addressTransient);
		addressDAO.delete(addressPersisted.getId());
		log.info("Deleting Address By Id" + addressPersisted.getId());
	}
}
