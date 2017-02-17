/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Sindhu
 */
@Entity(name="OCCASION")
public class Occasion extends BaseEntity implements Serializable {
	
	/**
	 * Default Serial Version UID
	 */
	private static final long serialVersionUID = -1573642778403291568L;

	@Column(name="OCCASION_NAME")
	private String name;
	
	@Column(name="OCCASION_DATE")
	private Date date;
	
	@Column(name="REMINDME")
	private Boolean remindMe;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the remindMe
	 */
	public Boolean getRemindMe() {
		return remindMe;
	}

	/**
	 * @param remindMe the remindMe to set
	 */
	public void setRemindMe(Boolean remindMe) {
		this.remindMe = remindMe;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Occasion [name=" + name + ", date=" + date + ", remindMe=" + remindMe + ", getId()=" + getId()
				+ ", getVersion()=" + getVersion() + ", getCreatedUser()=" + getCreatedUser() + ", getUpdatedUser()="
				+ getUpdatedUser() + ", getCreatedDate()=" + getCreatedDate() + ", getUpdatedDate()=" + getUpdatedDate()
				+ "]";
	}
	
}
