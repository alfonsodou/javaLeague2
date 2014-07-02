package org.javahispano.javaleague.client.mvp.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 * @author adou
 *
 */
public interface LogoutEventHandler extends EventHandler {
  void onLogout(LogoutEvent event);
}
