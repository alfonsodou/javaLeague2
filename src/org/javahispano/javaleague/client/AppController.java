/**
 * 
 */
package org.javahispano.javaleague.client;

import org.javahispano.javaleague.client.event.ShowHomeEvent;
import org.javahispano.javaleague.client.event.ShowHomeEventHandler;
import org.javahispano.javaleague.client.presenter.MenuPresenter;
import org.javahispano.javaleague.client.presenter.Presenter;
import org.javahispano.javaleague.client.presenter.ShowHomePresenter;
import org.javahispano.javaleague.client.view.MenuView;
import org.javahispano.javaleague.client.view.ShowHomeView;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.History;

/**
 * @author adou
 * 
 */
public class AppController implements ValueChangeHandler<String> {
	private SimpleEventBus eventBus;
	private Long userId;

	public AppController(SimpleEventBus eventBus) {
		this.eventBus = eventBus;

		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);

		eventBus.addHandler(ShowHomeEvent.TYPE, new ShowHomeEventHandler() {

			@Override
			public void onShowHome(ShowHomeEvent event) {
				GWT.log("AppController: showHomeEvent received!");
				if (event.getUserId() != null) {
					userId = event.getUserId();
					doShowHomePrivate();
				} else {
					doShowHome();
				}
			}

		});
	}

	private void doShowHome() {
		History.newItem("showHome");
	}

	private void doShowHomePrivate() {
		History.newItem("showHomePrivate");
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();

		if (token != null) {
			Presenter presenter = null;
			if (token.equals("showHome")) {
				JavaLeagueApp.get().getHeaderPanel().clear();
				MenuPresenter menuPresenter = new MenuPresenter(eventBus,
						userAccountService, new MenuView());
				menuPresenter.go(JavaLeagueApp.get().getHeaderPanel());

				JavaLeagueApp.get().getCenterPanel().clear();
				ShowHomePresenter showHomePresenter = new ShowHomePresenter(
						new ShowHomeView());
				showHomePresenter.go(JavaLeagueApp.get().getCenterPanel());
				
				return;
			} else if (token.equals("showHomePrivate")) {
				return;
			}
		}

	}

}
