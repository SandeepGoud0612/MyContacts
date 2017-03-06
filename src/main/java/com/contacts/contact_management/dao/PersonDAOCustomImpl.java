/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.contacts.contact_management.model.Person;
import com.contacts.contact_management.model.PersonSearchCriteria;

/**
 * @author Sandeep
 *
 */
@Repository
public class PersonDAOCustomImpl implements PersonDAOCustom {

	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.contacts.contact_management.dao.PersonDAOCustom#
	 * getAllPersonsBySearchCriteria(com.contacts.contact_management.model.
	 * PersonSearchCriteria)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getAllPersonsBySearchCriteria(PersonSearchCriteria criteria) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
		Root<Person> root = criteriaQuery.from(Person.class);
		if (!StringUtils.isEmpty(criteria.getFirstName())) {
			criteriaQuery.where(criteriaBuilder.like(root.get("firstName"), "%" + criteria.getFirstName() + "%"));
		}
		if (!StringUtils.isEmpty(criteria.getLastName())) {
			criteriaQuery.where(criteriaBuilder.like(root.get("lastName"), "%" + criteria.getLastName() + "%"));
		}
		if (!StringUtils.isEmpty(criteria.getEmailId())) {
			criteriaQuery.where(criteriaBuilder.like(root.get("emailId"), "%" + criteria.getEmailId() + "%"));
		}
		Query query = entityManager.createQuery(criteriaQuery);
		List<Person> personList = query.getResultList();
		return personList;
	}

}
