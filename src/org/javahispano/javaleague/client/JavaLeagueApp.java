/**
 * 
 */
package org.javahispano.javaleague.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author adou
 * 
 */
public class JavaLeagueApp implements EntryPoint {
	interface JavaLeagueAppUiBinder extends UiBinder<Widget, JavaLeagueApp> {
	}

	private static JavaLeagueAppUiBinder ourUiBinder = GWT
			.create(JavaLeagueAppUiBinder.class);

	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		
	}
}