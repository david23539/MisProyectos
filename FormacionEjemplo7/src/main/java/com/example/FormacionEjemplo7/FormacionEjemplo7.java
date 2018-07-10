package com.example.FormacionEjemplo7;

import com.vaadin.addon.responsive.Responsive;
import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings ("serial")
@Theme("mytheme")
public class FormacionEjemplo7 extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	
    	new Responsive(this);
    	
    	final CssLayout layout = new CssLayout();
    	layout.setWidth("100%");
    	setContent(layout);
    	
    	CssLayout topBar  = new CssLayout();
    	Label title = new Label("Workshop");
    	title.addStyleName("h1");
    	topBar.addComponent(title);
    	
    	layout.addComponent(topBar);
    	
    	CssLayout menu = new CssLayout();
    	menu.addStyleName("menu");
    	layout.addComponent(menu);
    	
    	Button section = new Button("Start");
    	section.setIcon(VaadinIcons.VAADIN_H);
    	section.addStyleName("start");
    	menu.addComponent(section);
    	
    	section = new Button("Admin");
    	section.setIcon(VaadinIcons.PUZZLE_PIECE);
    	section.addStyleName("admin");
    	menu.addComponent(section);
    	
    	section = new Button("Settings");
    	section.setIcon(VaadinIcons.COG);
    	section.addStyleName("settings");
    	menu.addComponent(section);
    	
    	VerticalLayout content = new VerticalLayout();
    	content.addStyleName("content");
    	content.setSpacing(true);
    	content.setMargin(true);
    	layout.addComponent(content);
    	
    	
    	Label header = new Label("Lorem Ipsum");
    	header.addStyleName("h2");
    	content.addComponent(header);
    	
    	Label text = new Label("<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum in erat scelerisque lacus ultricies porta id ut orci. Morbi sollicitudin ex ipsum</p> <p>Aenean dignissim blandit velit non tincidunt. Nunc ultricies commodo velit eget dictum. Donec euismod, tellus ut hendrerit euismod, enim dui condimentum magna</p> <p>Sed a lobortis lacus, id porttitor massa. Suspendisse non urna nec risus lacinia suscipit nec ac purus. Sed auctor, odio et fringilla vehicula, tortor elit efficitur arcu</p>", 
    							ContentMode.HTML);
    	content.addComponent(text);
    	
    	VerticalLayout form = new VerticalLayout();
    	form.addStyleName("form");
    	new Responsive(form);
    	
    	form.setSpacing(false);
    	content.addComponent(form);
    	
    	TextField firstname = new TextField("First name");
    	form.addComponent(firstname);
    	
    	TextField lastname = new TextField("Last name");
    	form.addComponent(lastname);
    	
    	TextField email = new TextField("Email");
    	form.addComponent(email);
    	
    	Button submit = new Button("Submit");
    	form.addComponent(submit);
    	
    }
}

