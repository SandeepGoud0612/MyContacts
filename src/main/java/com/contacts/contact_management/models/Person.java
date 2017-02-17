/**
 *  This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.contacts.contact_management.enums.Gender;

/**
 * @author Sandeep
 *
 */
@Entity(name = "PERSON")
public class Person extends BaseEntity implements Serializable {

	/**
	 * Default Serial Version UID
	 */
	private static final long serialVersionUID = 1848863001342070460L;

	@Column(name = "FIRST_NAME", length = 50, nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", length = 50, nullable = false)
	private String lastName;

	@Column(name = "GENDER", length = 10, nullable = false)
	private Gender gender;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "PHONE_NUMBER", length = 20, nullable = false)
	private String phoneNumber;

	@Column(name = "ALTERNATE_PHONE_NUMBER", length = 20)
	private String alternatePhoneNumber;

	@Column(name = "EMAIL_ID", length = 50, nullable = false)
	private String emailId;

	@Column(name = "ALTERNATE_EMAIL_ID", length = 50)
	private String alternateEmailId;

	@Column(name = "MARITAL_STATUS")
	private Boolean maritalStatus;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the alternatePhoneNumber
	 */
	public String getAlternatePhoneNumber() {
		return alternatePhoneNumber;
	}

	/**
	 * @param alternatePhoneNumber
	 *            the alternatePhoneNumber to set
	 */
	public void setAlternatePhoneNumber(String alternatePhoneNumber) {
		this.alternatePhoneNumber = alternatePhoneNumber;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the alternateEmailId
	 */
	public String getAlternateEmailId() {
		return alternateEmailId;
	}

	/**
	 * @param alternateEmailId
	 *            the alternateEmailId to set
	 */
	public void setAlternateEmailId(String alternateEmailId) {
		this.alternateEmailId = alternateEmailId;
	}

	/**
	 * @return the maritalStatus
	 */
	public Boolean getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * @param maritalStatus
	 *            the maritalStatus to set
	 */
	public void setMaritalStatus(Boolean maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((alternateEmailId == null) ? 0 : alternateEmailId.hashCode());
		result = prime * result + ((alternatePhoneNumber == null) ? 0 : alternatePhoneNumber.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((maritalStatus == null) ? 0 : maritalStatus.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (alternateEmailId == null) {
			if (other.alternateEmailId != null)
				return false;
		} else if (!alternateEmailId.equals(other.alternateEmailId))
			return false;
		if (alternatePhoneNumber == null) {
			if (other.alternatePhoneNumber != null)
				return false;
		} else if (!alternatePhoneNumber.equals(other.alternatePhoneNumber))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender != other.gender)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (maritalStatus == null) {
			if (other.maritalStatus != null)
				return false;
		} else if (!maritalStatus.equals(other.maritalStatus))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", dob=" + dob
				+ ", phoneNumber=" + phoneNumber + ", alternatePhoneNumber=" + alternatePhoneNumber + ", emailId="
				+ emailId + ", alternateEmailId=" + alternateEmailId + ", maritalStatus=" + maritalStatus + ", getId()="
				+ getId() + ", getVersion()=" + getVersion() + ", getCreatedUser()=" + getCreatedUser()
				+ ", getUpdatedUser()=" + getUpdatedUser() + ", getCreatedDate()=" + getCreatedDate()
				+ ", getUpdatedDate()=" + getUpdatedDate() + "]";
	}

}
