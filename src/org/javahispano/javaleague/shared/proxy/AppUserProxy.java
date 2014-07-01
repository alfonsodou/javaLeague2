/**
 * 
 */
package org.javahispano.javaleague.shared.proxy;

import org.javahispano.javaleague.domain.AppUser;
import org.javahispano.javaleague.server.locator.ObjectifyLocator;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

/**
 * @author adou
 * 
 */
@ProxyFor(value = AppUser.class, locator = ObjectifyLocator.class)
public interface AppUserProxy extends EntityProxy {
	String getAppUserName();
	String getEmail();
}
