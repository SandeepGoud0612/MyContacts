/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.contacts.contact_management.dao.AddressDAO;
import com.contacts.contact_management.model.Address;
import com.contacts.utils.MyLogger;

/**
 * @author Sandeep
 *
 */
public class AddressServiceImpl implements AddressService {

	private Logger log = MyLogger.getLogger();

	@Autowired
	private AddressDAO addressDAO;

	@Override
	public Address getAddressById(final Long id) {
		log.debug("In getAddressById method");
		return addressDAO.findOne(id);
	}

	@Override
	public List<Address> getAllAddress() {
		log.debug("In getAllAddress method");
		return addressDAO.findAll();
	}

	@Override
	public Address createAddress(final Address address) {
		log.debug("In createAddress method");
		return addressDAO.save(address);
	}

	@Override
	public Address updateAddress(final Address address) {
		log.debug("In updateAddress method");
		return addressDAO.save(address);
	}

	@Override
	public void deleteAddress(final Long id) {
		log.debug("In deleteAddress method");
		addressDAO.delete(id);
	}

}
