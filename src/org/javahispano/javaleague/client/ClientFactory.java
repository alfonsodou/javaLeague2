/**
 * 
 */
package org.javahispano.javaleague.client;

import org.javahispano.javaleague.client.ui.ProfileEditView;
import org.javahispano.javaleague.client.ui.ProfileView;

import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.web.bindery.event.shared.EventBus;


/**
 * @author adou
 *
 */
public interface ClientFactory {
    EventBus getEventBus();
    
    JavaLeagueApp getApp();

    PlaceController getPlaceController();

    PlaceHistoryMapper getHistoryMapper();
    
	ProfileView getProfileView();

	ProfileEditView getProfileEditView();    

/*    ListsView getListsView();

    EditListView getEditListView();

    ListwidgetRequestFactory getRequestFactory();

    ListwidgetApp getApp();*/
}
