package projeto;

public class ArvoreBinariaBusca {
    NoArvore no;

    //insere nó na árvore
    public void inserir(int rgm, String nome) {
        no = insere(no, rgm, nome);
    }

    public NoArvore insere(NoArvore no, int rgm, String nome) {
        if (no == null) {
            no = new NoArvore(rgm, nome);
            no.rgm = rgm;
            no.nome = nome;
            no.esquerda = no.esquerda = null;
        }
        else if (rgm < no.rgm) {
            no.esquerda = insere(no.esquerda, rgm, nome);
        } else if (rgm > no.rgm) {
            no.direita = insere(no.direita, rgm, nome);
        }

        return no;
    }

    // remove nó da árvore
    public NoArvore remove(int rgm) {
        return remover(no, rgm);
    }

    public NoArvore remover(NoArvore no, int rgm) {
        if (no == null){
        	return no;
        } 

        else if (no.rgm > rgm) {
            no.esquerda = remover(no.esquerda, rgm);
        } else if (no.rgm < rgm) {
            no.direita = remover(no.direita, rgm);
        } else {
            // Nó sem filhos
            if (no.esquerda == null && no.direita == null) {
            	no = null;
            }
            //no com 1 filho na direita
            else if (no.esquerda == null) {
            	NoArvore temp = no;
                no = no.direita;
            }
            //no com 1 filho na esquerda
            else if(no.direita == null) {
            	NoArvore temp = no;
            	no = no.esquerda;
            }
            //no com 2 filhos
            else {
            	NoArvore subesquerda = no.esquerda;
            	while (subesquerda.direita != null) {
            		subesquerda = subesquerda.direita;
            	}
            	no.rgm = subesquerda.rgm;
            	subesquerda.rgm = rgm;
            	no.esquerda = remover (no.esquerda, rgm);
            }
        }
        return no;
    }

    // pesquisa nó na árvore
    public boolean buscar(int rgm) {
        return busca(no, rgm) != null;
    }
    
    public NoArvore busca(NoArvore no, int rgm) {
    	if(no ==null) {
    		return null;
    	}
    	
    	if(no.rgm > rgm) {
    		return busca(no.esquerda, rgm);
    	}
    	else if(no.rgm < rgm) {
    		return busca(no.direita, rgm);
    	}
    	else {
    		return no;
    	}
    }

    // exibe a árvore em pré-ordem
    public void preOrdem() {
        iPreOrdem(no);
    }

    public void iPreOrdem(NoArvore no) {
        if (no != null) {
            System.out.println(no.rgm + " " + no.nome);
            iPreOrdem(no.esquerda);
            iPreOrdem(no.direita);
        }
    }

    // exibe a árvore em ordem
    public void inOrdem() {
        iInOrdem(no);
    }

    public void iInOrdem(NoArvore no) {
        if (no != null) {
            iInOrdem(no.esquerda);
            System.out.println(no.rgm + " " + no.nome);
            iInOrdem(no.direita);
        }
    }

    // exibe a árvore em pós-ordem
    public void posOrdem() {
        iPosOrdem(no);
    }

    public void iPosOrdem(NoArvore no) {
        if (no != null) {
            iPosOrdem(no.esquerda);
            iPosOrdem(no.direita);
            System.out.println(no.rgm + " " + no.nome);
        }
    }

    // apaga todos os nós da árvore
    public void apagar() {
        no = null;
    }
}