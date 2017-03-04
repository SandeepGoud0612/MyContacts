package com.contacts.utils;

import com.contacts.contact_management.model.Address;
import com.contacts.contact_management.model.Image;
import com.contacts.contact_management.model.Occasion;
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
		for(int i = 0; i < destinationPerson.getAddressList().size(); i++){
			copyAddress(sourcePerson.getAddressList().get(i), destinationPerson.getAddressList().get(i));
		}
		for(int i = 0; i < destinationPerson.getOccasionList().size(); i++){
			copyOccasion(sourcePerson.getOccasionList().get(i), destinationPerson.getOccasionList().get(i)	);
		}
		//copyImage(destinationPerson.getImage(),sourcePerson.getImage());
		return destinationPerson;
	}
	
	public static Address copyAddress(final Address sourceAddress, final Address destinationAddress){
		destinationAddress.setAddressLine1(sourceAddress.getAddressLine1());
		destinationAddress.setAddressLine2(sourceAddress.getAddressLine2());
		destinationAddress.setCity(sourceAddress.getCity());
		destinationAddress.setState(sourceAddress.getState());
		destinationAddress.setCountry(sourceAddress.getCountry());
		destinationAddress.setZipCode(sourceAddress.getZipCode());
		return destinationAddress;
	}
	
	public static Occasion copyOccasion(final Occasion sourceOccasion, final Occasion destinationOccasion){
		destinationOccasion.setName(sourceOccasion.getName());
		destinationOccasion.setDate(sourceOccasion.getDate());
		destinationOccasion.setRemindMe(sourceOccasion.getRemindMe());
		return destinationOccasion;
	}	
	
	public static Image copyImage(final Image sourceImage, final Image destinationImage){
		destinationImage.setImage(sourceImage.getImage());
		destinationImage.setTag(sourceImage.getTag());
		return destinationImage;
	}
	
}
