package com.example.Vistas;

import com.vaadin.navigator.View;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupView.Content;

@SuppressWarnings("serial")
public class Default extends Composite implements View{

	
	public Default () {
		
		setCompositionRoot(new Label("Aqui comenzara nuesta pantalla"));
	}
}
