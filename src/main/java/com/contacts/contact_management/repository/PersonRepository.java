/**
 *  This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contacts.contact_management.models.Person;

import org.springframework.stereotype.Repository;

/**
 * @author manoj
 *
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
