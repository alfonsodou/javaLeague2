/**
 * 
 */
package org.javahispano.javaleague.client.mvp;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author adou
 * 
 */
public class ListsPlace extends Place {

	public static class Tokenizer implements PlaceTokenizer<ListsPlace> {

		@Override
		public ListsPlace getPlace(String token) {
			return new ListsPlace();
		}

		@Override
		public String getToken(ListsPlace place) {
			return null;
		}

	}
}
