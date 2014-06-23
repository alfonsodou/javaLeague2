/**
 * 
 */
package org.javahispano.javaleague.client;

import org.javahispano.javaleague.client.event.ShowHomeEvent;
import org.javahispano.javaleague.client.event.ShowHomeEventHandler;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.History;

/**
 * @author adou
 * 
 */
public class AppController implements ValueChangeHandler<String> {
	private SimpleEventBus eventBus;

	public AppController(SimpleEventBus eventBus) {
		this.eventBus = eventBus;

		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);

		eventBus.addHandler(ShowHomeEvent.TYPE, new ShowHomeEventHandler() {

			@Override
			public void onShowHome(ShowHomeEvent event) {
				GWT.log("AppController: showHomeEvent received!");
				doShowHome();
			}

		});
	}
	
	private void doShowHome() {
		History.newItem("showHome");
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();
		
		if (token != null) {
			if (token.equals("showHome")) {
				return;
			}
		}

	}

}
