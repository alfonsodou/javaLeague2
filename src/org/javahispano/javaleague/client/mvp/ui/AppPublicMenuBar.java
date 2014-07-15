/**
 * 
 */
package org.javahispano.javaleague.client.mvp.ui;

import org.gwtbootstrap3.client.ui.AnchorButton;
import org.javahispano.javaleague.client.ClientFactory;
import org.javahispano.javaleague.client.mvp.places.RegisterPlace;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.http.client.UrlBuilder;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author adou
 * 
 */
public class AppPublicMenuBar extends Composite {

	interface AppPublicMenuBarUiBinder extends
			UiBinder<Widget, AppPublicMenuBar> {
	}

	private static AppPublicMenuBarUiBinder uiBinder = GWT
			.create(AppPublicMenuBarUiBinder.class);
	private ClientFactory clientFactory = GWT.create(ClientFactory.class);

	@UiField
	HasClickHandlers localeES;
	@UiField
	HasClickHandlers localeEN;
	@UiField
	AnchorButton locale;
	@UiField
	HasClickHandlers registerLink;

	public AppPublicMenuBar() {
		initWidget(uiBinder.createAndBindUi(this));
		setUp();
	}

	private void setUp() {
		if (Window.Location.getParameter("locale") != null) {
			if (Window.Location.getParameter("locale").equals("es")) {
				locale.setText("Español (es)");
			} else if (Window.Location.getParameter("locale").equals("en")) {
				locale.setText("English (en)");
			}
		} else {
			if (Cookies.getCookie("locale") != null) {
				changeLocale(Cookies.getCookie("locale"));
			}
		}

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

		registerLink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				GWT.log("AppPublicMenuBar: select Register");
				goTo(new RegisterPlace());
			}
		});
	}

	private void changeLocale(String localeToUse) {
		UrlBuilder newUrl = Window.Location.createUrlBuilder();
		newUrl.setParameter("locale", localeToUse);
		Window.Location.assign(newUrl.buildString());
		Cookies.setCookie("locale", localeToUse);
	}

	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}

}
