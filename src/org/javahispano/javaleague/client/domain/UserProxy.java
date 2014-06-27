/**
 * 
 */
package org.javahispano.javaleague.client.domain;

import org.javahispano.javaleague.server.domain.User;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

/**
 * @author adou
 *
 */
@ProxyFor(User.class)
public interface UserProxy extends EntityProxy {
	Long getId();
	
	String getUserName();
}
