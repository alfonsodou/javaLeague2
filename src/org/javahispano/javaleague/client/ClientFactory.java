/**
 * 
 */
package org.javahispano.javaleague.client;

import org.javahispano.javaleague.client.mvp.views.WelcomeView;

import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.web.bindery.event.shared.EventBus;


/**
 * @author adou
 *
 */
public interface ClientFactory {
    EventBus getEventBus();

    PlaceController getPlaceController();

    PlaceHistoryMapper getHistoryMapper();
     
    WelcomeView getWelcomeView();
    
/*    ListsView getListsView();

    EditListView getEditListView();

    ListwidgetRequestFactory getRequestFactory();

    ListwidgetApp getApp();*/
}
