/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.service;

import java.util.List;

import com.contacts.contact_management.model.Occasion;

/**
 * @author Sandeep
 *
 */
public interface OccasionService {

	/**
	 * Gets occasion by id.
	 * 
	 * @param id
	 * @return occasion
	 */
	Occasion getOccasionById(Long id);

	/**
	 * Gets all occasions.
	 * 
	 * @return List<Occasion>
	 */
	List<Occasion> getAllOccasions();

	/**
	 * Creates occasion.
	 * 
	 * @param occasion
	 * @return occasion
	 */
	Occasion createOccasion(Occasion occasion);

	/**
	 * Updates occasion.
	 * 
	 * @param occasion
	 * @return occasion
	 */
	Occasion updateOccasion(Occasion occasion);

	/**
	 * Deletes occasion.
	 * 
	 * @param id
	 */
	void deleteOccasion(Long id);

}
