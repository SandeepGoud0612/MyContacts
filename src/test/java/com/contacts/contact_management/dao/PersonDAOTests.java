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

import com.contacts.contact_management.model.Address;
import com.contacts.contact_management.model.Image;
import com.contacts.contact_management.model.Occasion;
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

	//@Ignore
	@Test
	public void createPersonWithAllDetails() {
		Person personTransient = TestUtils.getPersonObject();

		/*Image imageTransient = TestUtils.getImageObject("", "D:\\images\\image1.jpg");
		personTransient.setImage(imageTransient);
		imageTransient.setPerson(personTransient);*/

		Address addressTransient1 = TestUtils.getAddressObject();
		Address addressTransient2 = TestUtils.getAddressObject();
		Address addressTransient3 = TestUtils.getAddressObject();
		Address addressTransient4 = TestUtils.getAddressObject();
		Address addressTransient5 = TestUtils.getAddressObject();
		Address addressTransient6 = TestUtils.getAddressObject();
		personTransient.getAddressList().add(addressTransient1);
		personTransient.getAddressList().add(addressTransient2);
		personTransient.getAddressList().add(addressTransient3);
		personTransient.getAddressList().add(addressTransient4);
		personTransient.getAddressList().add(addressTransient5);
		personTransient.getAddressList().add(addressTransient6);
		addressTransient1.setPerson(personTransient);
		addressTransient2.setPerson(personTransient);
		addressTransient3.setPerson(personTransient);
		addressTransient4.setPerson(personTransient);
		addressTransient5.setPerson(personTransient);
		addressTransient6.setPerson(personTransient);

		Occasion occasionTransient1 = TestUtils.getOccasionObject();
		Occasion occasionTransient2 = TestUtils.getOccasionObject();
		Occasion occasionTransient3 = TestUtils.getOccasionObject();
		Occasion occasionTransient4 = TestUtils.getOccasionObject();
		Occasion occasionTransient5 = TestUtils.getOccasionObject();
		Occasion occasionTransient6 = TestUtils.getOccasionObject();
		personTransient.getOccasionList().add(occasionTransient1);
		personTransient.getOccasionList().add(occasionTransient2);
		personTransient.getOccasionList().add(occasionTransient3);
		personTransient.getOccasionList().add(occasionTransient4);
		personTransient.getOccasionList().add(occasionTransient5);
		personTransient.getOccasionList().add(occasionTransient6);
		occasionTransient1.setPerson(personTransient);
		occasionTransient2.setPerson(personTransient);
		occasionTransient3.setPerson(personTransient);
		occasionTransient4.setPerson(personTransient);
		occasionTransient5.setPerson(personTransient);
		occasionTransient6.setPerson(personTransient);

		Person personPersisted = personDAO.save(personTransient);
		assertNotNull(personPersisted);
		assertNotNull(personPersisted.getAddressList());
		assertEquals("FirstName", personPersisted.getFirstName());
	}

    @Ignore
	@Test
	public void updatePersonWithAllDetails() {
		Person personTransient = TestUtils.getPersonObject();

		Image imageTransient = TestUtils.getImageObject("D:\\images\\image1.jpg");
		imageTransient.setPerson(personTransient);
		personTransient.setImage(imageTransient);

		Address addressTransient1 = TestUtils.getAddressObject();
		addressTransient1.setPerson(personTransient);
		personTransient.getAddressList().add(addressTransient1);

		Occasion occasionTransient1 = TestUtils.getOccasionObject();
		occasionTransient1.setPerson(personTransient);
		personTransient.getOccasionList().add(occasionTransient1);

		Person personPersisted = personDAO.save(personTransient);

		Person personFromDB = personDAO.findOne(personPersisted.getId());
		personFromDB.setFirstName(personFromDB.getFirstName() + " Updated");
		personFromDB.getAddressList().get(0).setAddressLine1("AddressLine1 Updated");
		personFromDB.getOccasionList().get(0).setName("OccasionName updated");
		personFromDB.getImage().setTag("Tag Updated");

		Person personUpdated = personDAO.save(personFromDB);
		assertNotNull(personUpdated);
		assertNotNull(personUpdated.getImage());
		assertNotNull(personUpdated.getAddressList());
		assertNotNull(personUpdated.getOccasionList());

		assertEquals("FirstName updatePersonWithAllDetails Updated", personUpdated.getFirstName());
		assertEquals("AddressLine1 Updated", personUpdated.getAddressList().get(0).getAddressLine1());
		assertEquals("OccasionName updated", personUpdated.getOccasionList().get(0).getName());
		assertEquals("Tag Updated", personUpdated.getImage().getTag());
	}
	
	@Ignore
	@Test
	public void deletePersonWithAllDetails() {
		Person personTransient = TestUtils.getPersonObject();

		Image imageTransient = TestUtils.getImageObject("D:\\images\\image1.jpg");
		personTransient.setImage(imageTransient);
		imageTransient.setPerson(personTransient);

		Address addressTransient1 = TestUtils.getAddressObject();
		Address addressTransient2 = TestUtils.getAddressObject();
		Address addressTransient3 = TestUtils.getAddressObject();
		personTransient.getAddressList().add(addressTransient1);
		personTransient.getAddressList().add(addressTransient2);
		personTransient.getAddressList().add(addressTransient3);
		addressTransient1.setPerson(personTransient);
		addressTransient2.setPerson(personTransient);
		addressTransient3.setPerson(personTransient);

		Occasion occasionTransient1 = TestUtils.getOccasionObject();
		Occasion occasionTransient2 = TestUtils.getOccasionObject();
		Occasion occasionTransient3 = TestUtils.getOccasionObject();
		personTransient.getOccasionList().add(occasionTransient1);
		personTransient.getOccasionList().add(occasionTransient2);
		personTransient.getOccasionList().add(occasionTransient3);
		occasionTransient1.setPerson(personTransient);
		occasionTransient2.setPerson(personTransient);
		occasionTransient3.setPerson(personTransient);

		Person personPersisted = personDAO.save(personTransient);
		assertNotNull(personPersisted);
		assertNotNull(personPersisted.getImage());
		assertNotNull(personPersisted.getAddressList());
		
		personDAO.delete(personPersisted.getId());
	}
	
	
	@Ignore
	@Test
	public void deletePersonWithOneAddressOcasion() {
		Person personTransient = TestUtils.getPersonObject();

		Image imageTransient = TestUtils.getImageObject("D:\\images\\image1.jpg");
		personTransient.setImage(imageTransient);
		imageTransient.setPerson(personTransient);

		Address addressTransient1 = TestUtils.getAddressObject();
		Address addressTransient2 = TestUtils.getAddressObject();
		Address addressTransient3 = TestUtils.getAddressObject();
		personTransient.getAddressList().add(addressTransient1);
		personTransient.getAddressList().add(addressTransient2);
		personTransient.getAddressList().add(addressTransient3);
		addressTransient1.setPerson(personTransient);
		addressTransient2.setPerson(personTransient);
		addressTransient3.setPerson(personTransient);

		Occasion occasionTransient1 = TestUtils.getOccasionObject();
		Occasion occasionTransient2 = TestUtils.getOccasionObject();
		Occasion occasionTransient3 = TestUtils.getOccasionObject();
		personTransient.getOccasionList().add(occasionTransient1);
		personTransient.getOccasionList().add(occasionTransient2);
		personTransient.getOccasionList().add(occasionTransient3);
		occasionTransient1.setPerson(personTransient);
		occasionTransient2.setPerson(personTransient);
		occasionTransient3.setPerson(personTransient);

		Person personPersisted = personDAO.save(personTransient);
		assertNotNull(personPersisted);
		assertNotNull(personPersisted.getImage());
		assertNotNull(personPersisted.getAddressList());
		assertEquals("FirstName deletePersonWithOneAddressOcasion", personPersisted.getFirstName());
		
		personPersisted.getAddressList().get(0).setPerson(null);
		personPersisted.getAddressList().set(0, null);
		personPersisted.getOccasionList().get(0).setPerson(null);
		personPersisted.getOccasionList().set(0, null);
		
		Person personFromDB = personDAO.save(personPersisted);
		assertNotNull(personFromDB);
		assertNotNull(personFromDB.getImage());
		assertNotNull(personFromDB.getAddressList());
		
	}

	@Ignore
	@Test
	public void createPerson() {
		Person personTransient = TestUtils.getPersonObject();
		Person personPersisted = personDAO.save(personTransient);

		assertNotNull(personPersisted);
		assertEquals("FirstName createPerson", personPersisted.getFirstName());
	}

	@Ignore
	@Test
	public void createPersonWithImage() {
		Person personTransient = TestUtils.getPersonObject();
		Image imageTransient = TestUtils.getImageObject("D:\\images\\image1.jpg");
		imageTransient.setPerson(personTransient);
		personTransient.setImage(imageTransient);
		Person personPersisted = personDAO.save(personTransient);

		assertNotNull(personPersisted);
		assertNotNull(personPersisted.getImage());
		assertEquals("FirstName createPersonWithImage", personPersisted.getFirstName());
		assertEquals("Flower createPersonWithImage", personPersisted.getImage().getTag());
	}

	@Ignore
	@Test
	public void deleteImageFromPerson() {
		Person personTransient = TestUtils.getPersonObject();
		Image imageTransient = TestUtils.getImageObject( "D:\\images\\image1.jpg");
		imageTransient.setPerson(personTransient);
		personTransient.setImage(imageTransient);
		Person personPersisted = personDAO.save(personTransient);

		assertNotNull(personPersisted);
		assertNotNull(personPersisted.getImage());
		assertEquals("FirstName deleteImageFromPerson", personPersisted.getFirstName());
		assertEquals("Flower deleteImageFromPerson", personPersisted.getImage().getTag());

		personPersisted.getImage().setPerson(null);
		personPersisted.setImage(null);
		Person personUpdated = personDAO.save(personPersisted);
		assertNotNull(personUpdated);
		assertNull(personUpdated.getImage());
	}

	@Ignore
	@Test
	public void deletePersonWithImage() {
		Person personTransient = TestUtils.getPersonObject();
		Image imageTransient = TestUtils.getImageObject( "D:\\images\\image1.jpg");
		imageTransient.setPerson(personTransient);
		personTransient.setImage(imageTransient);
		Person personPersisted = personDAO.save(personTransient);

		assertNotNull(personPersisted);
		assertNotNull(personPersisted.getImage());
		assertEquals("FirstName deletePersonWithImage", personPersisted.getFirstName());
		assertEquals("Flower deletePersonWithImage", personPersisted.getImage().getTag());

		personDAO.delete(personPersisted.getId());
	}

	@Ignore
	@Test
	public void createPersonDOBEmpty() {
		Person personTransient = TestUtils.getPersonObject();
		personTransient.setDob(null);
		Person personPersisted = personDAO.save(personTransient);

		assertNotNull(personPersisted);
		assertEquals("FirstName createPersonDOBEmpty", personPersisted.getFirstName());
	}

	@Ignore
	@Test
	public void findPersonById() {
		Person personTransient = TestUtils.getPersonObject();
		Person personPersisted = personDAO.save(personTransient);

		Person personFromDB = personDAO.findOne(personPersisted.getId());
		personFromDB.setAddressList(new ArrayList<>());
		personFromDB.setOccasionList(new ArrayList<>());

		assertNotNull(personFromDB);
		assertEquals("FirstName findPersonById", personFromDB.getFirstName());
		log.info(personFromDB);
	}

	@Ignore
	@Test
	public void updatePerson() {
		Person personTransient = TestUtils.getPersonObject();
		Person personPersisted = personDAO.save(personTransient);

		Person personFromDB = personDAO.findOne(personPersisted.getId());
		personFromDB.setFirstName(personFromDB.getFirstName() + " Updated");
		LocalDateTime ldt = LocalDateTime.now();
		Instant instant = ldt.toInstant(ZoneOffset.UTC);
		personFromDB.setUpdatedDate(Date.from(instant));
		personFromDB.setUpdatedUser("JavaTraining Update");
		Person personFromDB2 = personDAO.save(personFromDB);

		assertNotNull(personFromDB2);
		assertEquals("FirstName updatePerson Updated", personFromDB2.getFirstName());
	}

	@Ignore
	@Test
	public void deletePerson() {
		Person personTransient = TestUtils.getPersonObject();
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
		Person personTransient = TestUtils.getPersonObject();
		personTransient.setEmailId("EmailId");
		personTransient.setAlternateEmailId("AlternateEmailId");
		personDAO.save(personTransient);
	}

	@Ignore
	@Test(expected = javax.validation.ConstraintViolationException.class)
	public void createPersonWithInvalidPhoneNumber() {
		Person personTransient = TestUtils.getPersonObject();
		personTransient.setPhoneNumber(9111145678904324324L);
		personTransient.setAlternatePhoneNumber(912224567890432434L);
		personDAO.save(personTransient);
	}

	@Ignore
	@Test(expected = javax.validation.ConstraintViolationException.class)
	public void createPersonInvalidFirstNameEmpty() {
		Person personTransient = TestUtils.getPersonObject();
		personTransient.setFirstName("");
		personDAO.save(personTransient);
	}

	@Ignore
	@Test(expected = javax.validation.ConstraintViolationException.class)
	public void createPersonInvalidDOB() {
		Person personTransient = TestUtils.getPersonObject();
		personTransient.setDob(Date.valueOf(LocalDate.of(2020, Month.FEBRUARY, 28)));
		personDAO.save(personTransient);
	}

}
