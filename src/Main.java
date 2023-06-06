package atividade_27_05_2023;

import java.util.Scanner;

public class Main {

	   public static void main(String[] args) {
	        GerenciadorDeContatos gerenciador = new GerenciadorDeContatos();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nSelecione uma opção:");
	            System.out.println("1 - Adicionar contato");
	            System.out.println("2 - Remover contato");
	            System.out.println("3 - Buscar número de telefone");
	            System.out.println("4 - Exibir contatos");
	            System.out.println("5 - Gravar contatos em arquivo");
	            System.out.println("6 - Ler contatos de arquivo");
	            System.out.println("0 - Sair");

	            int opcao = scanner.nextInt();
	            scanner.nextLine(); 

	            switch (opcao) {
	                case 1:
	                    System.out.println("Digite o nome do contato:");
	                    String nome = scanner.nextLine();
	                    System.out.println("Digite o número de telefone:");
	                    String numeroTelefone = scanner.nextLine();
	                    gerenciador.adicionarContato(nome, numeroTelefone);
	                    System.out.println("Contato adicionado com sucesso!");
	                    break;
	                case 2:
	                    System.out.println("Digite o nome do contato a ser removido:");
	                    nome = scanner.nextLine();
	                    gerenciador.removerContato(nome);
	                    System.out.println("Contato removido com sucesso!");
	                    break;
	                case 3:
	                    System.out.println("Digite o nome do contato a ser buscado:");
	                    nome = scanner.nextLine();
	                    String numero = gerenciador.buscarNumeroTelefone(nome);
	                    if (numero != null) {
	                        System.out.println("Número de telefone: " + numero);
	                    } else {
	                        System.out.println("Contato não encontrado.");
	                    }
	                    break;
	                case 4:
	                    gerenciador.exibirContatos();
	                    break;
	                case 5:
	                    System.out.println("Digite o nome do arquivo para gravar os contatos:");
	                    String arquivoGravacao = scanner.nextLine();
	                    gerenciador.gravarContatos(arquivoGravacao);
	                    break;
	                case 6:
	                    System.out.println("Digite o nome do arquivo para ler os contatos:");
	                    String arquivoLeitura = scanner.nextLine();
	                    gerenciador.lerContatos(arquivoLeitura);
	                    break;
	                case 0:
	                    System.out.println("Encerrando o programa...");
	                    return;
	                default:
	                    System.out.println("Opção inválida. Tente novamente.");
	                    break;
	            }
	        }
	    }
}
