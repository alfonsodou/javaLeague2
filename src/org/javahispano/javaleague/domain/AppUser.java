/**
 * 
 */
package org.javahispano.javaleague.domain;

import java.util.logging.Logger;

import com.googlecode.objectify.annotation.Entity;

/**
 * @author adou
 * 
 */
@Entity
public class AppUser extends DatastoreObject {

	private static final Logger log = Logger.getLogger(AppUser.class.getName());

	private String appUserName;
	private String email;
	
	public AppUser() {
		
	}
	
	public AppUser(String appUserName, String email) {
		this.appUserName = appUserName;
		this.email = email;
	}

	/**
	 * @return the appUserName
	 */
	public String getAppUserName() {
		return appUserName;
	}

	/**
	 * @param appUserName the appUserName to set
	 */
	public void setAppUserName(String appUserName) {
		this.appUserName = appUserName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
