package com.contacts.utils;

import com.contacts.contact_management.model.Image;
import com.contacts.contact_management.model.Person;

public class CopyObjects {
	
	public static Person copyPerson(final Person sourcePerson, final Person destinationPerson){
		destinationPerson.setFirstName(sourcePerson.getFirstName());
		destinationPerson.setLastName(sourcePerson.getLastName());
		destinationPerson.setDob(sourcePerson.getDob());
		destinationPerson.setGender(sourcePerson.getGender());
		destinationPerson.setEmailId(sourcePerson.getEmailId());
		destinationPerson.setAlternateEmailId(sourcePerson.getAlternateEmailId());
		destinationPerson.setPhoneNumber(sourcePerson.getPhoneNumber());
		destinationPerson.setAlternatePhoneNumber(sourcePerson.getAlternatePhoneNumber());
		return destinationPerson;
	}
	
	public static Image copyImage(final Image sourceImage, final Image destinationImage){
		destinationImage.setImage(sourceImage.getImage());
		destinationImage.setTag(sourceImage.getTag());
		return destinationImage;
	}
	
	
}
