/**
 * 
 */
package org.javahispano.javaleague.server.domain;

import java.util.logging.Logger;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;

/**
 * @author adou
 * 
 */
@Entity
public class AppUser extends DatastoreObject {

	private static final Logger log = Logger.getLogger(AppUser.class.getName());

	private String appUserName;
	@Index
	private String email;
	private String password;
	
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

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
