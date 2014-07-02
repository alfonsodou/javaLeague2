package org.javahispano.javaleague.client.mvp;

import org.javahispano.javaleague.client.mvp.place.ProfileEditPlace;
import org.javahispano.javaleague.client.mvp.place.ProfilePlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * PlaceHistoryMapper interface is used to attach all places which the
 * PlaceHistoryHandler should be aware of. This is done via the @WithTokenizers
 * annotation or by extending PlaceHistoryMapperWithFactory and creating a
 * separate TokenizerFactory.
 */
@WithTokenizers({ ProfilePlace.Tokenizer.class, ProfileEditPlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}