/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contacts.contact_management.dao.PersonDAO;
import com.contacts.contact_management.model.Person;

/**
 * @author Sandeep
 *
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDAO personDAO;

	@Override
	public Person getPersonById(final Long id) {
		// TODO Auto-generated method stub
		return personDAO.findOne(id);
	}

	@Override
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return personDAO.findAll();
	}

	@Override
	public Person createPerson(final Person person) {
		// TODO Auto-generated method stub
		return personDAO.save(person);
	}

	@Override
	public Person updatePerson(final Person person) {
		// TODO Auto-generated method stub
		return personDAO.save(person);
	}

	@Override
	public void deletePerson(final Long id) {
		// TODO Auto-generated method stub
		personDAO.delete(id);
		
	}

}
