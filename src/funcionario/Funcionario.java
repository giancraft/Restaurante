package funcionario;

import restaurante.Nodo;

public class Funcionario  extends Nodo<Funcionario>{
	private String nome;
	private Integer id;
	private String cargo;
	
	public Funcionario(String nome, String cargo) {
		this.nome = nome;
		this.cargo = cargo;
		this.id = 0;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}	
}
