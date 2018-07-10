package com.example.FormacionEjemplo4;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class FormacionEjemplo4 extends UI {

	protected static final String PANTALLA0 = "";
	protected static final String PANTALLA1 = "pantalla1";
	protected static final String PANTALLA2 = "pantalla2";
	protected static final String PANTALLA3 = "pantalla3";
	
	Navigator navigator;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	
    	getPage().setTitle("FormacionEjemplo4");
    	
    	navigator = new Navigator(this, this);
    	
//    	Siempre debemos definir un caso por defecto
    	navigator.addView(PANTALLA0, new Pantalla0());
    	navigator.addView(PANTALLA1, new Pantalla1());
    	navigator.addView(PANTALLA2, new Pantalla2());
    	navigator.addView(PANTALLA3, new Pantalla3());
    }
    
    public class Pantalla0 extends VerticalLayout implements View{
    	
    	public Pantalla0() {
    		setSizeFull();
    		
    		Button button = new Button("Ir a pantalla 1");
    		
    		button.addClickListener(e -> {
    			navigator.navigateTo(PANTALLA1);
    		});
    		
    		addComponent(button);
    	}
    	
    	@Override
    	public void enter(ViewChangeEvent event) {
    		Notification.show("Estas en la pantalla Default");
    	}
    }
    
    public class Pantalla1 extends VerticalLayout implements View{
    	
    	public Pantalla1() {
    		setSizeFull();
    		
    		Button button = new Button("Ir a pantalla 2");
    		
    		button.addClickListener(e -> {
    			navigator.navigateTo(PANTALLA2);
    		});
    		
    		addComponent(button);
    	}
    	
    	@Override
    	public void enter(ViewChangeEvent event) {
    		Notification.show("Estas en la pantalla 1");
    	}
    }
    
    public class Pantalla2 extends VerticalLayout implements View{
    	
    	public Pantalla2() {
    		setSizeFull();
    		
    		Button button = new Button("Ir a pantalla 3");
    		
    		button.addClickListener(e -> {
    			navigator.navigateTo(PANTALLA3);
    		});
    		
    		addComponent(button);
    	}
    	
    	@Override
    	public void enter(ViewChangeEvent event) {
    		Notification.show("Estas en la pantalla 2");
    	}
    }
    
    public class Pantalla3 extends VerticalLayout implements View{
    	
    	public Pantalla3() {
    		setSizeFull();
    		
    		Button button = new Button("Ir a pantalla Default");
    		
    		button.addClickListener(e -> {
    			navigator.navigateTo("");
    		});
    		
    		addComponent(button);
    	}
    	
    	@Override
    	public void enter(ViewChangeEvent event) {
    		Notification.show("Estas en la pantalla 3");
    	}
    }
}











