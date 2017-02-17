/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author Sandeep
 */
@Entity(name = "IMAGE")
public class Image extends BaseEntity implements Serializable {

	/**
	 * Default Serial Version UID
	 */
	private static final long serialVersionUID = -6741704416876382225L;

	@Column(name = "IMAGE", nullable = false)
	private byte[] image;

	@Column(name = "TAG", nullable = false)
	private String tag;

	@OneToOne
	@JoinColumn(name = "PERSON_ID", nullable = false)
	private Person person;

	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(final byte[] image) {
		this.image = image;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag
	 *            the tag to set
	 */
	public void setTag(final String tag) {
		this.tag = tag;
	}

}
