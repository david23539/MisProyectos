package com.example.FormacionEjemplo5;

import com.example.Vistas.Botones;
import com.example.Vistas.Combo;
import com.example.Vistas.Default;
import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.PushStateNavigation;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
@Theme("mytheme")
@PushStateNavigation
public class FormacionEjemplo5 extends UI {

	public static final String SELECTORES = "selectores";
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
//    	Titulo del menu
    	Label label = new Label("Menú de Contenidos");
    	label.addStyleName(ValoTheme.MENU_TITLE);
    	
//    	Secciones
    	Button button1 = new Button("Botones", e -> getNavigator().navigateTo("botones"));
    	button1.setIcon(VaadinIcons.VAADIN_H);
    	button1.addStyleName("v-iconCustom");
    	button1.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
    	
//    	Secciones
    	Button button2 = new Button("Combo", e -> getNavigator().navigateTo("combo"));
    	button2.setIcon(VaadinIcons.FAMILY);
    	button2.addStyleName("v-iconCustom");
    	button2.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
    	
//    	Menu
    	CssLayout menu = new CssLayout(label, button1, button2);
    	menu.addStyleName(ValoTheme.MENU_ROOT);
    	
    	CssLayout contenido1 = new CssLayout();
    	contenido1.setSizeFull();
    	
    	HorizontalLayout mainLayout = new HorizontalLayout(menu, contenido1);
    	
    	mainLayout.setExpandRatio(menu, 1);
    	mainLayout.setExpandRatio(contenido1, 7);
    	
    	mainLayout.setSizeFull();
    	setContent(mainLayout);
    	
//    	Contenido de la navegacion
    	Navigator navigator = new Navigator(this, contenido1);
    	
    	navigator.addView("", Default.class);
    	navigator.addView("botones", Botones.class);
    	navigator.addView("combo", Combo.class);
    }
}
