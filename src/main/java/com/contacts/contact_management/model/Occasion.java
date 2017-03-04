/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Sindhu
 */
@Entity(name = "OCCASION")
public class Occasion extends BaseEntity implements Serializable {

	/**
	 * Default Serial Version UID
	 */
	private static final long serialVersionUID = -1573642778403291568L;

	@Column(name = "OCCASION_NAME", nullable = false, length = 100)
	@NotNull
	@Size(min = 1, max = 100)
	private String name;

	@Column(name = "OCCASION_DATE", nullable = false)
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "REMINDME", nullable = false)
	@NotNull
	private Boolean remindMe;

	@ManyToOne
	@JoinColumn(name = "PERSON_ID", nullable = false)
	@NotNull
	@JsonIgnore
	private Person person;

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person
	 *            the person to set
	 */
	public void setPerson(final Person person) {
		this.person = person;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(final Date date) {
		this.date = date;
	}

	/**
	 * @return the remindMe
	 */
	public Boolean getRemindMe() {
		return remindMe;
	}

	/**
	 * @param remindMe
	 *            the remindMe to set
	 */
	public void setRemindMe(final Boolean remindMe) {
		this.remindMe = remindMe;
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
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + ((remindMe == null) ? 0 : remindMe.hashCode());
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
		Occasion other = (Occasion) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (remindMe == null) {
			if (other.remindMe != null)
				return false;
		} else if (!remindMe.equals(other.remindMe))
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
		return "Occasion [name=" + name + ", date=" + date + ", remindMe=" + remindMe + ", getId()=" + getId()
				+ ", getVersion()=" + getVersion() + "]";
	}

}
