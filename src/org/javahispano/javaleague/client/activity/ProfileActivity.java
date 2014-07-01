/** 
 * Copyright 2010 Daniel Guermeur and Amy Unruh
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 *   See http://connectrapp.appspot.com/ for a demo, and links to more information 
 *   about this app and the book that it accompanies.
 */
package org.javahispano.javaleague.client.activity;


import org.javahispano.javaleague.client.ClientFactory;
import org.javahispano.javaleague.client.place.ProfilePlace;
import org.javahispano.javaleague.client.ui.ProfileView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;


public class ProfileActivity extends AbstractActivity implements ProfileView.Presenter {
	private ClientFactory clientFactory;
	private String name;

	public ProfileActivity(ProfilePlace place, ClientFactory clientFactory) {
		this.name = place.getProfileName();
		this.clientFactory = clientFactory;
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		ProfileView profileView = clientFactory.getProfileView();
		profileView.setName(name);
		profileView.setPresenter(this);
		containerWidget.setWidget(profileView.asWidget());
	}

	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}

	/*
	@Override public String mayStop() {
		return "Are you sure you want to leave this view?";
	}
	*/


}