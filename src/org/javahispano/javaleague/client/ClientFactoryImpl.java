/**
 * 
 */
package org.javahispano.javaleague.client;

import org.javahispano.javaleague.client.mvp.AppPlaceHistoryMapper;
import org.javahispano.javaleague.client.ui.ProfileEditView;
import org.javahispano.javaleague.client.ui.ProfileView;
import org.javahispano.javaleague.client.ui.desktop.DesktopApp;
import org.javahispano.javaleague.client.ui.desktop.ProfileEditViewImpl;
import org.javahispano.javaleague.client.ui.desktop.ProfileViewImpl;

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
	private final ProfileView profileView = new ProfileViewImpl();
	private final ProfileEditView profileEditView = new ProfileEditViewImpl();
	private final JavaLeagueApp app = new DesktopApp(this);
	private final PlaceHistoryMapper historyMapper = GWT
			.create(AppPlaceHistoryMapper.class);

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public ProfileView getProfileView() {
		return profileView;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public ProfileEditView getProfileEditView() {
		return profileEditView;
	}

	@Override
	public PlaceHistoryMapper getHistoryMapper() {
		return historyMapper;
	}

	@Override
	public JavaLeagueApp getApp() {
		return app;
	}
}
