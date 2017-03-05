/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.enums;

/**
 * @author Sandeep
 *
 */
public enum MaritalStatus {
	
	Select("select"),Married("married"), Single("single");
	
	private final String maritalStatus;
	
	private MaritalStatus(String maritalStatus){
		this.maritalStatus = maritalStatus;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}
	
}
