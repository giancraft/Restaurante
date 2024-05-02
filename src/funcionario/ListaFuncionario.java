package funcionario;

public class ListaFuncionario {
	private Funcionario inicioFuncionario;
	
	public ListaFuncionario() {
		this.inicioFuncionario = null;
	}
	
	public Funcionario getInicio() {
		return inicioFuncionario;
	}
	
	public void cadastroFuncionario(String nome, String cargo) {
		Funcionario novo = new Funcionario(nome, cargo);
		if (inicioFuncionario == null) {
			novo.setId(1);
		}
		
		int count = 1;
		Funcionario aux = inicioFuncionario;
		while(aux != null) {
			count++;
			if (aux.getProx() == null) {
				novo.setId(count);
			}
			aux = aux.getProx();
		}
		novo.setProx(inicioFuncionario);
		inicioFuncionario = novo;
		
	}
	
	public void mostrarFuncionarios() {
		Funcionario aux = inicioFuncionario;
		while (aux != null) {
			System.out.println(aux.getId() + " - " + "Nome: " + aux.getNome() + ", Cargo: " + aux.getCargo());
			aux = aux.getProx();
		}
	}
	
	public Funcionario mostrarFuncionarioPorId(Integer id) {
		Funcionario auxFun = inicioFuncionario;
		Funcionario fun = null;
		
		while (auxFun != null) {
			if (auxFun.getId() == id) {
				fun = auxFun;
				return fun;
			}
			auxFun = auxFun.getProx();
		}
		
		return null;
	}
	
	public void removerFuncionario(Integer id) {
		if (inicioFuncionario.getId() == id) {
			inicioFuncionario = inicioFuncionario.getProx();
			return;
		}
		
		Funcionario aux = inicioFuncionario;
		while (aux != null) {
			if (aux.getProx().getId() == id) {
				aux.setProx(aux.getProx().getProx());
				return;
			}
			aux = aux.getProx();
		}
	}
	
}
