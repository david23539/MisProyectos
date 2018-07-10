package com.example.Vistas;

import java.io.File;

import com.example.Services.SegurosService;
import com.vaadin.navigator.View;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Composite;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class Principal extends Composite implements View{

	private SegurosService segurosService = new SegurosService();
	
	public Principal() {
		HorizontalLayout menu = new HorizontalLayout();
		HorizontalLayout contenido = new HorizontalLayout();
		VerticalLayout pantalla = new VerticalLayout();
		
		MenuBar menuBar = new MenuBar();
		
//		comportamiento para los botones
		MenuBar.Command comandos = new MenuBar.Command() {
		    public void menuSelected(MenuItem selectedItem) {
		    	if(selectedItem.getDescription().equals("Incendio")) {
		    		contenido.removeAllComponents();
		    		contenido.addComponent(new FormularioIncendio(segurosService));
		    	}
		    	else if(selectedItem.getDescription().equals("Inundación")) {
		    		contenido.removeAllComponents();
		    		contenido.addComponent(new FormularioInundacion(segurosService));
		    	}
		    	else if(selectedItem.getDescription().equals("Huracán")) {
		    		contenido.removeAllComponents();
		    		Notification.show("Click sobre:"+selectedItem.getDescription());
		    	}
		    	else if(selectedItem.getDescription().equals("Volcán")) {
		    		contenido.removeAllComponents();
		    		Notification.show("Click sobre:"+selectedItem.getDescription());
		    	}
		    	else if(selectedItem.getDescription().equals("Resumen")) {
		    		contenido.removeAllComponents();
		    		contenido.addComponent(new Resumen(segurosService));
		    	}
		    	else if(selectedItem.getDescription().equals("Cerrar sesión")) {
		    		getUI().getNavigator().navigateTo("");
		    	}
		    	
		    }
		};
		
		menu.setWidth("100%");
		contenido.setSizeFull();
		
        String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
        
//      Fuego
        File file = new File(basepath + "/VAADIN/themes/mytheme/img/fire.png");
		FileResource resource = new FileResource(file);
		menuBar.addItem("", resource, comandos).setDescription("Incendio");
		
//		Agua
		file = new File(basepath + "/VAADIN/themes/mytheme/img/water.png");
		resource = new FileResource(file);
		menuBar.addItem("", resource, comandos).setDescription("Inundación");
		
//		Huracan
		file = new File(basepath + "/VAADIN/themes/mytheme/img/hurricane.png");
		resource = new FileResource(file);
		menuBar.addItem("", resource, comandos).setDescription("Huracán");
		
//		Volcanes
		file = new File(basepath + "/VAADIN/themes/mytheme/img/volcan.png");
		resource = new FileResource(file);
		menuBar.addItem("", resource, comandos).setDescription("Volcán");
		
//		Resumen
		file = new File(basepath + "/VAADIN/themes/mytheme/img/seguros.png");
		resource = new FileResource(file);
		menuBar.addItem("", resource, comandos).setDescription("Resumen");
		
//		Logout
		file = new File(basepath + "/VAADIN/themes/mytheme/img/logout.png");
		resource = new FileResource(file);
		menuBar.addItem("", resource, comandos).setDescription("Cerrar sesión");
		
		menuBar.setHeight(90, Unit.PIXELS);
		menuBar.setWidth("100%");
		
		menu.addComponent(menuBar);
		
//		Distribucion en pantalla de los componentes en pantalla.
		pantalla.addComponents(menu, contenido);
		pantalla.setExpandRatio(menu, 1);
		pantalla.setExpandRatio(contenido, 8);
		pantalla.setMargin(false);
		pantalla.setSizeFull();
		
		setCompositionRoot(pantalla);
	}
}
