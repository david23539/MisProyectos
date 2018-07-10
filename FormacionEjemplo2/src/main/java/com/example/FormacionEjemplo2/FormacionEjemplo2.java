package com.example.FormacionEjemplo2;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
public class FormacionEjemplo2 extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	final VerticalLayout verticalLayout = new VerticalLayout();
    	final Button button = new Button("Ver/Ocultar"); 
    	final Label label = new Label("Hello World");
    	
    	button.addClickListener(e -> {
    		if(label.isVisible()) {
    			label.setVisible(false);
    		}
    		else {
    			label.setVisible(true);
    		}
    	});
    	
    	verticalLayout.addComponents(button, label);
    	
    	setContent(verticalLayout);
    	
    }

    @WebServlet(urlPatterns = "/*", name = "FormacionEjemplo2Servlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = FormacionEjemplo2.class, productionMode = false)
    public static class FormacionEjemplo2Servlet extends VaadinServlet {
    }
}
