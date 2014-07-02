/**
 * 
 */
package org.javahispano.javaleague.client.mvp;

import org.javahispano.javaleague.client.ClientFactory;
import org.javahispano.javaleague.client.mvp.activity.ProfileActivity;
import org.javahispano.javaleague.client.mvp.activity.ProfileEditActivity;
import org.javahispano.javaleague.client.mvp.place.ProfileEditPlace;
import org.javahispano.javaleague.client.mvp.place.ProfilePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

/**
 * @author adou
 * 
 */
public class CenterActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	/**
	 * AppActivityMapper associates each Place with its corresponding
	 * {@link Activity}
	 * 
	 * @param clientFactory
	 *            Factory to be passed to activities
	 */
	public CenterActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	/**
	 * Map each Place to its corresponding Activity.
	 */
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof ProfilePlace)
			return new ProfileActivity((ProfilePlace) place, clientFactory);
		else if (place instanceof ProfileEditPlace)
			return new ProfileEditActivity((ProfileEditPlace) place,
					clientFactory);

		return null;
	}

}