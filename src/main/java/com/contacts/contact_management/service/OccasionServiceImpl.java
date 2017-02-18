/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contacts.contact_management.dao.OccasionDAO;
import com.contacts.contact_management.model.Occasion;

/**
 * @author Sandeep
 *
 */
@Service
@Transactional
public class OccasionServiceImpl implements OccasionService {

	@Autowired
	private OccasionDAO occasionDAO;

	@Override
	public Occasion getOccasionById(final Long id) {
		// TODO Auto-generated method stub
		return occasionDAO.findOne(id);
	}

	@Override
	public List<Occasion> getAllOccasions() {
		// TODO Auto-generated method stub
		return occasionDAO.findAll();
	}

	@Override
	public Occasion createOccasion(final Occasion occasion) {
		// TODO Auto-generated method stub
		return occasionDAO.save(occasion);
	}

	@Override
	public Occasion updateOccasion(final Occasion occasion) {
		// TODO Auto-generated method stub
		return occasionDAO.save(occasion);
	}

	@Override
	public void deleteOccasion(final Long id) {
		// TODO Auto-generated method stub
		occasionDAO.delete(id);
	}

}
