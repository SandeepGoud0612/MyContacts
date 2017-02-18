/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.dao;

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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.contacts.contact_management.enums.Gender;
import com.contacts.contact_management.model.Person;
import com.contacts.utils.MyLogger;

/**
 * @author Sandeep
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonDAOTests {

	private static Logger log;

	@BeforeClass
	public static void setUp() {
		log = MyLogger.getLogger();
	}

	@Autowired
	private PersonDAO personDAO;

	@Test
	public void createPerson() {
		Person person = new Person();
		person.setFirstName("FirstName createPerson");
		person.setLastName("LastName1 createPerson");
		person.setGender(Gender.Male);
		person.setDob(Date.valueOf(LocalDate.now()));
		person.setEmailId("EmailId1@gmail.com");
		person.setAlternateEmailId("AlternateEmailId1@gmail.com");
		person.setPhoneNumber(911114567890L);
		person.setAlternatePhoneNumber(912224567890L);
		person.setMaritalStatus(false);
		personDAO.save(person);
	}

	@Test
	public void createPersonWithInvalidEmailId() {
		Person person = new Person();
		person.setFirstName("FirstName createPersonWithInvalidEmailId");
		person.setLastName("LastName1 createPersonWithInvalidEmailId");
		person.setGender(Gender.Male);
		person.setDob(Date.valueOf(LocalDate.now()));
		person.setEmailId("EmailId1");
		person.setAlternateEmailId("AlternateEmailId1");
		person.setPhoneNumber(911114567890L);
		person.setAlternatePhoneNumber(912224567890L);
		person.setMaritalStatus(false);
		personDAO.save(person);
	}

	@Test
	public void createPersonWithInvalidPhoneNumber() {
		Person person = new Person();
		person.setFirstName("FirstName createPersonWithInvalidEmailId");
		person.setLastName("LastName1 createPersonWithInvalidEmailId");
		person.setGender(Gender.Male);
		person.setDob(Date.valueOf(LocalDate.now()));
		person.setEmailId("EmailId1");
		person.setAlternateEmailId("AlternateEmailId1");
		person.setPhoneNumber(9111145678904324324L);
		person.setAlternatePhoneNumber(912224567890432434L);
		person.setMaritalStatus(false);
		personDAO.save(person);
	}

	@Test
	public void createPersonFirstNameEmpty() {
		Person person = new Person();
		person.setLastName("LastName1 createPersonFirstNameEmpty");
		person.setGender(Gender.Male);
		person.setDob(Date.valueOf(LocalDate.now()));
		person.setEmailId("EmailId1@gmail.com");
		person.setAlternateEmailId("AlternateEmailId1@gmail.com");
		person.setPhoneNumber(911114567890L);
		person.setAlternatePhoneNumber(912224567890L);
		person.setMaritalStatus(false);
		personDAO.save(person);
	}
	
	@Test
	public void createPersonInvalidDOB() {
		Person person = new Person();
		person.setFirstName("FirstName createPerson");
		person.setLastName("LastName1 createPerson");
		person.setGender(Gender.Male);
		person.setDob(Date.valueOf(LocalDate.of(2017, Month.FEBRUARY, 28)));
		person.setEmailId("EmailId1@gmail.com");
		person.setAlternateEmailId("AlternateEmailId1@gmail.com");
		person.setPhoneNumber(911114567890L);
		person.setAlternatePhoneNumber(912224567890L);
		person.setMaritalStatus(false);
		personDAO.save(person);
	}

	@Test
	public void createPersonDOBEmpty() {
		Person person = new Person();
		person.setFirstName("LastName1 createPersonDOBEmpty");
		person.setLastName("LastName1 createPersonDOBEmpty");
		person.setGender(Gender.Male);
		person.setEmailId("EmailId1@gmail.com");
		person.setAlternateEmailId("AlternateEmailId1@gmail.com");
		person.setPhoneNumber(911114567890L);
		person.setAlternatePhoneNumber(912224567890L);
		person.setMaritalStatus(false);
		personDAO.save(person);
	}

	@Test
	public void findPersonById() {
		Person person = new Person();
		person.setFirstName("FirstName findPersonById");
		person.setLastName("LastName1 findPersonById");
		person.setGender(Gender.Male);
		person.setDob(Date.valueOf(LocalDate.now()));
		person.setEmailId("EmailId1@gmail.com");
		person.setAlternateEmailId("AlternateEmailId1@gmail.com");
		person.setPhoneNumber(911114567890L);
		person.setAlternatePhoneNumber(912224567890L);
		person.setMaritalStatus(false);
		Long id = personDAO.save(person).getId();

		Person person1 = personDAO.findOne(id);
		person1.setAddressList(new ArrayList<>());
		person1.setOccasionList(new ArrayList<>());
		log.info(person1);
	}

	@Test
	public void updatePerson() {
		Person person = new Person();
		person.setFirstName("FirstName updatePerson");
		person.setLastName("LastName1 updatePerson");
		person.setGender(Gender.Male);
		person.setDob(Date.valueOf(LocalDate.now()));
		person.setEmailId("EmailId1@gmail.com");
		person.setAlternateEmailId("AlternateEmailId1@gmail.com");
		person.setPhoneNumber(911114567890L);
		person.setAlternatePhoneNumber(912224567890L);
		person.setMaritalStatus(false);
		Long id = personDAO.save(person).getId();

		Person person1 = personDAO.findOne(id);
		person1.setFirstName(person.getFirstName() + " Updated");
		LocalDateTime ldt = LocalDateTime.now();
		Instant instant = ldt.toInstant(ZoneOffset.UTC);
		person1.setUpdatedDate(Date.from(instant));
		person1.setUpdatedUser("JavaTraining Update");
		personDAO.save(person1);
		log.info(person1);
	}

	@Test
	public void deletePerson() {
		Person person = new Person();
		person.setFirstName("FirstName deletePerson");
		person.setLastName("LastName1 deletePerson");
		person.setGender(Gender.Male);
		person.setDob(Date.valueOf(LocalDate.now()));
		person.setEmailId("EmailId1@gmail.com");
		person.setAlternateEmailId("AlternateEmailId1@gmail.com");
		person.setPhoneNumber(911114567890L);
		person.setAlternatePhoneNumber(912224567890L);
		person.setMaritalStatus(false);
		Long id = personDAO.save(person).getId();

		log.info("Deleting Person " + id);

		personDAO.delete(id);
	}

	@Test
	public void findAll() {
		List<Person> persons = personDAO.findAll();
		for (Person person : persons) {
			log.info(person);
		}
	}

}
