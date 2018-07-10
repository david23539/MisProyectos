package com.example.DTOs;

import java.io.Serializable;
import java.time.LocalDate;

import com.example.Enums.Religion;
import com.vaadin.shared.ui.colorpicker.Color;

public class SegurosDTO implements Serializable, Cloneable{

	private Long idSeguro;
	private String tipo;
	private String titular;
	private LocalDate caducidad;
	private Religion creencia;
//	Especifico Fuego
	private Boolean cerillas;
	private String preferencias;
//	Especifico de Agua
	private Integer gusto;
	private String bio;
	private Color color;
	
//--------- Getter's and Setter's ---------
	public Long getIdSeguro() {
		return idSeguro;
	}
	
	public void setIdSeguro(Long idSeguro) {
		this.idSeguro = idSeguro;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public LocalDate getCaducidad() {
		return caducidad;
	}
	
	public void setCaducidad(LocalDate caducidad) {
		this.caducidad = caducidad;
	}
	
	public Religion getCreencia() {
		return creencia;
	}
	
	public void setCreencia(Religion creencia) {
		this.creencia = creencia;
	}
	
	public Boolean getCerillas() {
		return cerillas;
	}
	
	public void setCerillas(Boolean cerillas) {
		this.cerillas = cerillas;
	}
	
	public String getPreferencias() {
		return preferencias;
	}
	
	public void setPreferencias(String preferencias) {
		this.preferencias = preferencias;
	}
	
	public Integer getGusto() {
		return gusto;
	}
	
	public void setGusto(Integer gusto) {
		this.gusto = gusto;
	}
	
	public String getBio() {
		return bio;
	}
	
	public void setBio(String bio) {
		this.bio = bio;
	}

	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bio == null) ? 0 : bio.hashCode());
		result = prime * result + ((caducidad == null) ? 0 : caducidad.hashCode());
		result = prime * result + ((cerillas == null) ? 0 : cerillas.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((creencia == null) ? 0 : creencia.hashCode());
		result = prime * result + ((gusto == null) ? 0 : gusto.hashCode());
		result = prime * result + ((idSeguro == null) ? 0 : idSeguro.hashCode());
		result = prime * result + ((preferencias == null) ? 0 : preferencias.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((titular == null) ? 0 : titular.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SegurosDTO other = (SegurosDTO) obj;
		if (bio == null) {
			if (other.bio != null)
				return false;
		} else if (!bio.equals(other.bio))
			return false;
		if (caducidad == null) {
			if (other.caducidad != null)
				return false;
		} else if (!caducidad.equals(other.caducidad))
			return false;
		if (cerillas == null) {
			if (other.cerillas != null)
				return false;
		} else if (!cerillas.equals(other.cerillas))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (creencia != other.creencia)
			return false;
		if (gusto == null) {
			if (other.gusto != null)
				return false;
		} else if (!gusto.equals(other.gusto))
			return false;
		if (idSeguro == null) {
			if (other.idSeguro != null)
				return false;
		} else if (!idSeguro.equals(other.idSeguro))
			return false;
		if (preferencias == null) {
			if (other.preferencias != null)
				return false;
		} else if (!preferencias.equals(other.preferencias))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (titular == null) {
			if (other.titular != null)
				return false;
		} else if (!titular.equals(other.titular))
			return false;
		return true;
	}

	
	
}
