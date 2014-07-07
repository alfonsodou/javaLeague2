/**
 * 
 */
package org.javahispano.javaleague.client.resources.messages;

import com.google.gwt.i18n.client.LocalizableResource.DefaultLocale;
import com.google.gwt.i18n.client.Messages;

/**
 * @author adou
 *
 */
@DefaultLocale("es")
public interface RegisterUserMessages extends Messages {
	String errorUserName();
	String errorEmail();
	String errorTeamName();
	String errorRegisterEmail();
	String errorPassword();
	String errorPasswordSize();
}
