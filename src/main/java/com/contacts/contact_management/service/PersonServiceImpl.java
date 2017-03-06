/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contacts.contact_management.dao.PersonDAO;
import com.contacts.contact_management.dao.PersonDAOCustom;
import com.contacts.contact_management.model.Person;
import com.contacts.contact_management.model.PersonSearchCriteria;
import com.contacts.utils.MyLogger;

/**
 * @author Sandeep
 *
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	
	private Logger log = MyLogger.getLogger();
	
	@Autowired
	private PersonDAO personDAO;
	
	@Autowired
	private PersonDAOCustom personDAOCustom;

	@Override
	public Person getPersonById(final Long id) {
		log.info("in getPersonById method");
		return personDAO.findOne(id);
	}

	@Override
	public List<Person> getAllPersons() {
		log.info("in getAllPersons method");
		return personDAO.findAll();
	}

	@Override
	public Person createPerson(final Person person) {
		log.info("in createPerson method");
		return personDAO.save(person);
	}

	@Override
	public Person updatePerson(final Person person) {
		log.info("in updatePerson method");
		return personDAO.save(person);
	}

	@Override
	public void deletePerson(final Long id) {
		log.info("in deletePerson method");
		personDAO.delete(id);
		
	}

	@Override
	public List<Person> getAllPersonsBySearchCriteria(PersonSearchCriteria personSearchCriteria) {
		log.info("in getAllPersonsBySearchCriteria method");
		return personDAOCustom.getAllPersonsBySearchCriteria(personSearchCriteria);
	}

}
