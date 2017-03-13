/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.controller;

import java.util.ArrayList;
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

import com.contacts.contact_management.model.Occasion;
import com.contacts.contact_management.service.OccasionService;

/**
 * 
 * @author sindhu
 *
 */
@RestController
@RequestMapping(value = "/occasions")
@CrossOrigin
public class OccasionController {

	@Autowired
	private OccasionService occasionService;
	
	/**
	 * Web service to return occasion as json.
	 * 
	 * @param id
	 * @return ResponseEntity<Occasion>
	 */
	@RequestMapping(value = "/occasionByCurrentDate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> getAllOccasionsByCurrentDate() {
		List<String> occasionsForCurretDate = new ArrayList<>();
		for (Occasion occasion : occasionService.getAllOccasionsByCurrentDate()) {
			occasionsForCurretDate.add(occasion.getPerson().getFirstName() + " "+ occasion.getPerson().getLastName()+" -  " + occasion.getName());
		}
		return new ResponseEntity<List<String>>(occasionsForCurretDate, HttpStatus.OK);
	}


	/**
	 * Web service to return occasion as json.
	 * 
	 * @param id
	 * @return ResponseEntity<Occasion>
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Occasion> getOccasionById(@PathVariable final Long id) {
		Occasion occasion = occasionService.getOccasionById(id);
		occasion.setPerson(null);
		return new ResponseEntity<Occasion>(occasion, HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteOccasionById(@PathVariable final Long id) {
		occasionService.deleteOccasion(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Occasion>> getAllOccasions() {
		List<Occasion> occasions = occasionService.getAllOccasions();
		return new ResponseEntity<List<Occasion>>(occasions, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Occasion> createOccasion(@RequestBody final Occasion occasion) {
		Occasion occasionCreated = occasionService.createOccasion(occasion);
		return new ResponseEntity<Occasion>(occasionCreated, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Occasion> updateOccasion(@PathVariable final Long id, @RequestBody final Occasion occasion) {
		Occasion occasionDetached =occasionService.getOccasionById(id);
		//CopyObjects.copyOccasion(occasion, occasionDetached);
		Occasion occasionUpdated = occasionService.updateOccasion(occasionDetached);
		return new ResponseEntity<Occasion>(occasionUpdated, HttpStatus.OK);
	}

}
