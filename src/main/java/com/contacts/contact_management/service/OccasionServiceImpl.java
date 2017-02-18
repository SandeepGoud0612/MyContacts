/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contacts.contact_management.dao.OccasionDAO;
import com.contacts.contact_management.model.Occasion;
import com.contacts.utils.MyLogger;

/**
 * @author Sandeep
 *
 */
@Service
@Transactional
public class OccasionServiceImpl implements OccasionService {

	private Logger log = MyLogger.getLogger();

	@Autowired
	private OccasionDAO occasionDAO;

	@Override
	public Occasion getOccasionById(final Long id) {
		log.debug("In getOccasionById method");
		return occasionDAO.findOne(id);
	}

	@Override
	public List<Occasion> getAllOccasions() {
		log.debug("In getAllOccasions method");
		return occasionDAO.findAll();
	}

	@Override
	public Occasion createOccasion(final Occasion occasion) {
		log.debug("In createOccasion method");
		return occasionDAO.save(occasion);
	}

	@Override
	public Occasion updateOccasion(final Occasion occasion) {
		log.debug("In updateOccasion method");
		return occasionDAO.save(occasion);
	}

	@Override
	public void deleteOccasion(final Long id) {
		log.debug("In deleteOccasion method");
		occasionDAO.delete(id);
	}

}
