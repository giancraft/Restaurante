package restaurante;

import cliente.ListaCliente;
import mesa.ListaMesa;
import produtos.ListaProdutos;
import pedido.ListaPedido;
import funcionario.ListaFuncionario;
import pagamento.*;

public class Main {

	public static void main(String[] args) {
		ListaCliente listaCliente = new ListaCliente();
		ListaMesa listaMesa = new ListaMesa();
		ListaProdutos listaProdutos = new ListaProdutos();
		ListaPedido listaPedido = new ListaPedido();
		ListaFuncionario listaFunc = new ListaFuncionario();
		Pagamento pagamento = new Pagamento();
		Estatisticas estatistica = new Estatisticas();
		
		listaCliente.inserirCliente("Daniel", estatistica);
		listaCliente.inserirCliente("Pedro Henrique", estatistica);
		listaCliente.inserirCliente("Igor", estatistica);
		listaCliente.inserirCliente("Gian", estatistica);
		
		listaCliente.mostrarClientes();
		
		listaCliente.atualizarCliente(1, "Pedro Ryan");
		System.out.println();
		listaCliente.mostrarClientes();
		System.out.println();
		
		listaMesa.inserirMesa(1);
		listaMesa.inserirMesa(2);
		listaMesa.inserirMesa(3);
		listaMesa.inserirMesa(4);
		
		listaMesa.mostrarMesas(estatistica);
		
		listaMesa.inserirClienteMesa(1, 1, listaCliente, estatistica);
		listaMesa.inserirClienteMesa(1, 2, listaCliente, estatistica);
		listaMesa.inserirClienteMesa(1, 3, listaCliente, estatistica);
		listaMesa.inserirClienteMesa(1, 4, listaCliente, estatistica);
		System.out.println();
		listaMesa.mostrarMesas(estatistica);
		
		/*listaMesa.liberacaoMesa(1);
		System.out.println();
		listaMesa.mostrarMesas();*/
		
		listaProdutos.inserirProduto("Macarronada", 24.99);
		listaProdutos.inserirProduto("Hamburguer", 14.99);
		listaProdutos.inserirProduto("Risoto", 20.99);
		System.out.println();
		listaProdutos.mostrarCardapio();
		
		listaFunc.cadastroFuncionario("Pedro Daniel", "Garçon");
		listaFunc.cadastroFuncionario("Matheus", "Cozinheiro");
		
		System.out.println();
		listaFunc.mostrarFuncionarios();
		
		listaPedido.registrarPedido(1, 1, 1, 1, listaCliente, listaMesa, listaProdutos, listaFunc);
		listaPedido.registrarPedido(1, 2, 2, 1, listaCliente, listaMesa, listaProdutos, listaFunc);
		listaPedido.registrarPedido(1, 3, 1, 1, listaCliente, listaMesa, listaProdutos, listaFunc);
		System.out.println();
		listaPedido.mostrarPedidos();
		System.out.println("Total a pagar: " + listaPedido.getTotalPagar(1));
		
		listaPedido.alterarPedido(3, 3, listaProdutos);
		System.out.println();
		listaPedido.mostrarPedidos();
		System.out.println("Total a pagar: " + listaPedido.getTotalPagar(1));
		
		listaPedido.cancelaPedido(3);
		System.out.println();
		listaPedido.mostrarPedidos();
		System.out.println("Total a pagar: " + listaPedido.getTotalPagar(1));
		
		System.out.println();
		listaPedido.preparoPedido(1, 2, listaFunc);
		
		pagamento.realizarPagamento(1, listaPedido, estatistica, 100);
		pagamento.mostrarPagamentos();
	}

}
