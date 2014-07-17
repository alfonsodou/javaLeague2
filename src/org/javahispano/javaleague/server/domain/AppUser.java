/**
 * 
 */
package org.javahispano.javaleague.server.domain;

import java.util.Date;
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
	private String token;
	private Date dateToken;
	private String locale;
	
	public AppUser() {
		this.locale = "es";
		
	}
	
	public AppUser(String appUserName, String email) {
		this.appUserName = appUserName;
		this.email = email;
		this.locale = "es";
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

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the dateToken
	 */
	public Date getDateToken() {
		return dateToken;
	}

	/**
	 * @param dateToken the dateToken to set
	 */
	public void setDateToken(Date dateToken) {
		this.dateToken = dateToken;
	}

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	
	
}
