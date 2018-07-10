package com.example.Vistas;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Composite;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
public class Botones extends Composite implements View{ 

	public Botones () {
		
//		setSizeFull();
		
		HorizontalLayout horizontalLayout = new HorizontalLayout();
//		
		Button boton1 = new Button("Azul sin borde");
		Button boton2 = new Button("Verde y Gordo");
		Button boton3 = new Button("Rojo y Chiquitin");
		Button boton4 = new Button("Youtube");
		Button boton5 = new Button("Diamante");
		Button boton6 = new Button("Cartera");
		Button boton7 = new Button("Back");
		
		boton1.addStyleNames(ValoTheme.BUTTON_PRIMARY, ValoTheme.BUTTON_BORDERLESS);
		
		boton2.addStyleNames(ValoTheme.BUTTON_FRIENDLY, ValoTheme.BUTTON_HUGE);
		
		boton3.addStyleNames(ValoTheme.BUTTON_DANGER, ValoTheme.BUTTON_TINY);
		
		boton4.setIcon(VaadinIcons.YOUTUBE);
		boton4.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
		
		boton5.setIcon(VaadinIcons.DIAMOND);
		boton5.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_RIGHT);
		
		boton6.setIcon(VaadinIcons.WALLET);
		boton6.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
		
		boton7.setIcon(VaadinIcons.BACKWARDS);
		
		boton7.addClickListener(event -> this.vuelta());
		
		horizontalLayout.addComponents(boton1, boton2, boton3, boton4, boton5, boton6, boton7);
		setCompositionRoot(horizontalLayout);
	}
	
	private void vuelta() {
		
	}
}
