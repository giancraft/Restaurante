package produtos;

public class ListaProdutos {
	private Produto inicioProduto;
	
	public ListaProdutos() {
		this.inicioProduto = null;
	}
	
	public void inserirProduto(String desc, double preco) {
		Produto novoPrato = new Produto(desc, preco);
		if (inicioProduto == null) {
			novoPrato.setProx(inicioProduto);
			novoPrato.setNumero(1);
			inicioProduto = novoPrato;
			return;
		}
		Produto aux = inicioProduto;
		int count = 1;
		
		while (aux != null) {
			count++;
			if (aux.getProx() == null)
				novoPrato.setNumero(count);
			aux = aux.getProx();
		}
		
		aux = inicioProduto;
		while (aux.getProx() != null) {
			aux = aux.getProx();
		}
		aux.setProx(novoPrato);
	}
	
	public void mostrarCardapio() {
		Produto aux = inicioProduto;
		System.out.println("As opções do cardápio são as seguintes:");
		while (aux != null) {
			System.out.println(aux.getNumero() + " - " + aux.getDescricao() + " R$" + aux.getPreco());
			aux = aux.getProx();
		}
	}
	
	public Produto mostrarProdutoPorNum(int numero) {
		Produto aux = inicioProduto;
		Produto prato = null;
		while (aux != null) {
			if (aux.getNumero() == numero) {
				prato = aux;
				return prato;
			}
			aux = aux.getProx();
		}
		return null;
	}
}
