/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.contacts.contact_management.dao.AddressDAO;
import com.contacts.contact_management.model.Address;

/**
 * @author Sandeep
 *
 */
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDAO addressDAO;

	@Override
	public Address getAddressById(final Long id) {
		// TODO Auto-generated method stub
		return addressDAO.findOne(id);
	}

	@Override
	public List<Address> getAllAddress() {
		// TODO Auto-generated method stub
		return addressDAO.findAll();
	}

	@Override
	public Address createAddress(final Address address) {
		// TODO Auto-generated method stub
		return addressDAO.save(address);
	}

	@Override
	public Address updateAddress(final Address address) {
		// TODO Auto-generated method stub
		return addressDAO.save(address);
	}

	@Override
	public void deleteAddress(final Long id) {
		// TODO Auto-generated method stub
		addressDAO.delete(id);
	}

}
