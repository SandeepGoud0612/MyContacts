/**
 *  This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;

import com.contacts.contact_management.enums.Gender;
import com.contacts.contact_management.enums.MaritalStatus;

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
	@NotNull
	@Size(min = 1, max = 50)
	private String firstName;

	@Column(name = "LAST_NAME", length = 50, nullable = false)
	@NotNull
	@Size(min = 1, max = 50)
	private String lastName;

	@Column(name = "GENDER", length = 10, nullable = false)
	@NotNull
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "DOB")
	@Temporal(TemporalType.DATE)
	@Past
	private Date dob;

	@Transient
	private static final long PHONEMAX = 999999999999L;

	@Column(name = "PHONE_NUMBER", nullable = false, length = 15)
	@NotNull
	@Max(PHONEMAX)
	private Long phoneNumber;

	@Column(name = "ALTERNATE_PHONE_NUMBER", length = 15)
	@Max(PHONEMAX)
	private Long alternatePhoneNumber;

	@Column(name = "EMAIL_ID", length = 50, nullable = false)
	@NotNull
	@Email
	@Size(min = 1, max = 50)
	private String emailId;

	@Column(name = "ALTERNATE_EMAIL_ID", length = 50)
	@Email
	@Size(min = 0, max = 50)
	private String alternateEmailId;

	@Column(name = "MARITAL_STATUS")
	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus;

	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.TRUE)
	private Image image;

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.TRUE)
	private List<Address> addressList = new ArrayList<>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.TRUE)
	private List<Occasion> occasionList = new ArrayList<>();

	/**
	 * @return the addressList
	 */
	public List<Address> getAddressList() {
		return addressList;
	}

	/**
	 * @param addressList
	 *            the addressList to set
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
	 * @param occasionList
	 *            the occasionList to set
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
	public Long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(final Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the alternatePhoneNumber
	 */
	public Long getAlternatePhoneNumber() {
		return alternatePhoneNumber;
	}

	/**
	 * @param alternatePhoneNumber
	 *            the alternatePhoneNumber to set
	 */
	public void setAlternatePhoneNumber(final Long alternatePhoneNumber) {
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
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * @param maritalStatus
	 *            the maritalStatus to set
	 */
	public void setMaritalStatus(final MaritalStatus maritalStatus) {
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
		result = prime * result + ((addressList == null) ? 0 : addressList.hashCode());
		result = prime * result + ((alternateEmailId == null) ? 0 : alternateEmailId.hashCode());
		result = prime * result + ((alternatePhoneNumber == null) ? 0 : alternatePhoneNumber.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((maritalStatus == null) ? 0 : maritalStatus.hashCode());
		result = prime * result + ((occasionList == null) ? 0 : occasionList.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (addressList == null) {
			if (other.addressList != null)
				return false;
		} else if (!addressList.equals(other.addressList))
			return false;
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
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
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
		if (occasionList == null) {
			if (other.occasionList != null)
				return false;
		} else if (!occasionList.equals(other.occasionList))
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
				+ emailId + ", alternateEmailId=" + alternateEmailId + ", maritalStatus=" + maritalStatus + ", image="
				+ image + ", addressList=" + addressList + ", occasionList=" + occasionList + ", getId()=" + getId()
				+ ", getVersion()=" + getVersion() + "]";
	}

}
