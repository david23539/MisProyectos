package com.example.FormacionEjemplo1;

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
public class FormacionEjemplo1 extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        
        button.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + name.getValue() + ", it works!"));
        });
        
        layout.addComponents(name, button);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "FormacionEjemplo1Servlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = FormacionEjemplo1.class, productionMode = false)
    public static class FormacionEjemplo1Servlet extends VaadinServlet {
    }
}
