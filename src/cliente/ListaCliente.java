package cliente;

import restaurante.Estatisticas;

public class ListaCliente {
	private Cliente inicioCliente;
	
	public ListaCliente() {
		this.inicioCliente = null;
	}
	
	public Cliente getInicio() {
		return inicioCliente;
	}
	
	public void setInicio(Cliente inicio) {
		this.inicioCliente = inicio;
	}

	public void inserirCliente(String nome, Estatisticas estatistica) {
		Cliente novo = new Cliente(nome);
		novo.setProx(inicioCliente);
		inicioCliente = novo;
		
		int count = 0;
		Cliente aux = inicioCliente;
		while (aux != null) {
			count++;
			if (aux.getProx() == null) {
				novo.setId(count);
			}
			aux = aux.getProx();
		}
		estatistica.setCountFila(estatistica.getCountFila()+1);
	}
	
	public void mostrarClientes() {
		Cliente aux = inicioCliente;
		while (aux != null) {
			System.out.println(aux.getId() + " - " + aux.getNome());
			aux = aux.getProx();
		}
	}
	
	public Cliente mostrarClientePorId(Integer id) {
		Cliente auxCli = inicioCliente;
		Cliente cli = null;
		while (auxCli != null) {
			if (auxCli.getId() == id) {
				cli = auxCli;
				return cli;
			}
			auxCli = auxCli.getProx();
		}
		return null;
	}
	
	public void atualizarCliente(Integer id, String novoNome) {
		if (inicioCliente.getId() == id) {
			inicioCliente.setNome(novoNome);
			return;
		}
		Cliente aux = inicioCliente;
		while (aux != null) {
			if (aux.getId() == id) {
				aux.setNome(novoNome);
				return;
			}
			aux = aux.getProx();
		}
	}
	
	public void deletarCliente(Integer id) {
		if (inicioCliente.getId() == id) {
			inicioCliente = inicioCliente.getProx();
			return;
		}
		Cliente aux = inicioCliente;
		while (aux != null) {
			if (aux.getProx().getId() == id) {
				aux.setProx(aux.getProx().getProx());
				return;
			}
			aux = aux.getProx();
		}
	}
}
