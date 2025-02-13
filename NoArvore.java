package projeto;

public class NoArvore {
	int rgm;
	String nome;
	NoArvore direita;
	NoArvore esquerda;
	
	public NoArvore(int rgm, String nome) {
		this.rgm= rgm;
		this.nome= nome;
		direita = esquerda = null;
	}
}