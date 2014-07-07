/**
 * 
 */
package org.javahispano.javaleague.client;

import org.javahispano.javaleague.client.mvp.AppPlaceHistoryMapper;
import org.javahispano.javaleague.client.mvp.views.RegisterView;
import org.javahispano.javaleague.client.mvp.views.WelcomeView;
import org.javahispano.javaleague.client.mvp.views.uibinder.RegisterViewImpl;
import org.javahispano.javaleague.client.mvp.views.uibinder.WelcomeViewImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

/**
 * @author adou
 * 
 */
public class ClientFactoryImpl implements ClientFactory {
	private final EventBus eventBus = new SimpleEventBus();
	private final PlaceController placeController = new PlaceController(
			eventBus);
	private final PlaceHistoryMapper historyMapper = GWT
			.create(AppPlaceHistoryMapper.class);
	private static WelcomeView welcomeView;
	private static RegisterView registerView;

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public PlaceHistoryMapper getHistoryMapper() {
		return historyMapper;
	}
	
	@Override
	public WelcomeView getWelcomeView() {
		if (welcomeView == null) welcomeView = new WelcomeViewImpl();
		return welcomeView;
	}

	@Override
	public RegisterView getRegisterView() {
		if (registerView == null) registerView = new RegisterViewImpl();
		return registerView;
	}	

}
