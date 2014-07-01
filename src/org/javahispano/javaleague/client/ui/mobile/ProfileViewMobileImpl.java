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
package org.javahispano.javaleague.client.ui.mobile;

import org.javahispano.javaleague.client.place.ProfileEditPlace;
import org.javahispano.javaleague.client.ui.ProfileView;
import org.javahispano.javaleague.client.ui.ProfileView.Presenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


public class ProfileViewMobileImpl extends Composite implements ProfileView
{
	private static ProfileViewImplUiBinder uiBinder = GWT.create(ProfileViewImplUiBinder.class);

	interface ProfileViewImplUiBinder extends UiBinder<Widget, ProfileViewMobileImpl>
	{
	}
 
	@UiField SpanElement nameSpan;
	@UiField Anchor editLink;
	private Presenter listener;
	private String name;

	public ProfileViewMobileImpl()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setName(String name)
	{ 
		this.name = name;
		nameSpan.setInnerText(name);
	}

	@UiHandler("editLink")
	void onClickEdit(ClickEvent e)
	{
		listener.goTo(new ProfileEditPlace(name));
	}

	@Override
	public void setPresenter(Presenter listener)
	{
		this.listener = listener;
	}
}