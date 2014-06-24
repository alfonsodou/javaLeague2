/**
 * 
 */
package org.javahispano.javaleague.client;

import org.javahispano.javaleague.client.event.ShowHomeEvent;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
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

	private static JavaLeagueApp singleton;
	private SimpleEventBus eventBus;
	private AppController appViewer;
	
	@UiField
	SimplePanel centerPanel;
	@UiField
	SimplePanel headerPanel;

	/**
	 * Gets the singleton application instance.
	 */
	public static JavaLeagueApp get() {
		return singleton;
	}
	
	public SimpleEventBus getEventBus() {
		return eventBus;
	}

	public void setEventBus(SimpleEventBus eventBus) {
		this.eventBus = eventBus;
	}
	
	public SimplePanel getHeaderPanel() {
		return headerPanel;
	}
	
	public SimplePanel getCenterPanel() {
		return centerPanel;
	}

	@Override
	public void onModuleLoad() {
		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void onUncaughtException(Throwable e) {
				Window.alert("uncaught: " + e.getMessage());
				String s = buildStackTrace(e, "RuntimeException:\n");
				Window.alert(s);
				e.printStackTrace();

			}
		});
		
		singleton = this;
		
		RootPanel.get().add(ourUiBinder.createAndBindUi(this));
		
		bind();
	}
	
	private void bind() {
		eventBus = new SimpleEventBus();
		appViewer = new AppController(eventBus);
		appViewer.go();
		
		//eventBus.fireEvent(new ShowHomeEvent(null));
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