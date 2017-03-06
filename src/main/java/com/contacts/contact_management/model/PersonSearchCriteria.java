/**
 *  This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Sandeep
 */
public class PersonSearchCriteria implements Serializable {

	/**
	 * Default Serial Version UID
	 */
	private static final long serialVersionUID = 7517336548816989044L;

	private String firstName;

	private String lastName;

	private Long phoneNumber;

	private String emailId;

	private Date dob;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
