/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Sindhu
 */
@Entity(name = "OCCASION")
public class Occasion extends BaseEntity implements Serializable {

	/**
	 * Default Serial Version UID
	 */
	private static final long serialVersionUID = -1573642778403291568L;

	@Column(name = "OCCASION_NAME", nullable = false)
	private String name;

	@Column(name = "OCCASION_DATE", nullable = false)
	private Date date;

	@Column(name = "REMINDME", nullable = false)
	private Boolean remindMe;

	@ManyToOne
	@JoinColumn(name = "PERSON_ID", nullable = false)
	private Person person;
	
	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
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

}
