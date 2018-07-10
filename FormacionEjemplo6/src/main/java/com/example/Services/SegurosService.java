package com.example.Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import com.example.DTOs.SegurosDTO;

public class SegurosService {

	private static SegurosService instance;
	private final HashMap<Long, SegurosDTO> seguros = new HashMap<>();
	private long nextId = 0;
	
//	Constructor por defecto
	public SegurosService() {
	}
	
	public static SegurosService getInstance() {
		if (instance == null) 
			instance = new SegurosService();
		
		return instance;
	}
	
//	synchronized se usa para que solamente un subproceso puede acceder a dicho método a la vez
//	Busqueda sin filtro
	public synchronized List<SegurosDTO> findAll() {
		return findAll(null);
	}
	
//	Busqueda con filtro
	public synchronized List<SegurosDTO> findAll(String filtro) {
		ArrayList<SegurosDTO> listadoSeguros = new ArrayList<>();
		
		for (SegurosDTO seguro : seguros.values()) {
			String patron = ".*" + filtro.toLowerCase() + ".*";
			
			if (seguro.getTitular().toLowerCase().matches(patron)) {
				listadoSeguros.add(seguro);
			}
		}
		
		Collections.sort(listadoSeguros, new Comparator<SegurosDTO>() {

			@Override
			public int compare(SegurosDTO o1, SegurosDTO o2) {
				return (int) (o2.getIdSeguro() - o1.getIdSeguro());
			}
		});
		
		return listadoSeguros;
	}

//	Contador de registros
	public synchronized long count() {
		return seguros.size();
	}
	
//	Borrado de registro
	public synchronized void delete(SegurosDTO value) {
		seguros.remove(value.getIdSeguro());
	}

//	Alta Registro
	public synchronized void save(SegurosDTO registro) {
		if(registro != null) {
			if (registro.getIdSeguro() == null) {
				registro.setIdSeguro(nextId++);
			}
			seguros.put(registro.getIdSeguro(), registro);
		}
	}
}
