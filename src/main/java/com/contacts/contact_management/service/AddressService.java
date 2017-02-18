/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.service;

import java.util.List;

import com.contacts.contact_management.model.Address;

/**
 * @author Sandeep
 *
 */
public interface AddressService {
	
	/**
	 * Gets address by id.
	 * 
	 * @param id
	 * @return address
	 */
	Address getAddressById(Long id);

	/**
	 * Gets all address.
	 * 
	 * @return List<Address>
	 */
	List<Address> getAllAddress();

	/**
	 * Creates address.
	 * 
	 * @param address
	 * @return address
	 */
	Address createAddress(Address address);

	/**
	 * Updates address.
	 * 
	 * @param address
	 * @return address
	 */
	Address updateAddress(Address address);

	/**
	 * Deletes address.
	 * 
	 * @param id
	 */
	void deleteAddress(Long id);

}
