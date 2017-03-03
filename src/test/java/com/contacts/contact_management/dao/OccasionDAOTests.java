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

import com.contacts.contact_management.model.Occasion;
import com.contacts.contact_management.model.Person;
import com.contacts.utils.MyLogger;

/**
 * @author Sindhu
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OccasionDAOTests {

	private static Logger log;

	@BeforeClass
	public static void setUp() {
		log = MyLogger.getLogger();
	}

	@Autowired
	private OccasionDAO occasionDAO;

	@Autowired
	private PersonDAO personDAO;

	@Ignore
	@Test
	public void createOccasion() {
		Person personTransient = TestUtils.getPersonObject("createOccasion");
		Person personPersistent = personDAO.save(personTransient);
		Occasion occasionTransient = TestUtils.getOccasionObject("createOccasion");
		occasionTransient.setPerson(personPersistent);
		Occasion occasionPersisted = occasionDAO.save(occasionTransient);
		assertNotNull(occasionPersisted);
		assertEquals("Occasion createOccasion", occasionPersisted.getName());
	}

	@Ignore
	@Test(expected = javax.validation.ConstraintViolationException.class)
	public void createOccasionWithEmptyName() {
		Person personTransient = TestUtils.getPersonObject("createOccasion");
		Person personPersistent = personDAO.save(personTransient);
		Occasion occasionTransient = TestUtils.getOccasionObject("createOccasionWithEmptyName");
		occasionTransient.setName("");
		occasionTransient.setPerson(personPersistent);
		Occasion occasionPersisted = occasionDAO.save(occasionTransient);
		assertNotNull(occasionPersisted);
	}

	@Ignore
	@Test(expected = javax.validation.ConstraintViolationException.class)
	public void createOccasionWithEmptyDate() {
		Person personTransient = TestUtils.getPersonObject("createOccasionWithEmptyDate");
		Person personPersistent = personDAO.save(personTransient);
		Occasion occasionTransient = TestUtils.getOccasionObject("createOccasionWithEmptyDate");
		occasionTransient.setDate(null);
		occasionTransient.setPerson(personPersistent);
		Occasion occasionPersisted = occasionDAO.save(occasionTransient);
		assertNotNull(occasionPersisted);
	}

	@Ignore
	@Test
	public void createOccasionWithFalseRemindMe() {
		Person personTransient = TestUtils.getPersonObject("createOccasionWithFalseRemindMe");
		Person personPersistent = personDAO.save(personTransient);
		Occasion occasionTransient = TestUtils.getOccasionObject("createOccasionWithFalseRemindMe");
		occasionTransient.setRemindMe(false);
		occasionTransient.setPerson(personPersistent);
		Occasion occasionPersisted = occasionDAO.save(occasionTransient);
		assertNotNull(occasionPersisted);
	}

	@Ignore
	@Test
	public void getOccasionById() {
		Person personTransient = TestUtils.getPersonObject("getOccasionById");
		Person personPersistent = personDAO.save(personTransient);
		Occasion occasionTransient = TestUtils.getOccasionObject("getOccasionById");
		occasionTransient.setPerson(personPersistent);
		Occasion occasionPersisted = occasionDAO.save(occasionTransient);
		assertNotNull(occasionPersisted);
		Occasion occasionFromDB = occasionDAO.findOne(occasionPersisted.getId());
		assertNotNull(occasionFromDB);
		assertEquals("Occasion getOccasionById", occasionFromDB.getName());
		log.info(occasionFromDB);
	}

	@Ignore
	@Test
	public void updateOccasion() {
		Person personTransient = TestUtils.getPersonObject("updateOccasion");
		Person personPersistent = personDAO.save(personTransient);
		Occasion occasionTransient = TestUtils.getOccasionObject("updateOccasion");
		occasionTransient.setPerson(personPersistent);
		Occasion occasionPersisted = occasionDAO.save(occasionTransient);
		Occasion occasionFromDB = occasionDAO.findOne(occasionPersisted.getId());

		occasionFromDB.setName(occasionFromDB.getName() + " updated");
		occasionFromDB.setRemindMe(true);
		occasionFromDB.setUpdatedDate(Date.from(Instant.now()));
		occasionFromDB.setUpdatedUser("Occasion Update");
		Occasion occasionupdate = occasionDAO.save(occasionFromDB);

		assertNotNull(occasionupdate);
		assertEquals("Occasion updateOccasion updated", occasionupdate.getName());
	}

	@Ignore
	@Test
	public void deleteOccasion() {
		Person personTransient = TestUtils.getPersonObject("updateOccasion");
		Person personPersistent = personDAO.save(personTransient);
		Occasion occasionTransient = TestUtils.getOccasionObject("updateOccasion");
		occasionTransient.setPerson(personPersistent);
		Occasion occasionPersisted = occasionDAO.save(occasionTransient);

		assertNotNull(occasionPersisted);

		occasionDAO.delete(occasionPersisted);
		log.info("Occasion deleted " + occasionPersisted.getId());
	}

	@Ignore
	@Test
	public void findAllOccasions() {
		List<Occasion> occasions = occasionDAO.findAll();
		for (Occasion occasion : occasions) {
			log.info(occasion);
		}
		assertNotNull(occasions);
	}
}