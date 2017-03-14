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

import com.contacts.contact_management.model.Person;
import com.contacts.contact_management.model.PersonSearchCriteria;
import com.contacts.contact_management.service.PersonService;
import com.contacts.utils.CopyObjects;

/** 
 * @author Sandeep
 *
 */
@RestController
@RequestMapping(value = "/person")
@CrossOrigin
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/searchcriteria", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Person>> getAllPersonsBySearchCriteria(@RequestBody final PersonSearchCriteria personSearchCriteria)
	{
		List<Person> persons = personService.getAllPersonsBySearchCriteria(personSearchCriteria);
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> getPersonById(@PathVariable final Long id) {
		Person person = personService.getPersonById(id);
		person.setImage(null);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	@RequestMapping(value = "/personaldetails/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> getPersonWithPersonalDetailsOnlyById(@PathVariable final Long id) {
		Person person = personService.getPersonById(id);
		person.setImage(null);
		person.setAddressList(null);
		person.setOccasionList(null);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletePersonById(@PathVariable final Long id) {
		personService.deletePerson(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Person>> getAllPersons() {
		List<Person> persons = personService.getAllPersons();
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}

	@RequestMapping(value = "/personaldetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Person>> getAllPersonsWithPersonalDetailsOnly() {
		List<Person> persons = personService.getAllPersons();
		persons.stream().forEach(person -> {
			person.setImage(null);
			person.setAddressList(null);
			person.setOccasionList(null);
		});
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> createPerson(@RequestBody final Person person) {
		Person personCreated = personService.createPerson(person);
		return new ResponseEntity<Person>(personCreated, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> updatePerson(@PathVariable final Long id, @RequestBody final Person person) {
		Person personFromDB = personService.getPersonById(id);
		CopyObjects.copyPerson(person, personFromDB);
		Person personUpdated = personService.updatePerson(personFromDB);
		return new ResponseEntity<Person>(personUpdated, HttpStatus.OK);
	}

}
