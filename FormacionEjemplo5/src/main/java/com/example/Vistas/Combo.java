package com.example.Vistas;

import com.vaadin.navigator.View;
import com.vaadin.server.UserError;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class Combo extends Composite implements View{ 

	public Combo () {
		
		VerticalLayout verticalLayout = new VerticalLayout();
		
		verticalLayout.setMargin(true);
		verticalLayout.setSizeFull();
		
		
		ComboBox<String> combo1 = new ComboBox<>("Pruebas1");
		ComboBox<String> combo2 = new ComboBox<>("Pruebas2");
		ComboBox<String> combo3 = new ComboBox<>("Pruebas3");
		ComboBox<String> combo4 = new ComboBox<>("Pruebas4");

//		Comobo 1
		combo1.setItems("Prueba 1", "Prueba 2", "Prueba 3", "Prueba 4");
		combo1.setStyleName("v-comboColorCustom");
		combo1.addValueChangeListener(event -> {
			
			if(event.getValue() == null){
				Notification.show("Se escogió la opcion en blanco");
			}
			else {
				Notification.show("Se escogió la " + event.getValue());
			}
			
		});
		
//		Comobo 2
		combo2.setItems("Prueba 5", "Prueba 6", "Prueba 7", "Prueba 8");
		combo2.setComponentError(new UserError("Petooooooooo!"));
		
//		Comobo 3
		combo3.setItems("Prueba 9", "Prueba 10", "Prueba 11", "Prueba 12");
		combo3.setEnabled(false);
		
		verticalLayout.addComponents(combo1, combo2, combo3);
		
//		Alineaciones
		verticalLayout.setComponentAlignment(combo2, Alignment.MIDDLE_CENTER);
		verticalLayout.setComponentAlignment(combo3, Alignment.BOTTOM_RIGHT);
		
		setCompositionRoot(verticalLayout);
	}
}
