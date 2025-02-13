package projeto;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaBusca abb = new ArvoreBinariaBusca();
        Scanner teclado = new Scanner(System.in);
        
        String nomeAluno;
        System.out.println("Digite seu nome: ");
        nomeAluno = teclado.nextLine();
        
        int escolha;
        do {
            System.out.println("\nALUNO:" + nomeAluno);
            System.out.println("DISCIPLINA: ESTRUTURA DE DADOS I");
            System.out.println("PROFESSOR: LEANDRO MELO");
            System.out.println("\n\tEDITOR DE ÁRVORE");
            System.out.println("\n1-INSERIR fornecer RGM e Nome");
            System.out.println("2-REMOVER UM NÓ fornecer o RGM a remover");
            System.out.println("3-PESQUISAR fornecer o RGM a pesquisar");
            System.out.println("4-ESVAZIAR A ÁRVORE");
            System.out.println("5-EXIBIR A ÁRVORE três opções: PRÉ, IN ou PÓS");
            System.out.println("0-SAIR");
            System.out.print("Escolha uma opção: ");
            escolha = teclado.nextInt();
            teclado.nextLine(); 

            switch (escolha) {
                case 1:
                    System.out.print("Digite o RGM: ");
                    int rgm = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Digite o Nome: ");
                    String nome = teclado.nextLine();
                    abb.inserir(rgm, nome);
                    break;
                case 2:
                    System.out.print("Digite o RGM a ser removido: ");
                    int rgmRemover = teclado.nextInt();
                    NoArvore noArvoreRemovido = abb.remove(rgmRemover);
                    if (noArvoreRemovido != null) {
                        System.out.println("Nó removido: " + noArvoreRemovido.rgm + " " + noArvoreRemovido.nome);
                    } else {
                        System.out.println("Nó não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o RGM a ser pesquisado: ");
                    int rgmPesquisar = teclado.nextInt();
                    if (abb.buscar(rgmPesquisar)) {
                        System.out.println("RGM " + rgmPesquisar + " encontrado.");
                    } else {
                        System.out.println("RGM " + rgmPesquisar + " não encontrado.");
                    }
                    break;
                case 4:
                    abb.apagar();
                    System.out.println("Todos os nós foram apagados.");
                    break;
                case 5:
                    System.out.println("Pré-ordem:");
                    abb.preOrdem();
                    System.out.println("Em ordem:");
                    abb.inOrdem();
                    System.out.println("Pós-ordem:");
                    abb.posOrdem();
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (escolha != 0);

        teclado.close();
    }
}
