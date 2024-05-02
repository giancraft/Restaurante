package restaurante;

public class Nodo<T> {
	private T prox;
	
	public Nodo() {
		this.prox = null;
	}

	public T getProx() {
		return prox;
	}
	public void setProx(T prox) {
		this.prox = prox;
	}
}
