/**
 * 
 */
package com.contacts.contact_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contacts.contact_management.models.Address;

/**
 * @author manoj
 *
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
