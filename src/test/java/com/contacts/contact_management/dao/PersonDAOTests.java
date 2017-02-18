/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.contacts.contact_management.model.Image;
import com.contacts.contact_management.model.Person;
import com.contacts.utils.MyLogger;

/**
 * @author Sandeep
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(true) 
public class PersonDAOTests {

	private static Logger log;

	@BeforeClass
	public static void setUp() {
		log = MyLogger.getLogger();
	}

	@Autowired
	private PersonDAO personDAO;

	@Ignore
	@Test
	public void createPerson() {
		Person personTransient = TestUtils.getPersonObject("createPerson");
		Person personPersisted = personDAO.save(personTransient);
		
		assertNotNull(personPersisted);
		assertEquals(personPersisted.getFirstName(), "FirstName createPerson");
	}

	@Ignore
	@Test
	public void createPersonWithImage() {
		Person personTransient = TestUtils.getPersonObject("createPersonWithImage");
		Image imageTransient = TestUtils.getImageObject("createPersonWithImage", "D:\\images\\image1.jpg");
		imageTransient.setPerson(personTransient);
		personTransient.setImage(imageTransient);
		Person personPersisted = personDAO.save(personTransient);

		assertNotNull(personPersisted);
		assertNotNull(personPersisted.getImage());
		assertEquals(personPersisted.getFirstName(), "FirstName createPersonWithImage");
		assertEquals(personPersisted.getImage().getTag(), "Flower createPersonWithImage");
	}
	
	@Ignore
	@Test
	public void deleteImageFromPerson(){
		Person personTransient = TestUtils.getPersonObject("deleteImageFromPerson");
		Image imageTransient = TestUtils.getImageObject("deleteImageFromPerson", "D:\\images\\image1.jpg");
		imageTransient.setPerson(personTransient);
		personTransient.setImage(imageTransient);
		Person personPersisted = personDAO.save(personTransient);

		assertNotNull(personPersisted);
		assertNotNull(personPersisted.getImage());
		assertEquals(personPersisted.getFirstName(), "FirstName createPersonWithImage");
		assertEquals(personPersisted.getImage().getTag(), "Flower createPersonWithImage");
		
		personPersisted.getImage().setPerson(null);
		personPersisted.setImage(null);
		Person personUpdated = personDAO.save(personPersisted);
		assertNotNull(personUpdated);
		assertNull(personUpdated.getImage());
	}
	
	    //@Ignore
		@Test
		public void deletePersonWithImage(){
			Person personTransient = TestUtils.getPersonObject("deleteImageFromPerson");
			Image imageTransient = TestUtils.getImageObject("deleteImageFromPerson", "D:\\images\\image1.jpg");
			imageTransient.setPerson(personTransient);
			personTransient.setImage(imageTransient);
			Person personPersisted = personDAO.save(personTransient);

			assertNotNull(personPersisted);
			assertNotNull(personPersisted.getImage());
			assertEquals(personPersisted.getFirstName(), "FirstName createPersonWithImage");
			assertEquals(personPersisted.getImage().getTag(), "Flower createPersonWithImage");
			
			personDAO.delete(personPersisted.getId());
		}

	@Ignore
	@Test
	public void createPersonDOBEmpty() {
		Person personTransient = TestUtils.getPersonObject("createPersonDOBEmpty");
		personTransient.setDob(null);
		Person personPersisted = personDAO.save(personTransient);

		assertNotNull(personPersisted);
		assertEquals(personPersisted.getFirstName(), "FirstName createPersonDOBEmpty");
	}

	@Ignore
	@Test
	public void findPersonById() {
		Person personTransient = TestUtils.getPersonObject("findPersonById");
		Person personPersisted = personDAO.save(personTransient);

		Person personFromDB = personDAO.findOne(personPersisted.getId());
		personFromDB.setAddressList(new ArrayList<>());
		personFromDB.setOccasionList(new ArrayList<>());

		assertNotNull(personFromDB);
		assertEquals(personFromDB.getFirstName(), "FirstName findPersonById");
		log.info(personFromDB);
	}

	@Ignore
	@Test
	public void updatePerson() {
		Person personTransient = TestUtils.getPersonObject("updatePerson");
		Person personPersisted = personDAO.save(personTransient);

		Person personFromDB = personDAO.findOne(personPersisted.getId());
		personFromDB.setFirstName(personFromDB.getFirstName() + " Updated");
		LocalDateTime ldt = LocalDateTime.now();
		Instant instant = ldt.toInstant(ZoneOffset.UTC);
		personFromDB.setUpdatedDate(Date.from(instant));
		personFromDB.setUpdatedUser("JavaTraining Update");
		Person personFromDB2 = personDAO.save(personFromDB);

		assertNotNull(personFromDB2);
		assertEquals(personFromDB2.getFirstName(), "FirstName updatePerson Updated");
	}

	@Ignore
	@Test
	public void deletePerson() {
		Person personTransient = TestUtils.getPersonObject("updatePerson");
		Person personPersisted = personDAO.save(personTransient);
		personDAO.delete(personPersisted.getId());
		log.info("Deleting Person " + personPersisted.getId());
	}

	@Ignore
	@Test
	public void findAll() {
		List<Person> persons = personDAO.findAll();
		for (Person person : persons) {
			person.setAddressList(new ArrayList<>());
			person.setOccasionList(new ArrayList<>());
			log.info(person);
		}
		assertNotNull(persons);
	}

	@Ignore
	@Test(expected = javax.validation.ConstraintViolationException.class)
	public void createPersonWithInvalidEmailId() {
		Person personTransient = TestUtils.getPersonObject("createPersonWithInvalidEmailId");
		personTransient.setEmailId("EmailId");
		personTransient.setAlternateEmailId("AlternateEmailId");
		personDAO.save(personTransient);
	}

	@Ignore
	@Test(expected = javax.validation.ConstraintViolationException.class)
	public void createPersonWithInvalidPhoneNumber() {
		Person personTransient = TestUtils.getPersonObject("createPersonWithInvalidPhoneNumber");
		personTransient.setPhoneNumber(9111145678904324324L);
		personTransient.setAlternatePhoneNumber(912224567890432434L);
		personDAO.save(personTransient);
	}

	@Ignore
	@Test(expected = javax.validation.ConstraintViolationException.class)
	public void createPersonInvalidFirstNameEmpty() {
		Person personTransient = TestUtils.getPersonObject("createPersonInvalidFirstNameEmpty");
		personTransient.setFirstName("");
		personDAO.save(personTransient);
	}

	@Ignore
	@Test(expected = javax.validation.ConstraintViolationException.class)
	public void createPersonInvalidDOB() {
		Person personTransient = TestUtils.getPersonObject("createPersonInvalidDOB");
		personTransient.setDob(Date.valueOf(LocalDate.of(2020, Month.FEBRUARY, 28)));
		personDAO.save(personTransient);
	}

}
