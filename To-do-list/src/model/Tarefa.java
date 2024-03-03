package model;

public class Tarefa {

	private String nome;
	private String descricao;
	private boolean feito;
	
	public Tarefa() {}
	
	public Tarefa(String nome, String descricao, boolean feito) {
		this.nome = nome;
		this.descricao = descricao;
		this.feito = feito;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public boolean getFeito() {
		return feito;
	}
	
	public void setFeito(boolean feito) {
		this.feito = feito;
	}
	
	public void editarNome(String nome) {
		this.nome = nome;
	}
	
	public void editarDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void editarTarefa(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return this.nome + "; Descrição: " + this.descricao + "; " + this.feito;
	}
	
}
