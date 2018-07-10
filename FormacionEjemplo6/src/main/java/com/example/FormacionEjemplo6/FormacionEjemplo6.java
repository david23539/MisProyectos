package com.example.FormacionEjemplo6;

import com.example.Vistas.Login;
import com.example.Vistas.Principal;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.PushStateNavigation;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
@PushStateNavigation
public class FormacionEjemplo6 extends UI {
	
	Navigator navigator;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
//      Crear un navegador para controlar las Vistas
        navigator = new Navigator(this, this);
        navigator.addView("", Login.class);
        navigator.addView("principal", Principal.class);
    }
}
