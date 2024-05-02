package restaurante;

public class Estatisticas {
	private int countFila = 0;
	private int countFilaAlmocando = 0;
	private int countFilaCaixa = 0;
	private int countFilaAtendida = 0;
	
	public int getCountFila() {
		return countFila;
	}
	public void setCountFila(int countFila) {
		this.countFila = countFila;
	}
	public int getCountFilaAlmocando() {
		return countFilaAlmocando;
	}
	public void setCountFilaAlmocando(int countFilaAlmocando) {
		this.countFilaAlmocando = countFilaAlmocando;
	}
	public int getCountFilaCaixa() {
		return countFilaCaixa;
	}
	public void setCountFilaCaixa(int countFilaCaixa) {
		this.countFilaCaixa = countFilaCaixa;
	}
	public int getCountFilaAtendida() {
		return countFilaAtendida;
	}
	public void setCountFilaAtendida(int countFilaAtendida) {
		this.countFilaAtendida = countFilaAtendida;
	}
	
	public void getFilaParaAlmocar() {
		System.out.println("Fila para almocar: " + getCountFila());
	}
	
	public void getFilaAlmocando() {
		System.out.println("Fila almocando: " + getCountFilaAlmocando());
	}
	
	public void getFilaCaixa() {
		System.out.println("Fila caixa: " + getCountFilaCaixa());
	}
	
	public void getAtendidos() {
		System.out.println("Número de atendidos: " + getCountFilaAtendida());
	}
}
