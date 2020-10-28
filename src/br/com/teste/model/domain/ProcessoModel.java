package br.com.teste.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProcessoModel {
	
	@Id
	@GeneratedValue
	@Column(name = "id_processo", nullable = false)
	private String id; 
	
	@Column(name = "num_pub", nullable = false)
	private String NumPub;
	
	@Column(name = "id_pedido", nullable = false)
	private String NumPedido;
	
	@Column(name = "dt_publicacao", nullable = false)
	private String DataPublicacao;
	
	@Column(name = "requerentes", nullable = false)
	private String Requerentes;
	
	@Column(name = "titulo", nullable = false)
	private String Titulo;
	
	public ProcessoModel() {
		super();
	}
	
	public ProcessoModel(String numPub, String numPedido, String dataPublicacao, String requerentes, String titulo) {
		this.NumPub = numPub;
		this.NumPedido = numPedido;
		this.DataPublicacao = dataPublicacao;
		this.Requerentes = requerentes;
		this.Titulo = titulo;
	}

	public String getNumPub() {
		return NumPub;
	}
	public void setNumPub(String numPub) {
		NumPub = numPub;
	}
	public String getNumPedido() {
		return NumPedido;
	}
	public void setNumPedido(String numPedido) {
		NumPedido = numPedido;
	}
	public String getDataPublicacao() {
		return DataPublicacao;
	}
	public void setDataPublicacao(String dataPublicacao) {
		DataPublicacao = dataPublicacao;
	}
	public String getRequerentes() {
		return Requerentes;
	}
	public void setRequerentes(String requerentes) {
		Requerentes = requerentes;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
}
