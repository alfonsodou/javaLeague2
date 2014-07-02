/**
 * 
 */
package org.javahispano.javaleague.client.ui;

import org.gwtbootstrap3.client.ui.AnchorListItem;
import org.gwtbootstrap3.client.ui.NavbarBrand;
import org.javahispano.javaleague.client.mvp.presenter.MenuPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


/**
 * @author adou
 * 
 */
public class MenuView extends Composite implements MenuPresenter.Display {

	private static MenuViewUiBinder uiBinder = GWT
			.create(MenuViewUiBinder.class);

	interface MenuViewUiBinder extends UiBinder<Widget, MenuView> {
	}

	public MenuView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	
	@UiField
	AnchorListItem registerLink;
	@UiField
	AnchorListItem loginLink;
	@UiField
	AnchorListItem frameWorkLink;
	@UiField
	AnchorListItem wikiLink;
	@UiField
	NavbarBrand navbarBrand;
	
	public MenuView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public HasClickHandlers getRegisterLink() {
		return (HasClickHandlers) registerLink;
	}

	@Override
	public HasClickHandlers getLoginLink() {
		return (HasClickHandlers) loginLink;
	}

	@Override
	public HasClickHandlers getFrameWorkLink() {
		return (HasClickHandlers) frameWorkLink;
	}

	@Override
	public HasClickHandlers getNavbarBrand() {
		return navbarBrand;
	}

	@Override
	public HasClickHandlers getWikiLink() {
		return (HasClickHandlers) wikiLink;
	}


}
