package mesa;

import cliente.Cliente;
import restaurante.Nodo;

public class Mesa extends Nodo<Mesa>{
	private int numero;
	private Cliente cliente;
	private int capacidade;
	
	public Mesa numeroMesa(int numero) {
		this.numero = numero;
		this.capacidade = 0;
		return this;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Mesa [numero=" + numero + ", cliente=" + cliente + ", capacidade=" + capacidade + "]";
	}
}
