/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.service;

import java.util.List;

import com.contacts.contact_management.model.Person;
import com.contacts.contact_management.model.PersonSearchCriteria;

/**
 * @author Sandeep
 *
 */
public interface PersonService {
	
	/**
	 * Gets all persons by search criteria.
	 * 
	 * @return List<Person>
	 */
	List<Person> getAllPersonsBySearchCriteria(PersonSearchCriteria personSearchCriteria);
	
	/**
	 * Gets the Person by Id.
	 * 
	 * @param id
	 * @return Person
	 */
	Person getPersonById(Long id);
	
	/**
	 * Gets all persons.
	 * 
	 * @return List<Person>
	 */
	List<Person> getAllPersons();
	
	/**
	 * Creates person.
	 * 
	 * @param person
	 * @return person
	 */
	Person createPerson(Person person);
	
	/**
	 * Updates person.
	 * 
	 * @param person
	 * @return person
	 */
	Person updatePerson(Person person);
	
	/**
	 * Deletes person.
	 * @param id
	 */
	void deletePerson(Long id);

}
