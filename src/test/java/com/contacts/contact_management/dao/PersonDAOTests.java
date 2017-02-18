/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.dao;

import java.sql.Date;
import java.time.LocalDate;
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
		person.setEmailId("EmailId1@gmail.com createPerson");
		person.setAlternateEmailId("AlternateEmailId1@gmail.com createPerson");
		person.setPhoneNumber("111-456-7890");
		person.setAlternatePhoneNumber("222-456-7890");
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
		person.setEmailId("EmailId1@gmail.com findPersonById");
		person.setAlternateEmailId("AlternateEmailId1@gmail.com findPersonById");
		person.setPhoneNumber("111-456-7890");
		person.setAlternatePhoneNumber("222-456-7890");
		person.setMaritalStatus(false);
		Long id = personDAO.save(person).getId();

		Person person1 = personDAO.findOne(id);
		log.info(person1);
	}

	@Test
	public void updatePerson() {
		Person person = new Person();
		person.setFirstName("FirstName updatePerson");
		person.setLastName("LastName1 updatePerson");
		person.setGender(Gender.Male);
		person.setDob(Date.valueOf(LocalDate.now()));
		person.setEmailId("EmailId1@gmail.com updatePerson");
		person.setAlternateEmailId("AlternateEmailId1@gmail.com updatePerson");
		person.setPhoneNumber("111-456-7890");
		person.setAlternatePhoneNumber("222-456-7890");
		person.setMaritalStatus(false);
		Long id = personDAO.save(person).getId();

		Person person1 = personDAO.findOne(id);
		person1.setFirstName(person.getFirstName() + " Updated");
		person1.setUpdatedDate(Date.valueOf(LocalDate.now()));
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
		person.setEmailId("EmailId1@gmail.com deletePerson");
		person.setAlternateEmailId("AlternateEmailId1@gmail.com deletePerson");
		person.setPhoneNumber("111-456-7890");
		person.setAlternatePhoneNumber("222-456-7890");
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
