package pedido;

import restaurante.Nodo;
import cliente.Cliente;
import mesa.Mesa;
import produtos.Produto;
import funcionario.Funcionario;

public class Pedido extends Nodo<Pedido>{
	private int id;
	private String status;
	private Cliente cliente;
	private Mesa mesa;
	private Produto prato;
	private Funcionario garcon;
	private double totalAPagar = 0;
	
	public Pedido() {
		this.id = 0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public Produto getPrato() {
		return prato;
	}
	public void setPrato(Produto prato) {
		this.prato = prato;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Funcionario getGarcon() {
		return garcon;
	}
	public void setGarcon(Funcionario garcon) {
		this.garcon = garcon;
	}
	public double getTotalAPagar() {
		return totalAPagar;
	}
	public void setTotalAPagar(double totalAPagar) {
		this.totalAPagar = totalAPagar;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", status=" + status + ", cliente=" + cliente + ", mesa=" + mesa + ", prato="
				+ prato + ", garcon=" + garcon + ", totalAPagar=" + totalAPagar + "]";
	}
}
