/**
 * 
 */
package org.javahispano.javaleague.server.service;

import org.javahispano.javaleague.server.domain.AppUser;

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

}
