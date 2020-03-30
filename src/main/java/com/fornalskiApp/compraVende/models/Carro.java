package com.fornalskiApp.compraVende.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Carro")
public class Carro implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long id;
	private String marca;
	private String modelo;
	private String cor;
	private String ano;	
	private String titulo;
	@Column(columnDefinition = "text")
	private String descricao;
	private String fixo;
	private String celular;
	private String kilometragem;
	private Double preco;
	
	
	@Lob
	@Type(type = "org.hibernate.type.ImageType")
	private byte[] image1;
	
	@Lob
	@Type(type = "org.hibernate.type.ImageType")
	private byte[] image2;
	
	@Lob
	@Type(type = "org.hibernate.type.ImageType")
	private byte[] image3;
	
	@Lob
	@Type(type = "org.hibernate.type.ImageType")
	private byte[] image4;
	
	@Lob
	@Type(type = "org.hibernate.type.ImageType")
	private byte[] image5;
	
	
	
	public Carro() {}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public String getCor() {
		return cor;
	}



	public void setCor(String cor) {
		this.cor = cor;
	}



	public String getAno() {
		return ano;
	}



	public void setAno(String ano) {
		this.ano = ano;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getFixo() {
		return fixo;
	}



	public void setFixo(String fixo) {
		this.fixo = fixo;
	}



	public String getCelular() {
		return celular;
	}



	public void setCelular(String celular) {
		this.celular = celular;
	}



	public String getKilometragem() {
		return kilometragem;
	}



	public void setKilometragem(String kilometragem) {
		this.kilometragem = kilometragem;
	}



	public Double getPreco() {
		return preco;
	}



	public void setPreco(Double preco) {
		this.preco = preco;
	}



	public byte[] getImage1() {
		return image1;
	}



	public void setImage1(byte[] image1) {
		this.image1 = image1;
	}



	public byte[] getImage2() {
		return image2;
	}



	public void setImage2(byte[] image2) {
		this.image2 = image2;
	}



	public byte[] getImage3() {
		return image3;
	}



	public void setImage3(byte[] image3) {
		this.image3 = image3;
	}



	public byte[] getImage4() {
		return image4;
	}



	public void setImage4(byte[] image4) {
		this.image4 = image4;
	}



	public byte[] getImage5() {
		return image5;
	}



	public void setImage5(byte[] image5) {
		this.image5 = image5;
	}
	
	

	
}
