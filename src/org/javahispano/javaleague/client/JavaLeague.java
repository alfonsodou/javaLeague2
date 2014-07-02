/**
 * 
 */
package org.javahispano.javaleague.client;

import org.javahispano.javaleague.client.mvp.place.ProfilePlace;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;

/**
 * @author adou
 * 
 */
public class JavaLeague extends ResizeComposite implements EntryPoint {
	private ClientFactory clientFactory = GWT.create(ClientFactory.class);
	private Place defaultPlace = new ProfilePlace("Daniel");
	SimplePanel center = new SimplePanel();
	SimplePanel top = new SimplePanel();
	SimplePanel bottom = new SimplePanel();
	DockLayoutPanel container = new DockLayoutPanel(Unit.PX);

	@Override
	public void onModuleLoad() {
		// Create ClientFactory using deferred binding so we can replace with
		// different
		// impls in gwt.xml
		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();
		JavaLeagueApp app = clientFactory.getApp();
		Widget appWidget = app.getAppWidget();

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		PlaceHistoryMapper historyMapper = clientFactory.getHistoryMapper();
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);

	    container.addNorth(top, 25);
	    container.add(center);
	    container.addSouth(bottom, 25);
	    initWidget(container);
	    container.setSize("100%","100%");
	    container.forceLayout();
	    
		RootPanel.get().add(appWidget);
		// Goes to place represented on URL or default place
		historyHandler.handleCurrentHistory();
		
		GWT.log("User agent: " + Window.Navigator.getUserAgent());
		
		// Hide wait GIF
		//DOM.removeChild(RootPanel.getBodyElement(), DOM.getElementById("loading"));
	}

	private String buildStackTrace(Throwable t, String log) {
		// return "disabled";
		if (t != null) {
			log += t.getClass().toString();
			log += t.getMessage();
			//
			StackTraceElement[] stackTrace = t.getStackTrace();
			if (stackTrace != null) {
				StringBuffer trace = new StringBuffer();

				for (int i = 0; i < stackTrace.length; i++) {
					trace.append(stackTrace[i].getClassName() + "."
							+ stackTrace[i].getMethodName() + "("
							+ stackTrace[i].getFileName() + ":"
							+ stackTrace[i].getLineNumber());
				}

				log += trace.toString();
			}
			//
			Throwable cause = t.getCause();
			if (cause != null && cause != t) {

				log += buildStackTrace(cause, "CausedBy:\n");

			}
		}
		return log;
	}
}