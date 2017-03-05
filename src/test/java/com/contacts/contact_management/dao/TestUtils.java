/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;
import java.time.LocalDate;

import com.contacts.contact_management.enums.Gender;
import com.contacts.contact_management.enums.MaritalStatus;
import com.contacts.contact_management.model.Address;
import com.contacts.contact_management.model.Image;
import com.contacts.contact_management.model.Occasion;
import com.contacts.contact_management.model.Person;

/**
 * @author JavaTraining
 *
 */
public class TestUtils {

	public static Person getPersonObject() {
		Person personTransient = new Person();
		personTransient.setFirstName("FirstName");
		personTransient.setLastName("LastName");
		personTransient.setGender(Gender.Male);
		personTransient.setDob(Date.valueOf(LocalDate.now()));
		personTransient.setEmailId("EmailId@gmail.com");
		personTransient.setAlternateEmailId("AlternateEmailId@gmail.com");
		personTransient.setPhoneNumber(911114567890L);
		personTransient.setAlternatePhoneNumber(912224567890L);
		personTransient.setMaritalStatus(MaritalStatus.Single);
		return personTransient;
	}

	public static Image getImageObject(final String imagePath) {
		Image imageTransient = new Image();
		imageTransient.setTag("Flower");
		try {
			File file = new File(imagePath);
			imageTransient.setImage(Files.readAllBytes(file.toPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imageTransient;
	}

	public static Address getAddressObject() {
		Address address = new Address();
		address.setAddressLine1("Address Line 1");
		address.setAddressLine2("Address Line 2");
		address.setCity("City");
		address.setState("State");
		address.setCountry("Country");
		address.setZipCode(77077L);
		return address;
	}

	public static Occasion getOccasionObject() {
		Occasion occasion = new Occasion();
		occasion.setName("Occasion");
		occasion.setRemindMe(true);
		occasion.setDate(Date.valueOf(LocalDate.now()));
		return occasion;
	}

}
