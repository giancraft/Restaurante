package produtos;

import restaurante.Nodo;

public class Produto extends Nodo<Produto> {
	private int numero;
	private String descricao;
	private double preco;
	
	public Produto(String desc, double preco) {
		this.numero = 0;
		this.descricao = desc;
		this.preco = preco;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [numero=" + numero + ", descricao=" + descricao + ", preco=" + preco + "]";
	}
}
