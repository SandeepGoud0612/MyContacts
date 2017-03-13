/**
 * /**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.contacts.contact_management.model.Occasion;

/**
 * @author sindhu
 *
 */
@Repository
public class OccasionDAOCustomImpl implements OccasionDAOCustom {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Occasion> getAllOccasionsByCurrentDate() {
		Query query = entityManager.createQuery("from OCCASION as O where OCCASION_DATE=:date");
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		query.setParameter("date",LocalDateTime.now().format(format));
		List<Occasion> occasions = query.getResultList();
		return occasions;

	}

}