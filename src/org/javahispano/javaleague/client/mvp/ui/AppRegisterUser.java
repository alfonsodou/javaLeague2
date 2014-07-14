/**
 * 
 */
package org.javahispano.javaleague.client.mvp.ui;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.gwtbootstrap3.client.ui.Form;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.Label;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.html.Paragraph;
import org.javahispano.javaleague.client.ClientFactory;
import org.javahispano.javaleague.client.mvp.places.WelcomePlace;
import org.javahispano.javaleague.shared.proxy.AppUserProxy;
import org.javahispano.javaleague.shared.service.AppUserService;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.shared.Receiver;

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
	Form formRegisterUser;
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
		formRegisterUser.reset();
	}

	@UiHandler("registerButton")
	void onRegister(ClickEvent event) {
		boolean error = false;

		hideErrorLabel();

		if (userName.getText().length() < 4) {
			errorUserName.setVisible(true);
			error = true;
		}
		
		if (!checkEmail(email.getText())) {
			errorEmail.setVisible(true);
			error = true;
		}

		if (teamName.getText().length() == 0) {
			errorTeamName.setVisible(true);
			error = true;
		}

		if (password.getText().length() < 4) {
			errorPasswordSize.setVisible(true);
			error = true;
		}

		if (!password.getText().equals(rePassword.getText())) {
			errorPassword.setVisible(true);
			error = true;
		}

		if (!error) {
			MessageDigest crypt = null;

			try {
				crypt = java.security.MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				Window.alert("MD5 not supported");
				return;
			}

			byte[] digested = crypt.digest(password.getValue().getBytes());

			String crypt_password = new String();

			// Converts bytes to string
			for (byte b : digested)
				crypt_password += Integer.toHexString(0xFF & b);

			AppUserService appUserService = clientFactory.getRequestFactory()
					.appUserService();
			AppUserProxy appUser = appUserService.create(AppUserProxy.class);
			appUser.setAppUserName(userName.getText());
			appUser.setEmail(email.getValue());
			appUser.setPassword(crypt_password);
			
			appUserService.save(appUser).fire(new Receiver<Void>() {
				@Override
				public void onSuccess(Void response) {
					//GWT.log("Guardado OK!");
					Window.alert("OK!!!");
					formRegisterUser.reset();
					
				}
			});
		}
		// formPanelRegisterUser.submit();
	}

	@UiHandler("cancelButton")
	void onClick(ClickEvent event) {
		hideErrorLabel();
		formRegisterUser.reset();
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
