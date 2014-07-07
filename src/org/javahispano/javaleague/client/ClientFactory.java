/**
 * 
 */
package org.javahispano.javaleague.client;

import org.javahispano.javaleague.client.mvp.views.RegisterView;
import org.javahispano.javaleague.client.mvp.views.WelcomeView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

/**
 * @author adou
 * 
 */
public interface ClientFactory {
	public EventBus getEventBus();

	public PlaceController getPlaceController();

	WelcomeView getWelcomeView();

	RegisterView getRegisterView();

	/*
	 * ListsView getListsView();
	 * 
	 * EditListView getEditListView();
	 * 
	 * ListwidgetRequestFactory getRequestFactory();
	 * 
	 * ListwidgetApp getApp();
	 */
}
