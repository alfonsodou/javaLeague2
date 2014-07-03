/**
 * 
 */
package org.javahispano.javaleague.client.mvp.ui;

import org.javahispano.javaleague.client.ClientFactory;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.http.client.UrlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author adou
 *
 */
public class AppPublicMenuBar extends Composite {
	
	interface AppPublicMenuBarUiBinder extends UiBinder<Widget, AppPublicMenuBar> {}
	private static AppPublicMenuBarUiBinder uiBinder = GWT.create(AppPublicMenuBarUiBinder.class);
	private ClientFactory clientFactory = GWT.create(ClientFactory.class);	
	
	@UiField
	HasClickHandlers localeES;
	@UiField
	HasClickHandlers localeEN;

	
	public AppPublicMenuBar(){
		initWidget(uiBinder.createAndBindUi(this));
		setUp();
	}	
	
	private void setUp() {
		localeES.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				GWT.log("AppPublicMenuBar: select locale ES");
				changeLocale("es");
			}
		});
		
		localeEN.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				GWT.log("AppPublicMenuBar: select locale EN");
				changeLocale("en");
			}
		});
		
	}
	
	private void changeLocale(String localeToUse){
		UrlBuilder newUrl = Window.Location.createUrlBuilder();
		newUrl.setParameter("locale", localeToUse);
		Window.Location.assign(newUrl.buildString());
	}	

}
