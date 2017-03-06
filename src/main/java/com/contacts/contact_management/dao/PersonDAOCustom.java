/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.dao;

import java.util.List;

import com.contacts.contact_management.model.Person;
import com.contacts.contact_management.model.PersonSearchCriteria;

/**
 * 
 * @author Sandeep
 *
 */
public interface PersonDAOCustom {
	
	List<Person> getAllPersonsBySearchCriteria(PersonSearchCriteria personSearchCriteria);

}
