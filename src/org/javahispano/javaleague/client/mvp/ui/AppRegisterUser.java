/**
 * 
 */
package org.javahispano.javaleague.client.mvp.ui;

import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
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

	interface AppRegisterUserUiBinder extends UiBinder<Widget, AppRegisterUser> {
	}

	@UiField
	FormPanel formRegisterUser;
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

	public AppRegisterUser() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("formRegisterUser")
	void onValidate(SubmitEvent event) {
		StringBuilder errors = new StringBuilder();
	}

	@UiHandler("formRegisterUser")
	void onResults(SubmitCompleteEvent event) {
		Window.alert(event.getResults());
	}

	@UiHandler("registerButton")
	void onRegister(ClickEvent event) {
		formRegisterUser.submit();
	}

}
