package com.example.gastos;

import java.util.Date;

public class Gasto {
	private String cantidad;
	private String descripcion;
	private String categoria;
	private String dia;
	private String mes;
	private String ano;
	private String hora;
	private String minuto;
	private String segundo;
	private boolean selected ;
	
	public Gasto(){}
	
	public Gasto(String cantidad, String descripcion, String categoria, String dia, String mes, String ano, String hora, String minuto, String segundo){
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
		this.selected = false;
	}
	
	public String getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getMinuto() {
		return minuto;
	}

	public void setMinuto(String minuto) {
		this.minuto = minuto;
	}

	public String getSegundo() {
		return segundo;
	}

	public void setSegundo(String segundo) {
		this.segundo = segundo;
	}
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public String getHoraYMinuto(){
		return dia + "/" +(mes) + "/" + ano + "  " + hora + ":" + minuto;
	}
	public String toString(){
		return cantidad + "/" + descripcion + "/" + categoria + "/" + dia + "/" + mes + "/"+ ano + "/"+ hora + "/"+ minuto + "/"+ segundo;
	}
}
