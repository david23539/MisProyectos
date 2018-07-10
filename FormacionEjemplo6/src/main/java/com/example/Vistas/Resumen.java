package com.example.Vistas;

import java.util.List;

import com.example.DTOs.SegurosDTO;
import com.example.Services.SegurosService;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.ColorPicker;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class Resumen extends VerticalLayout implements View{

	private Grid<SegurosDTO> tabla = new Grid<>(SegurosDTO.class);
	private TextField filtro = new TextField();
	private SegurosService segurosService = new SegurosService();
//	private FormularioIncendio formularioIncendio = new FormularioIncendio(segurosService);

	public Resumen (SegurosService segurosService) {
		this.segurosService = segurosService;
		
		filtro.setPlaceholder("Nombre filtro");
		filtro.addValueChangeListener(e -> this.actualizarPolizas());
		filtro.setValueChangeMode(ValueChangeMode.LAZY);
		
		Button limpiar = new Button(VaadinIcons.ERASER);
        limpiar.setDescription("Borrar filtro");
        limpiar.addClickListener(e -> filtro.clear());
        
        CssLayout filtrocompuesto = new CssLayout();
        filtrocompuesto.addComponents(filtro, limpiar);
        filtrocompuesto.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        
        tabla.setSizeFull();
        
        addComponents(filtrocompuesto, tabla);
        
        tabla.setColumns("idSeguro", "titular", "caducidad", "tipo", "creencia", "cerillas", "preferencias", "gusto", "bio");
        
//------------ Intentos --------------------
        
        tabla.addComponentColumn(segurosDTO -> {
        	ColorPicker colorPicker = new ColorPicker();
        	
        	colorPicker.setValue(segurosDTO.getColor());
        	colorPicker.setEnabled(false);
        	
        	return colorPicker;
        }).setCaption("Color");
        
//------------------------------------------        
        
        setMargin(true);
        
        this.actualizarPolizas();
        
	}
	
	
	public void actualizarPolizas(){
		List<SegurosDTO> listadoSeguros = segurosService.findAll(filtro.getValue());
//		List<SegurosDTO> listadoSeguros = new ArrayList<>();
		tabla.setItems(listadoSeguros);
	}
}
