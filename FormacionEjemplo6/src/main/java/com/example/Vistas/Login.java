package com.example.Vistas;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
public class Login extends Composite implements View{

	private TextField user = new TextField("Usuario:");
	private PasswordField pass = new PasswordField("Password");
	private Button send = new Button("Entrar");
	
	public Login () {
		VerticalLayout caja = new VerticalLayout(); 
		
		user.setIcon(VaadinIcons.USER);
        pass.setIcon(VaadinIcons.PASSWORD);
        
        send.addStyleName(ValoTheme.BUTTON_PRIMARY);
        send.addClickListener(event -> this.clickEnviar());
        
        caja.addComponents(user, pass, send);
        
        caja.setComponentAlignment(user, Alignment.MIDDLE_CENTER);
        caja.setComponentAlignment(pass, Alignment.MIDDLE_CENTER);
        caja.setComponentAlignment(send, Alignment.MIDDLE_CENTER);
        
        setCompositionRoot(caja);
	}
	
	private void clickEnviar() {
    	if((user.getValue() == null || user.getValue().equals("")) ||
    			(pass.getValue() == null || pass.getValue().equals(""))){
    		Notification.show("Error de credencial, revise.", Notification.Type.ERROR_MESSAGE);
    	}
    	else {
    		if(!user.getValue().equalsIgnoreCase("admin") ||
    				!pass.getValue().equals("admin")) {
    			Notification.show("Acceso denegado.", Notification.Type.WARNING_MESSAGE);
    		}
    		else {
    			getUI().getNavigator().navigateTo("principal");
    		}
    	}
    }
}
