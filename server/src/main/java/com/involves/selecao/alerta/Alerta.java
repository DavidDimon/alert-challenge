package com.involves.selecao.alerta;

import java.time.LocalDate;
import java.util.Objects;

public class Alerta {

	private String pontoDeVenda;
	private String descricao;
	private String produto;
	private Integer flTipo;
	private Integer margem;
	private LocalDate dataResposta;

	public String getPontoDeVenda() {
		return pontoDeVenda;
	}
	public void setPontoDeVenda(String pontoDeVenda) {
		this.pontoDeVenda = pontoDeVenda;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public Integer getFlTipo() {
		return flTipo;
	}
	public void setFlTipo(Integer flTipo) {
		this.flTipo = flTipo;
	}
	public Integer getMargem(){
		return margem;
	}
	public void setMargem(Integer margem){
		this.margem = margem;
	}
    public LocalDate getDataResposta() { return dataResposta; }
    public void setDataResposta(LocalDate dataResposta) { this.dataResposta = dataResposta; }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Alerta alerta = (Alerta) o;
		return Objects.equals(pontoDeVenda, alerta.pontoDeVenda) &&
				Objects.equals(descricao, alerta.descricao) &&
				Objects.equals(produto, alerta.produto) &&
				Objects.equals(flTipo, alerta.flTipo) &&
				Objects.equals(margem, alerta.margem) &&
				Objects.equals(dataResposta, alerta.dataResposta);
	}
}
