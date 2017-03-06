package com.contacts.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import com.contacts.contact_management.model.Address;
import com.contacts.contact_management.model.Image;
import com.contacts.contact_management.model.Occasion;
import com.contacts.contact_management.model.Person;
import com.contacts.utils.MyLogger;
import org.apache.log4j.Logger;

public class CopyObjects {

	public static Person copyPerson(final Person uiPerson, final Person dbPerson) {
		dbPerson.setFirstName(uiPerson.getFirstName());
		dbPerson.setLastName(uiPerson.getLastName());
		dbPerson.setDob(uiPerson.getDob());
		dbPerson.setGender(uiPerson.getGender());
		dbPerson.setMaritalStatus(uiPerson.getMaritalStatus());
		dbPerson.setEmailId(uiPerson.getEmailId());
		dbPerson.setAlternateEmailId(uiPerson.getAlternateEmailId());
		dbPerson.setPhoneNumber(uiPerson.getPhoneNumber());
		dbPerson.setAlternatePhoneNumber(uiPerson.getAlternatePhoneNumber());

		if (!CollectionUtils.isEmpty(uiPerson.getOccasionList())) {
			if (uiPerson.getOccasionList().size() == dbPerson.getOccasionList().size()) {
				updateOccationList(uiPerson.getOccasionList(), dbPerson.getOccasionList());
			} else if (uiPerson.getOccasionList().size() > dbPerson.getOccasionList().size()) {
				addOccasionInOccasionList(uiPerson.getOccasionList(), dbPerson.getOccasionList(), dbPerson);
			} else {
				deleteOccasionFromOccasionList(uiPerson.getOccasionList(), dbPerson.getOccasionList());
			}
		}
		if (!CollectionUtils.isEmpty(uiPerson.getAddressList())) {
			if (uiPerson.getAddressList().size() == dbPerson.getAddressList().size()) {
				updateAddressList(uiPerson.getAddressList(), dbPerson.getAddressList());
			} else if (uiPerson.getAddressList().size() > dbPerson.getAddressList().size()) {
				addAddressInAddressList(uiPerson.getAddressList(), dbPerson.getAddressList(), dbPerson);
			} else {
				deleteAddressFromAddressList(uiPerson.getAddressList(), dbPerson.getAddressList());
			}
		}
		// copyImage(destinationPerson.getImage(),sourcePerson.getImage());
		return dbPerson;
	}

	private static void updateAddressList(List<Address> uiAddressList, List<Address> dbAddressList) {
		for (int i = 0; i < uiAddressList.size(); i++) {
			Address uiAddress = uiAddressList.get(i);
			Address dbAddress = dbAddressList.stream().filter(address -> address.getId().equals(uiAddress.getId()))
					.collect(Collectors.toList()).get(0);
			copyAddress(uiAddress, dbAddress);
		}
	}

	private static void addAddressInAddressList(List<Address> uiAddressList, List<Address> dbAddressList,
			Person dbPerson) {
		for (int i = 0; i < uiAddressList.size(); i++) {
			Address uiAddress = uiAddressList.get(i);
			List<Address> dbAddress = dbAddressList.stream()
					.filter(address -> address.getId().equals(uiAddress.getId())).collect(Collectors.toList());
			if (CollectionUtils.isEmpty(dbAddress)) {
				uiAddress.setPerson(dbPerson);
				dbAddressList.add(uiAddress);
				break;
			}
		}
	}

	private static void deleteAddressFromAddressList(List<Address> uiAddressList, List<Address> dbAddressList) {
		for (int i = 0; i < dbAddressList.size(); i++) {
			Address dbAddress = dbAddressList.get(i);
			List<Address> uiAddress = uiAddressList.stream()
					.filter(address -> address.getId().equals(dbAddress.getId())).collect(Collectors.toList());
			if (CollectionUtils.isEmpty(uiAddress)) {
				dbAddressList.set(i, null);
				break;
			}
		}
	}

	private static void updateOccationList(List<Occasion> uiOccasionList, List<Occasion> dbOccasionList) {
		for (int i = 0; i < uiOccasionList.size(); i++) {
			Occasion uiOccasion = uiOccasionList.get(i);
			Occasion dbOccasion = dbOccasionList.stream()
					.filter(occasion -> occasion.getId().equals(uiOccasion.getId())).collect(Collectors.toList())
					.get(0);
			copyOccasion(uiOccasion, dbOccasion);
		}
	}

	private static void addOccasionInOccasionList(List<Occasion> uiOccasionList, List<Occasion> dbOccasionList,
			Person dbPerson) {
		for (int i = 0; i < uiOccasionList.size(); i++) {
			Occasion uiOccasion = uiOccasionList.get(i);
			List<Occasion> dbOccasions = dbOccasionList.stream()
					.filter(occasion -> occasion.getId().equals(uiOccasion.getId())).collect(Collectors.toList());
			if (CollectionUtils.isEmpty(dbOccasions)) {
				uiOccasion.setPerson(dbPerson);
				dbOccasionList.add(uiOccasion);
				break;
			}
		}
	}

	private static void deleteOccasionFromOccasionList(List<Occasion> uiOccasionList, List<Occasion> dbOccasionList) {
		for (int i = 0; i < dbOccasionList.size(); i++) {
			Occasion dbOccasion = dbOccasionList.get(i);
			List<Occasion> uiOccasions = uiOccasionList.stream()
					.filter(occasion -> occasion.getId().equals(dbOccasion.getId())).collect(Collectors.toList());
			if (CollectionUtils.isEmpty(uiOccasions)) {
				dbOccasionList.set(i, null);
				break;
			}
		}
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
