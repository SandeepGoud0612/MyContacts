/**
 *  This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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

	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	private Image image;

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Address> addressList = new ArrayList<>();
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Occasion> occasionList = new ArrayList<>();
	
	/**
	 * @return the addressList
	 */
	public List<Address> getAddressList() {
		return addressList;
	}

	/**
	 * @param addressList the addressList to set
	 */
	public void setAddressList(final List<Address> addressList) {
		this.addressList = addressList;
	}

	/**
	 * @return the occasionList
	 */
	public List<Occasion> getOccasionList() {
		return occasionList;
	}

	/**
	 * @param occasionList the occasionList to set
	 */
	public void setOccasionList(final List<Occasion> occasionList) {
		this.occasionList = occasionList;
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(final Image image) {
		this.image = image;
	}

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
	public void setFirstName(final String firstName) {
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
	public void setLastName(final String lastName) {
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
	public void setGender(final Gender gender) {
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
	public void setDob(final Date dob) {
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
	public void setPhoneNumber(final String phoneNumber) {
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
	public void setAlternatePhoneNumber(final String alternatePhoneNumber) {
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
	public void setEmailId(final String emailId) {
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
	public void setAlternateEmailId(final String alternateEmailId) {
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
	public void setMaritalStatus(final Boolean maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

}
