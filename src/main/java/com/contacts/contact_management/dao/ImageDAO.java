/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contacts.contact_management.model.Image;

/**
 * @author Sandeep
 *
 */
@Repository
public interface ImageDAO extends JpaRepository<Image, Long> {

}
