package br.edu.insper;

public class Notas {
	private Integer idNota;
	private Integer idPessoa;
	private Integer idCategoria;
	private String conteudo;
	private String cor;
	
	public Integer getIdNota() {
		return idNota;
	}
	public void setIdNota(Integer idNota) {
		this.idNota = idNota;
	}
	public Integer getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
}
