package mesa;

import cliente.*;
import pedido.*;
import restaurante.Estatisticas;

public class ListaMesa {
	private Mesa inicioMesa;
	
	public ListaMesa() {
		this.inicioMesa = null;
	}
	
	public void inserirMesa(int numero) {
		Mesa nova = new Mesa().numeroMesa(numero);
		nova.setProx(inicioMesa);
		inicioMesa = nova;
	}
	
	public Mesa inserirClienteMesa(int numero, Integer id, ListaCliente lista, Estatisticas estatistica) {
		Cliente cli = lista.mostrarClientePorId(id);
		Mesa aux = inicioMesa;
		while (aux != null) {
			if (aux.getCapacidade() < 4 && aux.getNumero() == numero) {
				cli.setProx(aux.getCliente());
				aux.setCliente(cli);
				aux.getCliente().setEstaNumaMesa(true);
				estatistica.setCountFila(estatistica.getCountFila()+1);
				aux.setCapacidade(aux.getCapacidade()+1);
				return aux;
			} else if (aux.getNumero() == numero)
				System.out.println("Não é possível alocar um cliente a esta mesa. Capacidade máxima atingida");
			aux = aux.getProx();
		}
		return aux;
	}
	
	public void mostrarMesas(Estatisticas estatistica) {
		Mesa aux = inicioMesa;
		ListaCliente lista = new ListaCliente();
		Cliente cliente = null;
		
		while (aux != null) {
			if (aux.getCapacidade() > 0) {
				cliente = aux.getCliente();
			}
			aux = aux.getProx();
		}
		
		while (cliente != null) {
			lista.inserirCliente(cliente.getNome(), estatistica);
			cliente = cliente.getProx();
		}
		
		aux = inicioMesa;
		
		System.out.println("Mesas Ocupadas:");
		while (aux != null) {
			if (aux.getCapacidade() > 0){
				System.out.println("Mesa: " + aux.getNumero());
				System.out.println("Clientes:");
				lista.mostrarClientes();
				System.out.println();
			}
			aux = aux.getProx();
		}
		aux = inicioMesa;
		System.out.println("\nMesas Vazias: ");
		while (aux != null) {
			if (aux.getCapacidade() == 0)
				System.out.println(aux.getNumero());
			aux = aux.getProx();
		}
	}
	
	public Mesa mostrarMesaPorNum(int numero) {
		Mesa auxMesa = inicioMesa;
		Mesa mesa = null;
		while (auxMesa != null) {
			if (auxMesa.getNumero() == numero) {
				mesa = auxMesa;
				return mesa;
			}
			auxMesa = auxMesa.getProx();
		}
		return null;
	}
	
	public void liberacaoMesa(int numero, Estatisticas estatistica, ListaPedido listaPedido) {
		if (inicioMesa.getNumero() == numero) {
			inicioMesa.getCliente().setEstaNumaMesa(false);
			estatistica.setCountFila(estatistica.getCountFila()-1);
			inicioMesa.setCliente(null);
			inicioMesa.setCapacidade(0);
			
			Pedido ped = listaPedido.getInicio();
			while (ped != null) {
				if (ped.getMesa().getNumero() == numero) {
					estatistica.setCountFilaCaixa(estatistica.getCountFilaCaixa()+1);
					estatistica.setCountFilaAlmocando(estatistica.getCountFilaAlmocando()-1);
				}
				ped = ped.getProx();
			}
			return;
		}
		
		Mesa aux = inicioMesa;
		while (aux != null) {
			if (aux.getNumero() == numero)
				aux.getCliente().setEstaNumaMesa(false);
				estatistica.setCountFila(estatistica.getCountFila()-1);
				estatistica.setCountFilaCaixa(estatistica.getCountFilaCaixa()+1);
				aux.setCliente(null);
				aux.setCapacidade(0);
				Pedido ped = listaPedido.getInicio();
				while (ped != null) {
					if (ped.getMesa().getNumero() == numero) {
						estatistica.setCountFilaCaixa(estatistica.getCountFilaCaixa()+1);
						estatistica.setCountFilaAlmocando(estatistica.getCountFilaAlmocando()-1);
					}
				}
			aux = aux.getProx();
		}
	}
}
