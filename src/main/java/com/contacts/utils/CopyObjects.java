package com.contacts.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.contacts.contact_management.model.Address;
import com.contacts.contact_management.model.Image;
import com.contacts.contact_management.model.Occasion;
import com.contacts.contact_management.model.Person;

public class CopyObjects {

	public static Person copyPerson(final Person sourcePerson, final Person destinationPerson) {
		destinationPerson.setFirstName(sourcePerson.getFirstName());
		destinationPerson.setLastName(sourcePerson.getLastName());
		destinationPerson.setDob(sourcePerson.getDob());
		destinationPerson.setGender(sourcePerson.getGender());
		destinationPerson.setEmailId(sourcePerson.getEmailId());
		destinationPerson.setAlternateEmailId(sourcePerson.getAlternateEmailId());
		destinationPerson.setPhoneNumber(sourcePerson.getPhoneNumber());
		destinationPerson.setAlternatePhoneNumber(sourcePerson.getAlternatePhoneNumber());
		for (int i = 0; i < destinationPerson.getAddressList().size(); i++) {
			Address sourceAddress = sourcePerson.getAddressList().get(i);
			Address destinationAddress = getDestinationAddress(sourceAddress, destinationPerson.getAddressList());
			copyAddress(sourceAddress, destinationAddress);
		}
		for (int i = 0; i < destinationPerson.getOccasionList().size(); i++) {
			Occasion destinationOccasion = destinationPerson.getOccasionList().get(i);
			Occasion sourceOccasion = getSourceOccasion(destinationOccasion, sourcePerson.getOccasionList());
			if(sourceOccasion == null){
				destinationPerson.getOccasionList().set(i, null);
				continue;
			}
			copyOccasion(sourceOccasion, destinationOccasion);
		}
		// copyImage(destinationPerson.getImage(),sourcePerson.getImage());
		return destinationPerson;
	}

	private static Address getDestinationAddress(Address sourceAddress, List<Address> destinationAddressList) {
		return destinationAddressList.stream().filter(address -> address.getId().equals(sourceAddress.getId()))
				.collect(Collectors.toList()).get(0);
	}

	private static Occasion getSourceOccasion(Occasion destinationOccasion, List<Occasion> sourceOccasionList) {
		 List<Occasion> occasions = sourceOccasionList.stream().filter(occasion -> occasion.getId().equals(destinationOccasion.getId()))
				.collect(Collectors.toList());
		 return occasions.size() > 0 ? occasions.get(0) : null; 
	}

	public static Address copyAddress(final Address sourceAddress, final Address destinationAddress) {
		destinationAddress.setAddressLine1(sourceAddress.getAddressLine1());
		destinationAddress.setAddressLine2(sourceAddress.getAddressLine2());
		destinationAddress.setCity(sourceAddress.getCity());
		destinationAddress.setState(sourceAddress.getState());
		destinationAddress.setCountry(sourceAddress.getCountry());
		destinationAddress.setZipCode(sourceAddress.getZipCode());
		return destinationAddress;
	}

	public static Occasion copyOccasion(final Occasion sourceOccasion, final Occasion destinationOccasion) {
		destinationOccasion.setName(sourceOccasion.getName());
		destinationOccasion.setDate(sourceOccasion.getDate());
		destinationOccasion.setRemindMe(sourceOccasion.getRemindMe());
		return destinationOccasion;
	}

	public static Image copyImage(final Image sourceImage, final Image destinationImage) {
		destinationImage.setImage(sourceImage.getImage());
		destinationImage.setTag(sourceImage.getTag());
		return destinationImage;
	}

}
