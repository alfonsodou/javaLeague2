/**
 * 
 */
package org.javahispano.javaleague.client.ui.desktop;

import org.javahispano.javaleague.client.ClientFactory;
import org.javahispano.javaleague.client.JavaLeagueApp;
import org.javahispano.javaleague.client.mvp.BottomActivityMapper;
import org.javahispano.javaleague.client.mvp.CenterActivityMapper;
import org.javahispano.javaleague.client.mvp.TopActivityMapper;
import org.javahispano.javaleague.client.place.ProfilePlace;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;

/**
 * @author adou
 * 
 */
public class DesktopApp implements JavaLeagueApp {

	private Place defaultPlace = new ProfilePlace("Daniel");
	private final ClientFactory clientFactory;

	public DesktopApp(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public Widget getAppWidget() {
		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();

		/*
		 * The new DockLayoutPanel attaches to the whole browser window because
		 * it uses absolute positioning to get improved efficiency in the
		 * browser. But we want to run the GWT app in a div (not the whole
		 * page), so we have to use the older DockPanel instead.
		 */
		DockPanel dockPanel = new DockPanel();
		dockPanel.setSpacing(20);

		SimplePanel topPanel = new SimplePanel();
		dockPanel.add(topPanel, DockPanel.NORTH);
		// dockLayoutPanel.addWest(topPanel, 20);

		SimplePanel centerPanel = new SimplePanel();
		dockPanel.add(centerPanel, DockPanel.CENTER);

		SimplePanel bottomPanel = new SimplePanel();
		dockPanel.add(bottomPanel, DockPanel.SOUTH);

		// Start ActivityManager for the nav (top) panel with our
		// TopActivityMapper
		ActivityMapper topActivityMapper = new TopActivityMapper(
				clientFactory);
		ActivityManager topActivityManager = new ActivityManager(
				topActivityMapper, eventBus);
		topActivityManager.setDisplay(topPanel);

		// Start ActivityManager for the main (center) panel with our
		// CenterActivityMapper
		ActivityMapper centerActivityMapper = new CenterActivityMapper(
				clientFactory);
		ActivityManager centerActivityManager = new ActivityManager(
				centerActivityMapper, eventBus);
		centerActivityManager.setDisplay(centerPanel);

		// Start ActivityManager for the footer (bottom) panel with our
		// CenterActivityMapper
		ActivityMapper bottomActivityMapper = new BottomActivityMapper(
				clientFactory);
		ActivityManager bottomActivityManager = new ActivityManager(
				bottomActivityMapper, eventBus);
		bottomActivityManager.setDisplay(bottomPanel);
		
		return dockPanel;
	}

}
