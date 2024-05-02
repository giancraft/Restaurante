package pagamento;

import pedido.*;
import restaurante.*;

public class Pagamento extends Nodo<Pagamento>{
	private Pagamento inicio;
	private int id;
	private int idPedido;
	private double valorOfertado;
	private double TotalPagar;
	private double troco;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValorOfertado() {
		return valorOfertado;
	}
	public void setValorOfertado(double valorOfertado) {
		this.valorOfertado = valorOfertado;
	}
	public double getTotalPagar() {
		return TotalPagar;
	}
	public void setTotalPagar(double totalPagar) {
		TotalPagar = totalPagar;
	}
	public double getTroco() {
		return troco;
	}
	public void setTroco(double troco) {
		this.troco = troco;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	
	public void realizarPagamento (int id, ListaPedido lista, Estatisticas estatistica, double valor) {
		double totalPagar = lista.getTotalPagar(id);
		double troco = 0;
		
		if (valor < totalPagar)
			System.out.println("Valor oferecido pelo cliente é menor que o total a ser pagar. Falta R$" + (totalPagar - valor) + " para pagar");
		else {
			Pagamento novo = new Pagamento();
			novo.setProx(inicio);
			novo.setTotalPagar(totalPagar);
			novo.setTroco(troco);
			novo.setValorOfertado(valor);
			novo.setIdPedido(id);
			estatistica.setCountFilaCaixa(estatistica.getCountFilaCaixa()-1);
			estatistica.setCountFilaAtendida(estatistica.getCountFilaAtendida()+1);
			inicio = novo;
			int count = 0;
			Pagamento aux = inicio;
			while (aux != null) {
				count++;
				if (aux.getProx() == null) {
					novo.setId(count);
				}
				aux = aux.getProx();
			}
			
			System.out.println("\nComprovante: \n");
			System.out.println("O total: " + totalPagar);
			System.out.println("Valor oferecido: " + valor);
			
			if (valor > totalPagar) {
				troco = valor - totalPagar;
				novo.setTroco(troco);
			}
			
			System.out.println("Troco: " + troco);
		}
	}
	
	public void mostrarPagamentos() {
		Pagamento aux = inicio;
		
		while (aux != null) {
			System.out.println("\nPagamento número: " + aux.getId() + ", Pedido: " + aux.getIdPedido() + ", Total: " + aux.getTotalPagar() 
			+ ", Valor oferecido: " + aux.getValorOfertado() + ", Troco: " + aux.getTroco());
			aux = aux.getProx();
		}
	}
}
