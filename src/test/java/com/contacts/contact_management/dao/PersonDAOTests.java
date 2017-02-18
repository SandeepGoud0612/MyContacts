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
	private static Long index = 0L;

	@BeforeClass
	public static void setUp() {
		log = MyLogger.getLogger();
	}

	@Autowired
	private PersonDAO personDAO;

	@Test
	public void createPerson() {
		index++;
		Person person1 = new Person();
		person1.setFirstName("FirstName" + index);
		person1.setLastName("LastName1" + index);
		person1.setGender(Gender.Male);
		person1.setDob(Date.valueOf(LocalDate.now()));
		person1.setEmailId("EmailId1@gmail.com" + index);
		person1.setAlternateEmailId("AlternateEmailId1@gmail.com" + index);
		person1.setPhoneNumber("111-456-7890" + index);
		person1.setAlternatePhoneNumber("222-456-7890" + index);
		person1.setMaritalStatus(false);
		personDAO.save(person1);
	}

	@Test
	public void findPersonById() {
		createPerson();
		Person person = personDAO.findOne(3L);
		log.info(person);
	}

	@Test
	public void updatePerson() {
		createPerson();
		Person person = personDAO.findOne(4L);
		person.setFirstName(person.getFirstName() + "Updated");
		person.setUpdatedDate(Date.valueOf(LocalDate.now()));
		personDAO.save(person);
		log.info(person);
	}

	@Test
	public void deletePerson() {
		createPerson();
		personDAO.delete(5L);
	}

	@Test
	public void findAll() {
		List<Person> persons = personDAO.findAll();
		for (Person person : persons) {
			log.info(person);
		}
	}

}
