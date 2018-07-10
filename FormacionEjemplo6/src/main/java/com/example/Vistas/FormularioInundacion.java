package com.example.Vistas;

import com.example.DTOs.SegurosDTO;
import com.example.Enums.Religion;
import com.example.Services.SegurosService;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.ColorPicker;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Slider;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

public class FormularioInundacion extends FormLayout implements View{
	
	private SegurosDTO segurosDTO;
	private SegurosService segurosService = new SegurosService();

	private TextField tipo = new TextField("Tipo seguro:");
	private TextField titular = new TextField("Titular:");
	private DateField hasta =  new DateField("Válido hasta:");
	private NativeSelect<Religion> religion = new NativeSelect<>("Religión");
	
	private Slider gusto = new Slider("De 0 a 5 ¿Cuanto te gusta nadar?:");
	private TextArea bio = new TextArea("Cuentanos algo sobre ti:");
	private Label text = new Label("¿Que color te representa:?");
	private ColorPicker color = new ColorPicker("Que color te representa:");
	
	private Button salvar = new Button("Salvar");
	private Button limpiar = new Button("Borrar");
	
	public FormularioInundacion(SegurosService segurosService) {
		this.segurosService = segurosService;
		
		HorizontalLayout botonera = new HorizontalLayout(salvar, limpiar);
		HorizontalLayout colores = new HorizontalLayout(text, color);
		
		addComponents(tipo, titular, hasta, religion, gusto, bio, colores, botonera);
		
//		Setteo de tipo
		tipo.setEnabled(false);
		tipo.setValue("Inundación");
		
//		Carga del "Combo" de religion 
		religion.setItems(Religion.values());
		
//---------- Propio del tipo -------------
		gusto.setValue(0.0);
		gusto.setWidth("200px");
		gusto.setMax(5.0);
		gusto.setMin(0.0);
//----------------------------------------
		
		salvar.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		limpiar.setStyleName(ValoTheme.BUTTON_DANGER);
		
		limpiar.addClickListener(e -> this.limpiarClick());
		salvar.addClickListener(e -> this.salvarClick());
		
		setMargin(true);
	}
	
	private void limpiarClick() {
		titular.clear();
		hasta.clear();
		religion.clear();
		bio.clear();
		gusto.clear();
		color.clear();
	}
	
	private void salvarClick() {
		
//----------------- SIN BINDER-----------------
		segurosDTO = new SegurosDTO();
		
		segurosDTO.setTipo(tipo.getValue());
		segurosDTO.setTitular(titular.getValue());
		segurosDTO.setCaducidad(hasta.getValue());
		segurosDTO.setCreencia(religion.getValue());
		
		segurosDTO.setGusto(gusto.getValue().intValue());
		segurosDTO.setBio(bio.getValue());
		
		segurosDTO.setColor(color.getValue());
//-------------------------------------------
		
		segurosService.save(segurosDTO);
		Notification.show("Salvado");
		this.limpiarClick();
	}
}
