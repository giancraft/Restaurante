package pedido;

import cliente.*;
import mesa.*;
import produtos.*;
import funcionario.*;
import restaurante.Estatisticas;

public class ListaPedido {
	private Pedido inicioPedido;
	
	public ListaPedido() {
		this.inicioPedido = null;
	}
	
	public Pedido getInicio() {
		return inicioPedido;
	}
	
	public void registrarPedido(int numeroMesa, Integer idCliente, int numeroPrato, Integer idFuncionario, ListaCliente listaCli, ListaMesa listaMesa, ListaProdutos listaProduto, ListaFuncionario lista) {
		Pedido novoPedido = new Pedido();
		
		Cliente cli = listaCli.mostrarClientePorId(idCliente);
		Mesa mesa = listaMesa.mostrarMesaPorNum(numeroMesa);
		Produto prato = listaProduto.mostrarProdutoPorNum(numeroPrato);
		Funcionario garcon = lista.mostrarFuncionarioPorId(idFuncionario);
		
		if (inicioPedido == null) {
			novoPedido.setProx(inicioPedido);
			novoPedido.setCliente(cli);
			novoPedido.setMesa(mesa);
			novoPedido.setPrato(prato);
			novoPedido.setStatus("Pendente");
			novoPedido.setGarcon(garcon);
			novoPedido.setId(1);
			novoPedido.setTotalAPagar(novoPedido.getPrato().getPreco());
			inicioPedido = novoPedido;
			return;
		}
		Pedido aux = inicioPedido;
		while (aux.getProx() != null) {
			aux = aux.getProx();
		}
		aux.setProx(novoPedido);
		novoPedido.setCliente(cli);
		novoPedido.setMesa(mesa);
		novoPedido.setPrato(prato);
		novoPedido.setGarcon(garcon);
		novoPedido.setStatus("Pendente");
			
		int count = 0;
		aux = inicioPedido;
		while (aux != null) {
			count++;
			if (aux.getProx() == null) {
				novoPedido.setId(count);
			}
			aux = aux.getProx();
		}
		totalAPagar(novoPedido.getId());
	}
	
	public void alterarPedido(int id, int numeroPrato, ListaProdutos listaProduto) {
		Pedido aux = inicioPedido;
		Produto prato = listaProduto.mostrarProdutoPorNum(numeroPrato);
		
		while (aux != null) {
			if (aux.getId() == id) {
				aux.setPrato(prato);
				return;
			}
			aux = aux.getProx();
		}
	}
	
	public void preparoPedido(int id, Integer idFuncionario, ListaFuncionario lista) {
		Pedido aux = inicioPedido;
		Funcionario fun = lista.mostrarFuncionarioPorId(idFuncionario);
		Funcionario cozinheiro = null;
		
		while (fun != null) {
			if (fun.getCargo().equalsIgnoreCase("cozinheiro")) {
				cozinheiro = fun;
				break;
			} else
				System.out.println("O funcionário " + fun.getNome() + " não é um cozinheiro");
			fun = fun.getProx();
		}
		
		if (cozinheiro != null){
			while (aux != null) {
				if (aux.getId() == id) {
					System.out.println("O pedido: " + aux.getId() + " está sendo preparado pelo cozinheiro: " 
					+ cozinheiro.getId() + " - " + cozinheiro.getNome());
					aux.setStatus("Em preparo");
				}
				aux = aux.getProx();
			}
		}
	}
	
	public void cancelaPedido(int id) {
		if (inicioPedido.getId() == id) {
			inicioPedido = inicioPedido.getProx();
			return;
		}
		
		Pedido aux = inicioPedido;
		while (aux.getProx() != null) {
			if (aux.getProx().getId() == id) {
				aux.setProx(aux.getProx().getProx());
				return;
			}
			aux = aux.getProx();
		}
	}
	
	public void entregarPedido(int id, Estatisticas estatistica) {
		Pedido aux = inicioPedido;
		
		while (aux != null) {
			if (aux.getId() == id) {
				if (aux.getStatus().equalsIgnoreCase("Em preparo")) {
					aux.setStatus("Entregue");
					estatistica.setCountFilaAlmocando(estatistica.getCountFilaAlmocando()+1);
				} else
					System.out.println("O pedido não foi preparado por nenhum cozinheiro ainda");
			}
			aux = aux.getProx();
		}
	}
	
	public double totalAPagar(int id) {
		Pedido aux = inicioPedido;
		Produto produto = null;
		
		while (aux != null) {
			if (aux.getId() == id) {
				produto = aux.getPrato();
				break;
			}
			aux = aux.getProx();
		}
		
		aux = inicioPedido;
		while (produto != null) {
			while (aux != null) {
				if (aux.getId() == id) {
					aux.setTotalAPagar(aux.getTotalAPagar() + produto.getPreco());
					break;
				}
				aux = aux.getProx();
			}
			produto = produto.getProx();
		}
		
		aux = inicioPedido;
		while (aux != null) {
			if (aux.getId() == id) {
				return aux.getTotalAPagar();
			}
			aux = aux.getProx();
		}
		return 0;
	}
	
	public double getTotalPagar(int id) {
		Pedido aux = inicioPedido;
		double totalPagar = 0;
		Pedido ped = null; 
		
		while (aux != null) {
			if (aux.getId() == id) {
				ped = aux;
			}
			aux = aux.getProx();
		}
		
		while (ped != null) {
			if (ped.getProx() == null) {
				totalPagar = ped.getTotalAPagar();
			}
			ped = ped.getProx();
		}
		return totalPagar;
	}
	
	public void mostrarPedidos() {
		Pedido aux = inicioPedido;
		while (aux != null) {
			System.out.println("Pedido) número: " + aux.getId() + ", Cliente: " + aux.getCliente().getId() + " - " + aux.getCliente().getNome() + 
					", Mesa: " + aux.getMesa().getNumero() + ", Prato: " + aux.getPrato().getNumero() + " - " +aux.getPrato().getDescricao() + 
					", Status: " + aux.getStatus() + ", Anotado pelo garçon: " + aux.getGarcon().getNome() + ", Valor a Pagar: " + aux.getPrato().getPreco());
			aux = aux.getProx();
		}
	}
}
