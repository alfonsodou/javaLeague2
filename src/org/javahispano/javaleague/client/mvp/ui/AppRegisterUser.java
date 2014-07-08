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

	public AppRegisterUser() {
		initWidget(uiBinder.createAndBindUi(this));
		
		setUp();
	}

	private void setUp() {
	    // Add an event handler to the form.
	    formPanelRegisterUser.addSubmitHandler(new FormPanel.SubmitHandler() {
	      public void onSubmit(SubmitEvent event) {
	        // This event is fired just before the form is submitted. We can take
	        // this opportunity to perform validation.
	        if (userName.getText().length() == 0) {
	          Window.alert("The text box must not be empty");
	          event.cancel();
	        }
	      }
	    });

	    formPanelRegisterUser.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
	      public void onSubmitComplete(SubmitCompleteEvent event) {
	        // When the form submission is successfully completed, this event is
	        // fired. Assuming the service returned a response of type text/html,
	        // we can get the result text here (see the FormPanel documentation for
	        // further explanation).
	        Window.alert(event.getResults());
	      }
	    });		
	}
	
	@UiHandler("registerButton")
	void onRegister(ClickEvent event) {
		formPanelRegisterUser.submit();
	}

}
