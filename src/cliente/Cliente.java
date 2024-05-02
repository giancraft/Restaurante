package cliente;

import restaurante.Nodo;

public class Cliente extends Nodo<Cliente>{
	private String nome;
	private Integer id;
	private boolean estaNumaMesa;
	
	public Cliente (String nome) {
		setId(0);
		setNome(nome);
		setEstaNumaMesa(false);
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
	public boolean isEstaNumaMesa() {
		return estaNumaMesa;
	}
	public void setEstaNumaMesa(boolean estaNumaMesa) {
		this.estaNumaMesa = estaNumaMesa;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", id=" + id + ", estaNumaMesa=" + estaNumaMesa + "]";
	}
}
