/**
 * 
 */
package org.javahispano.javaleague.client.mvp.ui;

import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.Label;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.html.Paragraph;
import org.javahispano.javaleague.client.ClientFactory;
import org.javahispano.javaleague.client.mvp.places.WelcomePlace;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author adou
 * 
 */
public class AppRegisterUser extends Composite {

	private static AppRegisterUserUiBinder uiBinder = GWT
			.create(AppRegisterUserUiBinder.class);
	private ClientFactory clientFactory = GWT.create(ClientFactory.class);	

	interface AppRegisterUserUiBinder extends UiBinder<Widget, AppRegisterUser> {
	}

	@UiField
	FormPanel formPanelRegisterUser;
	@UiField
	TextBox userName;
	@UiField
	TextBox email;
	@UiField
	TextBox teamName;
	@UiField
	Input password;
	@UiField
	Input rePassword;
	@UiField
	Label errorUserName;
	@UiField
	Label errorTeamName;
	@UiField
	Label errorEmail;
	@UiField
	Label errorPassword;
	@UiField
	Label errorPasswordSize;
	@UiField
	Label errorRegisterEmail;
	@UiField
	Paragraph textSendEmail;

	public AppRegisterUser() {
		initWidget(uiBinder.createAndBindUi(this));

		setUp();
	}

	private void setUp() {
		hideErrorLabel();
		
		// Add an event handler to the form.
		formPanelRegisterUser.addSubmitHandler(new FormPanel.SubmitHandler() {
			public void onSubmit(SubmitEvent event) {
				hideErrorLabel();
				if (userName.getText().length() < 4) {
					errorUserName.setVisible(true);
					event.cancel();
				}
				
				if (teamName.getText().length() == 0) {
					errorTeamName.setVisible(true);
					event.cancel();
				}
				
				if (password.getText().length() < 4) {
					errorPasswordSize.setVisible(true);
					event.cancel();
				}

				if (!password.getText().equals(rePassword.getText())) {
					errorPassword.setVisible(true);
					event.cancel();
				}

			}
		});

		formPanelRegisterUser
				.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
					public void onSubmitComplete(SubmitCompleteEvent event) {
						// When the form submission is successfully completed,
						// this event is
						// fired. Assuming the service returned a response of
						// type text/html,
						// we can get the result text here (see the FormPanel
						// documentation for
						// further explanation).
						Window.alert(event.getResults());
					}
				});
	}

	@UiHandler("registerButton")
	void onRegister(ClickEvent event) {
		formPanelRegisterUser.submit();
	}

	@UiHandler("cancelButton")
	void onClick(ClickEvent event) {
		hideErrorLabel();
		goTo(new WelcomePlace());
	}
	
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}	

	/**
	 * minimum email l@n.co
	 * */
	public static boolean checkEmail(final String emlId) {
		// ex:ak@bv.gh
		if (emlId == null) {
			return false;
		}
		final int lngth = emlId.length();
		if (lngth < 6) {
			return false;
		}
		final int locationAt = emlId.indexOf('@');
		if (locationAt < 1) {
			return false;
		}
		final int postLastPeriod = emlId.lastIndexOf('.');
		if (postLastPeriod < 0) {
			return false;
		}
		if (lngth - postLastPeriod < 3) {
			return false;
		}
		if (postLastPeriod - locationAt < 1) {
			return false;
		}
		return true;

	}

	private void hideErrorLabel() {
		errorUserName.setVisible(false);
		errorTeamName.setVisible(false);
		errorEmail.setVisible(false);
		errorPassword.setVisible(false);
		errorPasswordSize.setVisible(false);
		errorRegisterEmail.setVisible(false);
		textSendEmail.setVisible(false);
	}
}
