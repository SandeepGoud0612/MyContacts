/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.contacts.contact_management.model.Address;
import com.contacts.contact_management.service.AddressService;
import com.contacts.contact_management.service.PersonService;

/**
 * @author manoj
 *
 */
@RestController
@RequestMapping(value="/contacts/address")
@CrossOrigin
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private PersonService personService;
	
	/**
	 * Web service to return Address as json.
	 * 
	 * @param id
	 * @return ResponseEntity<Address>
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> getAddressById(@PathVariable final Long id){
		Address address = addressService.getAddressById(id);
		address.setPerson(null);		
		return new ResponseEntity<Address>(address, HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Address>> getAllAddresses()
	{
		List<Address> address = addressService.getAllAddress();
		return new ResponseEntity<List<Address>>(address, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)	
	public ResponseEntity<Void> deleteAddressById(@PathVariable final Long id){
		personService.deletePerson(id);
		addressService.deleteAddress(id);		
		return new ResponseEntity<Void>(HttpStatus.OK);	
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> updateAddress(@PathVariable final Long id, @RequestBody final Address address){
		Address address1 = addressService.getAddressById(id);
		//CopyObjects.copyAddress(address, address1);
		Address addressupdated = addressService.updateAddress(address1);
		return new ResponseEntity<Address>(addressupdated, HttpStatus.OK);
		
	}
	
	
	
}
	
	
