/**
 * 
 */
package org.javahispano.javaleague.client;

import com.google.common.eventbus.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryMapper;

/**
 * @author adou
 *
 */
public interface ClientFactory {
    EventBus getEventBus();

    PlaceController getPlaceController();

    PlaceHistoryMapper getHistoryMapper();

    ListsView getListsView();

    EditListView getEditListView();

    ListwidgetRequestFactory getRequestFactory();

    ListwidgetApp getApp();
}
