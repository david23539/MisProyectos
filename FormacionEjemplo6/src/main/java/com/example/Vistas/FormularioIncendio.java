package com.example.Vistas;

import com.example.DTOs.SegurosDTO;
import com.example.Enums.Religion;
import com.example.Services.SegurosService;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBoxGroup;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

public class FormularioIncendio extends FormLayout implements View{

	private SegurosDTO segurosDTO;
	private SegurosService segurosService = new SegurosService();
	
//	Componentes del Form
	private TextField tipo = new TextField("Tipo seguro:");
	private TextField titular = new TextField("Titular:");
	private DateField hasta =  new DateField("Válido hasta:");
	private NativeSelect<Religion> religion = new NativeSelect<>("Religión");
	private RadioButtonGroup<String> enfermo = new RadioButtonGroup<>("¿Le gustan las cerillas?:");
	private CheckBoxGroup<String> actividades = new CheckBoxGroup<>("Prefernecias deportivas:");
	private Button salvar = new Button("Salvar");
	private Button limpiar = new Button("Borrar");
	
	public FormularioIncendio(SegurosService segurosService) {
		this.segurosService = segurosService;
		
		HorizontalLayout botonera = new HorizontalLayout(salvar, limpiar);
		addComponents(tipo, titular, hasta, religion, enfermo, actividades, botonera);
		
//----------- Configuracion de Valores -----------
		
//		Setteo de tipo
		tipo.setEnabled(false);
		tipo.setValue("Incendio");
		
//		Carga del "Combo" de religion 
		religion.setItems(Religion.values());
		
//---------- Propio del tipo -------------
//		Carga de RadioButton
		enfermo.setItems("Si", "No");
		
//		Carga de multiselección
		actividades.setItems("Cazar gamusinos", "Puenting", "Leer Biblia", "Sexar pollos");
//----------------------------------------
		
		salvar.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		limpiar.setStyleName(ValoTheme.BUTTON_DANGER);
		
//		binder.bindInstanceFields(this);
		
		limpiar.addClickListener(e -> this.limpiarClick());
		salvar.addClickListener(e -> this.salvarClick());
		
		setMargin(true);
	}
	
	private void limpiarClick() {
		titular.clear();
		hasta.clear();
		religion.clear();
		enfermo.clear();
		actividades.clear();
	}
	
	private void salvarClick() {
		
//----------------- SIN BINDER-----------------
		segurosDTO = new SegurosDTO();
		
		segurosDTO.setTipo(tipo.getValue());
		segurosDTO.setTitular(titular.getValue());
		segurosDTO.setCaducidad(hasta.getValue());
		segurosDTO.setCreencia(religion.getValue());
		
		if(enfermo.getValue().equalsIgnoreCase("SI")) {
			segurosDTO.setCerillas(true);
		}
		else {
			segurosDTO.setCerillas(false);
		}
		
		String listActividades = String.valueOf(actividades.getValue());
		listActividades = listActividades.replace("[", "");
		listActividades = listActividades.replace("]", "");
		
		segurosDTO.setPreferencias(listActividades);
//-------------------------------------------
		
		segurosService.save(segurosDTO);
		Notification.show("Salvado");
		this.limpiarClick();
	}
}
