package restaurante;

import java.util.Scanner;
import cliente.*;
import mesa.*;
import pedido.*;
import produtos.*;
import funcionario.*;
import pagamento.Pagamento;

public class Restaurante {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		ListaCliente listaCliente = new ListaCliente();
		ListaMesa listaMesa = new ListaMesa();
		ListaProdutos listaProdutos = new ListaProdutos();
		ListaPedido listaPedido = new ListaPedido();
		ListaFuncionario listaFunc = new ListaFuncionario();
		Pagamento pag = new Pagamento();
		Estatisticas estatistica = new Estatisticas();
		Limpador limpa = new Limpador();
		
		listaProdutos.inserirProduto("Macarronada", 24.99);
		listaProdutos.inserirProduto("Risoto", 20.99);
		listaProdutos.inserirProduto("Porção de Batata-Frita", 16.99);
		listaMesa.inserirMesa(1);
		listaMesa.inserirMesa(2);
		listaMesa.inserirMesa(3);
		listaMesa.inserirMesa(4);
		Integer resp = null;
		Integer resp2 = null;
		Integer resp3 = null;
		Integer resp4 = null;
		Integer resp5 = null;
		String respString;
		String respString2;
		double respDouble;
		
		do {
			System.out.println("Bem-vindo! Qual aba você gostaria de utilizar?");
			System.out.println("Digite 0 para ir a Clientes");
			System.out.println("Digite 1 para ir a Mesas");
			System.out.println("Digite 2 para ir a Produtos");
			System.out.println("Digite 3 para ir a Funcionarios");
			System.out.println("Digite 4 para ir a Pedidos");
			System.out.println("Digite 5 para ir a Estatisticas");
			System.out.println("Digite qualquer outro número para sair do programa");
			resp = entrada.nextInt();
			
			switch(resp) {
				case 0:
					limpa.limpaConsole();
					do {
						System.out.println("Bem-vindo a aba Clientes! O que você gostaria de fazer?");
						System.out.println("Digite 0 para retornar ao começo");
						System.out.println("Digite 1 para cadastrar um novo Cliente");
						System.out.println("Digite 2 para alterar um Cliente");
						System.out.println("Digite 3 para excluir um Cliente");
						System.out.println("Digite 4 para consultar os Clientes cadastrados");
						resp = entrada.nextInt();
						while (resp < 0 || resp > 4) {
							limpa.limpaConsole();
							System.out.println("Resposta inválida");
							System.out.println("Digite 0 para retornar ao começo");
							System.out.println("Digite 1 para cadastrar um novo Cliente");
							System.out.println("Digite 2 para alterar um Cliente");
							System.out.println("Digite 3 para excluir um Cliente");
							System.out.println("Digite 4 para consultar os Clientes cadastrados");
							resp = entrada.nextInt();
						}
						switch (resp) {
							case 1:
								limpa.limpaConsole();
								entrada.nextLine();
								System.out.print("Digite o nome do cliente a ser cadastrado: ");
								respString = entrada.nextLine();
								listaCliente.inserirCliente(respString, estatistica);
								System.out.println("Cliente cadastrado com sucesso");
								break;
							case 2:
								limpa.limpaConsole();
								if (listaCliente.getInicio() == null) {
									System.out.println("Nenhum cliente cadastrado.");
								} else {
									System.out.println("Qual cliente você gostaria de alterar?");
									listaCliente.mostrarClientes();
									resp2 = entrada.nextInt();
									while (listaCliente.mostrarClientePorId(resp2) == null) {
										limpa.limpaConsole();
										System.out.println("Opção escolhida não é um dos clientes cadastrados. Escolha outra opção");
										listaCliente.mostrarClientes();
										resp2 = entrada.nextInt();
									}
									limpa.limpaConsole();
									entrada.nextLine();
									System.out.print("Digite o novo nome deste cliente: ");
									respString = entrada.nextLine();
									listaCliente.atualizarCliente(resp2, respString);
									System.out.println("Cliente atualizado com sucesso.");
									limpa.limpaConsole();
								}
								break;
							case 3:
								limpa.limpaConsole();
								if (listaCliente.getInicio() == null) {
									System.out.println("Nenhum cliente cadastrado.");
								} else {
									System.out.println("Qual cliente você deseja excluir?");
									listaCliente.mostrarClientes();
									resp2 = entrada.nextInt();
									while (listaCliente.mostrarClientePorId(resp2) == null) {
										limpa.limpaConsole();
										System.out.println("Opção escolhida não é um dos clientes cadastrados. Escolha outra opção");
										listaCliente.mostrarClientes();
										resp2 = entrada.nextInt();
									}
									listaCliente.deletarCliente(resp2);
									System.out.println("Cliente excluído com sucesso");
									System.out.println("Deseja retornar a aba Clientes?");
									System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
									resp = entrada.nextInt();
									while (resp < 0 || resp > 1) {
										limpa.limpaConsole();
										System.out.println("Resposta inválida.");
										System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
										resp = entrada.nextInt();
									}
									limpa.limpaConsole();
								}
								break;
							case 4:
								limpa.limpaConsole();
								if (listaCliente.getInicio() == null) {
									 System.out.println("Nenhum cliente cadastrado");
								} else {
									System.out.println("Os clientes cadastrados são:");
									listaCliente.mostrarClientes();
									System.out.println("Deseja retornar a aba Clientes?");
									System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
									resp = entrada.nextInt();
									while (resp < 0 || resp > 1) {
										limpa.limpaConsole();
										System.out.println("Resposta inválida.");
										System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
										resp = entrada.nextInt();
									}
								}
								break;
						}
					} while (resp > 0 && resp < 5);
					break;
				case 1:
					limpa.limpaConsole();
					do {
						System.out.println("Bem-vindo a aba de Mesas! O que você gostaria de fazer?");
						System.out.println("Digite 0 para retornar ao começo");
						System.out.println("Digite 1 para alocar um Cliente uma Mesa");
						System.out.println("Digite 2 para liberar uma Mesa");
						System.out.println("Digite 3 para consultar as Mesas");
						resp = entrada.nextInt();
						while (resp < 0 || resp > 4) {
							limpa.limpaConsole();
							System.out.println("Opção inválida");
							System.out.println("Digite 0 para retornar ao começo");
							System.out.println("Digite 1 para alocar um Cliente uma Mesa");
							System.out.println("Digite 2 para liberar uma Mesa");
							System.out.println("Digite 3 para consultar as Mesas");
							resp = entrada.nextInt();
						}
						switch (resp) {
							case 1:
								if (listaCliente.getInicio() == null) {
									limpa.limpaConsole();
									System.out.println("Nenhum cliente cadastrado.");
								} else {
									limpa.limpaConsole();
									System.out.println("Qual cliente você deseja alocar?");
									listaCliente.mostrarClientes();
									resp2 = entrada.nextInt();
									while (listaCliente.mostrarClientePorId(resp2) == null) {
										limpa.limpaConsole();
										System.out.println("Opção escolhida não é um dos clientes cadastrados. Escolha outra opção");
										listaCliente.mostrarClientes();
										resp2 = entrada.nextInt();
									}
									limpa.limpaConsole();
									System.out.println("Para qual mesa você deseja alocá-lo?");
									listaMesa.mostrarMesas(estatistica);
									resp3 = entrada.nextInt();
									while (listaMesa.mostrarMesaPorNum(resp3) == null) {
										limpa.limpaConsole();
										System.out.println("Opção escolhida não é uma das mesas cadastradas. Escolha outra opção");
										listaMesa.mostrarMesas(estatistica);
										resp3 = entrada.nextInt();
									}
									limpa.limpaConsole();
									listaMesa.inserirClienteMesa(resp3, resp2, listaCliente, estatistica);
									System.out.println("Cliente alocado com sucesso.");
									System.out.println("Deseja retornar a aba Mesas?");
									System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
									resp = entrada.nextInt();
									while (resp < 0 || resp > 1) {
										limpa.limpaConsole();
										System.out.println("Resposta inválida.");
										System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
										resp = entrada.nextInt();
									}
								}
								break;
							case 2:
								if (listaCliente.getInicio() == null) {
									limpa.limpaConsole();
									System.out.println("Nenhum cliente cadastrado.");
								} else {
									limpa.limpaConsole();
									System.out.println("Qual mesa você deseja liberar?");
									listaMesa.mostrarMesas(estatistica);
									resp3 = entrada.nextInt();
									while (listaMesa.mostrarMesaPorNum(resp3) == null) {
										limpa.limpaConsole();
										System.out.println("Opção escolhida não é uma das mesas cadastradas. Escolha outra opção");
										listaMesa.mostrarMesas(estatistica);
										resp3 = entrada.nextInt();
									}
									while (listaMesa.mostrarMesaPorNum(resp3).getCliente() == null) {
										limpa.limpaConsole();
										System.out.println("A mesa já está vazia. Escolha outra mesa.");
										listaMesa.mostrarMesas(estatistica);
										resp3 = entrada.nextInt();
									}
									listaMesa.liberacaoMesa(resp3, estatistica, listaPedido);
									System.out.println("Mesa liberada com sucesso");
									System.out.println("Deseja retornar a aba Mesas?");
									System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
									resp = entrada.nextInt();
									while (resp < 0 || resp > 1) {
										limpa.limpaConsole();
										System.out.println("Resposta inválida.");
										System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
										resp = entrada.nextInt();
									}
								}
								break;
							case 3:
								limpa.limpaConsole();
								System.out.println("As mesas disponíveis são:");
								listaMesa.mostrarMesas(estatistica);
								System.out.println("Deseja retornar a aba Mesas?");
								System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
								resp = entrada.nextInt();
								while (resp < 0 || resp > 1) {
									limpa.limpaConsole();
									System.out.println("Resposta inválida.");
									System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
									resp = entrada.nextInt();
								}
								break;
						}
					} while (resp > 0 && resp < 4);
					break;
				case 2:
					do{
						limpa.limpaConsole();
						System.out.println("Bem-vindo a aba de produtos! O que você gostaria de fazer?");
						System.out.println("Digite 0 para voltar ao começo");
						System.out.println("Digite 1 para cadastrar um novo produto");
						System.out.println("Digite 2 para verificar os produtos disponíveis");
						resp = entrada.nextInt();
						while (resp < 0 || resp > 2) {
							limpa.limpaConsole();
							System.out.println("Opção inválida.");
							System.out.println("Digite 0 para voltar ao começo");
							System.out.println("Digite 1 para cadastrar um novo produto");
							System.out.println("Digite 2 para verificar os produtos disponíveis");
							resp = entrada.nextInt();
						}
						switch (resp) {
							case 1:
								limpa.limpaConsole();
								entrada.nextLine();
								System.out.print("Insira a descrição do produto a ser cadastrado: ");
								respString = entrada.nextLine();
								System.out.println("Insira o preço do produto a ser cadastrado: ");
								respDouble = entrada.nextDouble();
								listaProdutos.inserirProduto(respString, respDouble);
								System.out.println("Produto cadastrado com sucesso");
								break;
							case 2:
								limpa.limpaConsole();
								System.out.println("Os produtos cadastrados são:");
								listaProdutos.mostrarCardapio();
								System.out.println("Deseja retornar a aba Produtos?");
								System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
								resp = entrada.nextInt();
								while (resp < 0 || resp > 1) {
									limpa.limpaConsole();
									System.out.println("Resposta inválida.");
									System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
									resp = entrada.nextInt();
								}
								break;
						}
					} while (resp > 0 && resp < 3);
					break;
				case 3:
					limpa.limpaConsole();
					do {
						System.out.println("Bem-vindo a aba funcionários! O que você deseja fazer?");
						System.out.println("Digite 0 para retornar ao começo");
						System.out.println("Digite 1 para cadastrar um Funcionário");
						System.out.println("Digite 2 para remover um Funcionário");
						System.out.println("Digite 3 para consultar Funcionários");
						resp = entrada.nextInt();
						while (resp < 0 || resp > 4) {
							System.out.println("Opção inválida. Escolha outra opção");
							System.out.println("Digite 0 para retornar ao começo");
							System.out.println("Digite 1 para cadastrar um Funcionário");
							System.out.println("Digite 2 para remover um Funcionário");
							System.out.println("Digite 3 para consultar Funcionários");
							resp = entrada.nextInt();
						}
						switch (resp) {
							case 1:
								limpa.limpaConsole();
								entrada.nextLine();
								System.out.print("Qual o nome do funcionário: ");
								respString = entrada.nextLine();
								entrada.nextLine();
								System.out.print("Qual o cargo do funcionário: ");
								respString2 = entrada.nextLine();
								listaFunc.cadastroFuncionario(respString, respString2);
								System.out.println("Cadastro realizado com sucesso");
								break;
							case 2: 
								if (listaFunc.getInicio() == null) {
									limpa.limpaConsole();
									System.out.println("Nenhum funcionário cadastrado");
								} else {
									limpa.limpaConsole();
									System.out.println("Selecione o funcionário que deseja excluir");
									listaFunc.mostrarFuncionarios();
									resp2 = entrada.nextInt();
									while (listaFunc.mostrarFuncionarioPorId(resp2) == null) {
										limpa.limpaConsole();
										System.out.println("Opção inválida. Escolha outra opção:");
										listaFunc.mostrarFuncionarios();
										resp2 = entrada.nextInt();
									}
									listaFunc.removerFuncionario(resp2);
									System.out.println("Funcionário excluído com sucesso");
									System.out.println("Deseja retornar a aba Funcionário?");
									System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
									resp = entrada.nextInt();
									while (resp < 0 || resp > 1) {
										limpa.limpaConsole();
										System.out.println("Resposta inválida.");
										System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
										resp = entrada.nextInt();
									}
									limpa.limpaConsole();
								}
								break;
							case 3: 
								if (listaFunc.getInicio() == null) {
									limpa.limpaConsole();
									System.out.println("Nenhum funcionário cadastrado");
								} else {
									System.out.println("Os funcionários cadastrados são:");
									listaFunc.mostrarFuncionarios();
									System.out.println("Deseja retornar a aba Funcionário?");
									System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
									resp = entrada.nextInt();
									while (resp < 0 || resp > 1) {
										limpa.limpaConsole();
										System.out.println("Resposta inválida.");
										System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
										resp = entrada.nextInt();
									}
									limpa.limpaConsole();
								}
								break;	
						}
					} while (resp > 0 && resp < 4);
					break;
				case 4:
					limpa.limpaConsole();
					do {
						System.out.println("Bem-vindo a aba Pedidos! O que você gostaria de fazer?");
						System.out.println("Digite 0 para retornar ao começo");
						System.out.println("Digite 1 para cadastrar um Pedido");
						System.out.println("Digite 2 para alterar um Pedido");
						System.out.println("Digite 3 para cancelar um Pedido");
						System.out.println("Digite 4 para preparar um Pedido");
						System.out.println("Digite 5 para entregar um Pedido");
						System.out.println("Digite 6 para consultar os Pedidos");
						System.out.println("Digite 7 para pagar um Pedido");
						System.out.println("Digite 8 para consultar os Pagamentos realizados");
						resp = entrada.nextInt();
						while (resp < 0 || resp > 8) {
							System.out.println("Opção inválida. Escolha uma opção válida");
							System.out.println("Digite 0 para retornar ao começo");
							System.out.println("Digite 1 para cadastrar um Pedido");
							System.out.println("Digite 2 para alterar um Pedido");
							System.out.println("Digite 3 para cancelar um Pedido");
							System.out.println("Digite 4 para preparar um Pedido");
							System.out.println("Digite 5 para entregar um Pedido");
							System.out.println("Digite 6 para consultar os Pedidos");
							System.out.println("Digite 7 para pagar um Pedido");
							System.out.println("Digite 8 para consultar os Pagamentos realizados");
							resp = entrada.nextInt();
						}
						switch (resp) {
							case 1:
								if (listaCliente.getInicio() == null || listaFunc.getInicio() == null) {
									limpa.limpaConsole();
									System.out.println("Cliente e/ou funcionário não cadastrado");
								} else {
									limpa.limpaConsole();
									System.out.println("De qual mesa é o pedido?");
									listaMesa.mostrarMesas(estatistica);
									resp3 = entrada.nextInt();
									while (listaMesa.mostrarMesaPorNum(resp3) == null) {
										limpa.limpaConsole();
										System.out.println("Opção escolhida não é uma das mesas cadastradas. Escolha outra opção");
										listaMesa.mostrarMesas(estatistica);
										resp3 = entrada.nextInt();
									}
									while (listaMesa.mostrarMesaPorNum(resp3).getCliente() == null) {
										limpa.limpaConsole();
										System.out.println("A mesa não possui um cliente alocado a ela. Escolha outra opção");
										listaMesa.mostrarMesas(estatistica);
										resp3 = entrada.nextInt();
									}
									limpa.limpaConsole();
									System.out.println("Qual cliente está realizando o pedido?");
									listaCliente.mostrarClientes();
									resp2 = entrada.nextInt();
									while (listaCliente.mostrarClientePorId(resp2) == null) {
										limpa.limpaConsole();
										System.out.println("Opção escolhida não é um dos clientes cadastrados. Escolha outra opção");
										listaCliente.mostrarClientes();
										resp2 = entrada.nextInt();
									}
									limpa.limpaConsole();
									System.out.println("Qual o prato desejado?");
									listaProdutos.mostrarCardapio();
									resp4 = entrada.nextInt();
									while (listaProdutos.mostrarProdutoPorNum(resp4) == null) {
										limpa.limpaConsole();
										System.out.println("Opção inválida. Escolha outra opção");
										listaProdutos.mostrarCardapio();
										resp4 = entrada.nextInt();
									}
									limpa.limpaConsole();
									System.out.println("Qual o garçom que atenderá a mesa?");
									listaFunc.mostrarFuncionarios();
									resp5 = entrada.nextInt();
									while (listaFunc.mostrarFuncionarioPorId(resp5) == null) {
										limpa.limpaConsole();
										System.out.println("Opção inválida. Escolha outra opção:");
										listaFunc.mostrarFuncionarios();
										resp5 = entrada.nextInt();
									}
									limpa.limpaConsole();
									listaPedido.registrarPedido(resp3, resp2, resp4, resp5, listaCliente, listaMesa, listaProdutos, listaFunc);
									System.out.println("Pedido cadastrado com sucesso");
									System.out.println("Deseja retornar a aba Pedidos?");
									System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
									resp = entrada.nextInt();
									while (resp < 0 || resp > 1) {
										limpa.limpaConsole();
										System.out.println("Resposta inválida.");
										System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
										resp = entrada.nextInt();
									}
									limpa.limpaConsole();
								}
								break;
							case 2:
								if (listaPedido.getInicio() == null) {
									limpa.limpaConsole();
									System.out.println("Nenhum pedido cadastrado");
								} else {
									limpa.limpaConsole();
									System.out.println("Qual pedido você deseja alterar?");
									listaPedido.mostrarPedidos();
									resp2 = entrada.nextInt();
									limpa.limpaConsole();
									System.out.println("Qual o novo prato desejado?");
									listaProdutos.mostrarCardapio();
									resp3 = entrada.nextInt();
									while (listaProdutos.mostrarProdutoPorNum(resp3) == null) {
										System.out.println("Opção inválida. Escolha uma opção válida:");
										listaProdutos.mostrarCardapio();
										resp3 = entrada.nextInt();
									}
									listaPedido.alterarPedido(resp2, resp3, listaProdutos);
									System.out.println("Pedido alterado com sucesso");
									System.out.println("Deseja retornar a aba Pedidos?");
									System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
									resp = entrada.nextInt();
									while (resp < 0 || resp > 1) {
										limpa.limpaConsole();
										System.out.println("Resposta inválida.");
										System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
										resp = entrada.nextInt();
									}
									limpa.limpaConsole();
								}
								break;
							case 3:
								if (listaPedido.getInicio() == null) {
									limpa.limpaConsole();
									System.out.println("Nenhum pedido cadastrado");
								} else {
									limpa.limpaConsole();
									System.out.println("Qual pedido você deseja excluir?");
									listaPedido.mostrarPedidos();
									resp2 = entrada.nextInt();
									listaPedido.cancelaPedido(resp2);
									limpa.limpaConsole();
									System.out.println("Pedido excluído com sucesso");
									System.out.println("Deseja retornar a aba Pedidos?");
									System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
									resp = entrada.nextInt();
									while (resp < 0 || resp > 1) {
										limpa.limpaConsole();
										System.out.println("Resposta inválida.");
										System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
										resp = entrada.nextInt();
									}
									limpa.limpaConsole();
								}
								break;
							case 4: 
								if (listaPedido.getInicio() == null) {
									limpa.limpaConsole();
									System.out.println("Nenhum pedido cadastrado");
								} else {
									limpa.limpaConsole();
									System.out.println("Qual pedido será preparado?");
									listaPedido.mostrarPedidos();
									resp2 = entrada.nextInt();
									limpa.limpaConsole();
									System.out.println("Qual cozinheiro preparará o pedido?");
									listaFunc.mostrarFuncionarios();
									resp5 = entrada.nextInt();
									while (listaFunc.mostrarFuncionarioPorId(resp5) == null) {
										limpa.limpaConsole();
										System.out.println("Opção inválida. Escolha outra opção:");
										listaFunc.mostrarFuncionarios();
										resp5 = entrada.nextInt();
									}
									limpa.limpaConsole();
									listaPedido.preparoPedido(resp2, resp5, listaFunc);
									System.out.println("Pedido preparado com sucesso");
									System.out.println("Deseja retornar a aba Pedidos?");
									System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
									resp = entrada.nextInt();
									while (resp < 0 || resp > 1) {
										limpa.limpaConsole();
										System.out.println("Resposta inválida.");
										System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
										resp = entrada.nextInt();
									}
									limpa.limpaConsole();
								}
								break;
							case 5:
								if (listaPedido.getInicio() == null) {
									limpa.limpaConsole();
									System.out.println("Nenhum pedido cadastrado");
								} else {
									System.out.println("Qual pedido será entregue?");
									listaPedido.mostrarPedidos();
									resp2 = entrada.nextInt();
									limpa.limpaConsole();
									listaPedido.entregarPedido(resp2, estatistica);
									System.out.println("Pedido entregue com sucesso");
									System.out.println("Deseja retornar a aba Pedidos?");
									System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
									resp = entrada.nextInt();
									while (resp < 0 || resp > 1) {
										limpa.limpaConsole();
										System.out.println("Resposta inválida.");
										System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
										resp = entrada.nextInt();
									}
									limpa.limpaConsole();
								}
								break;
							case 6:
								if (listaPedido.getInicio() == null) {
									limpa.limpaConsole();
									System.out.println("Nenhum pedido cadastrado");
								} else {
									System.out.println("Os pedidos cadastrados são:");
									listaPedido.mostrarPedidos();
									System.out.println("Deseja retornar a aba Pedidos?");
									System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
									resp = entrada.nextInt();
									while (resp < 0 || resp > 1) {
										limpa.limpaConsole();
										System.out.println("Resposta inválida.");
										System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
										resp = entrada.nextInt();
									}
									limpa.limpaConsole();
								}
								break;
							case 7:
								if (listaPedido.getInicio() == null) {
									limpa.limpaConsole();
									System.out.println("Nenhum pedido cadastrado");
								} else {
									limpa.limpaConsole();
									System.out.println("Qual pedido será pago?");
									listaPedido.mostrarPedidos();
									resp2 = entrada.nextInt();
									limpa.limpaConsole();
									listaPedido.getTotalPagar(resp2);
									System.out.println("Qual o valor oferecido para o pagamento");
									respDouble = entrada.nextDouble();
									pag.realizarPagamento(resp2, listaPedido, estatistica, respDouble);
									listaPedido.cancelaPedido(resp2);
									limpa.limpaConsole();
									System.out.println("Pagamento realizado com sucesso");
									System.out.println("Deseja retornar a aba Pedidos?");
									System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
									resp = entrada.nextInt();
									while (resp < 0 || resp > 1) {
										limpa.limpaConsole();
										System.out.println("Resposta inválida.");
										System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
										resp = entrada.nextInt();
									}
									limpa.limpaConsole();
								}
								break;
							case 8:
								limpa.limpaConsole();
								System.out.println("Os pagamentos realizados são:");
								pag.mostrarPagamentos();
								System.out.println("Deseja retornar a aba Pedidos?");
								System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
								resp = entrada.nextInt();
								while (resp < 0 || resp > 1) {
									limpa.limpaConsole();
									System.out.println("Resposta inválida.");
									System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
									resp = entrada.nextInt();
								}
								limpa.limpaConsole();
								break;
						}
					} while (resp > 0 && resp < 9);
					break;
				case 5:
					do {
						limpa.limpaConsole();
						System.out.println("Bem-vindo a aba de Estatísticas. O que você deseja fazer?");
						System.out.println("Digite 0 para retornar ao começo");
						System.out.println("Digite 1 para ver o número de pessoas na fila para almoçar");
						System.out.println("Digite 2 para ver o número de pessoas almoçando");
						System.out.println("Digite 3 para ver o número de pessoas na fila do caixa");
						System.out.println("Digite 4 para ver o número de pessoas atendidas");
						resp = entrada.nextInt();
						while (resp < 0 || resp > 4) {
							limpa.limpaConsole();
							System.out.println("Opção inválida. Escolha uma opção válida: ");
							System.out.println("Digite 0 para retornar ao começo");
							System.out.println("Digite 1 para ver o número de pessoas na fila para almoçar");
							System.out.println("Digite 2 para ver o número de pessoas almoçando");
							System.out.println("Digite 3 para ver o número de pessoas na fila do caixa");
							System.out.println("Digite 4 para ver o número de pessoas atendidas");
							resp = entrada.nextInt();
						}
						switch (resp) {
							case 1:
								limpa.limpaConsole();
								System.out.println("A quantidade de pessoas na fila para almoçar é:");
								estatistica.getFilaParaAlmocar();
								System.out.println("Deseja retornar a aba Estatistica?");
								System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
								resp = entrada.nextInt();
								while (resp < 0 || resp > 1) {
									limpa.limpaConsole();
									System.out.println("Resposta inválida.");
									System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
									resp = entrada.nextInt();
								}
								limpa.limpaConsole();
								break;
							case 2:
								limpa.limpaConsole();
								System.out.println("A quantidade de pessoas almoçando é:");
								estatistica.getFilaAlmocando();
								System.out.println("Deseja retornar a aba Estatistica?");
								System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
								resp = entrada.nextInt();
								while (resp < 0 || resp > 1) {
									limpa.limpaConsole();
									System.out.println("Resposta inválida.");
									System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
									resp = entrada.nextInt();
								}
								limpa.limpaConsole();
								break;
							case 3:
								limpa.limpaConsole();
								System.out.println("A quantidade de pessoas na fila do caixa é:");
								estatistica.getFilaCaixa();
								System.out.println("Deseja retornar a aba Estatistica?");
								System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
								resp = entrada.nextInt();
								while (resp < 0 || resp > 1) {
									limpa.limpaConsole();
									System.out.println("Resposta inválida.");
									System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
									resp = entrada.nextInt();
								}
								limpa.limpaConsole();
								break;
							case 4:
								limpa.limpaConsole();
								System.out.println("A quantidade de pessoas atendidas é: ");
								estatistica.getAtendidos();
								System.out.println("Deseja retornar a aba Estatistica?");
								System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
								resp = entrada.nextInt();
								while (resp < 0 || resp > 1) {
									limpa.limpaConsole();
									System.out.println("Resposta inválida.");
									System.out.println("Digite 1 para retornar e 0 para retornar ao começo");
									resp = entrada.nextInt();
								}
								limpa.limpaConsole();
								break;
						}
					} while (resp > 0 && resp < 5);
			}
			limpa.limpaConsole();
		} while (resp == 0);
	}
}
