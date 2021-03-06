package org.javahispano.javaleague.client.mvp;

import org.javahispano.javaleague.client.ClientFactory;
import org.javahispano.javaleague.client.mvp.activities.RegisterActivity;
import org.javahispano.javaleague.client.mvp.activities.WelcomeActivity;
import org.javahispano.javaleague.client.mvp.places.RegisterPlace;
import org.javahispano.javaleague.client.mvp.places.WelcomePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	public AppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	public Activity getActivity(Place place) {
		if (place instanceof WelcomePlace)
			return new WelcomeActivity((WelcomePlace) place, clientFactory);
		else if (place instanceof RegisterPlace) 
			return new RegisterActivity((RegisterPlace) place, clientFactory);
		else return null;
	}
}
