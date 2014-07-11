/**
 * 
 */
package org.javahispano.javaleague.client;

import org.javahispano.javaleague.client.mvp.AppPlacesHistoryMapper;
import org.javahispano.javaleague.client.mvp.views.RegisterView;
import org.javahispano.javaleague.client.mvp.views.WelcomeView;
import org.javahispano.javaleague.client.mvp.views.uibinder.RegisterViewImpl;
import org.javahispano.javaleague.client.mvp.views.uibinder.WelcomeViewImpl;
import org.javahispano.javaleague.shared.service.JavaLeagueRequestFactory;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

/**
 * @author adou
 * 
 */
public class ClientFactoryImpl implements ClientFactory {
	private static EventBus eventBus = new SimpleEventBus();
	private static PlaceController placeController;

	private static WelcomeView welcomeView;
	private static RegisterView registerView;

	private final JavaLeagueRequestFactory javaLeagueRequestFactory = GWT
			.create(JavaLeagueRequestFactory.class);
	private final AppPlacesHistoryMapper historyMapper = GWT
			.create(AppPlacesHistoryMapper.class);

	public ClientFactoryImpl() {
		javaLeagueRequestFactory.initialize(eventBus);
	}

	@Override
	public EventBus getEventBus() {
		if (eventBus == null)
			eventBus = new SimpleEventBus();
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		if (placeController == null)
			placeController = new PlaceController(getEventBus());
		return placeController;
	}

	@Override
	public WelcomeView getWelcomeView() {
		if (welcomeView == null)
			welcomeView = new WelcomeViewImpl();
		return welcomeView;
	}

	@Override
	public RegisterView getRegisterView() {
		if (registerView == null)
			registerView = new RegisterViewImpl();
		return registerView;
	}

	@Override
	public JavaLeagueRequestFactory getRequestFactory() {
		return javaLeagueRequestFactory;
	}

	@Override
	public AppPlacesHistoryMapper getHistoryMapper() {
		return historyMapper;
	}

}
