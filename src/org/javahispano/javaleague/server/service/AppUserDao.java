/**
 * 
 */
package org.javahispano.javaleague.server.service;

import org.javahispano.javaleague.server.domain.AppUser;
import org.javahispano.javaleague.shared.exception.TooManyResultsException;

import com.google.appengine.api.datastore.EntityNotFoundException;

/**
 * @author adou
 * 
 */
public class AppUserDao extends ObjectifyDao<AppUser> {

	public void save(AppUser appUser) {
		this.put(appUser);
	}

	public void remove(Long id) {
		try {
			AppUser appUser = this.get(id);
			this.delete(appUser);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
	}

	public AppUser fetch(Long id) {
		AppUser appUser = null;
		try {
			appUser = this.get(id);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}

		return appUser;
	}

	public AppUser findByEmail(String email) {
		AppUser appUser = null;
		try {
			appUser = this.getByProperty("email", email);
		} catch (TooManyResultsException e) {
			e.printStackTrace();
		}

		return appUser;
	}

	public Boolean newUser(AppUser appUser) {
		AppUser appUserTemp = null;
		try {
			appUserTemp = this.getByProperty("email", appUser.getEmail());
			if (appUserTemp == null) {
				this.put(appUser);
				return Boolean.TRUE;
			}
		} catch (TooManyResultsException e) {
			e.printStackTrace();
		}

		return Boolean.FALSE;
	}
}
