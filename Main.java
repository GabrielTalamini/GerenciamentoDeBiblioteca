import java.util.Scanner;

public class Main {
    private static Biblioteca biblioteca = new Biblioteca();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            apresentarInicio();

            while (true) {
                mostrarMenu();
                String opcao = scanner.nextLine();

                switch (opcao) {
                    case "1":
                        biblioteca.adicionarLivro();
                        break;
                    case "2":
                        biblioteca.listarLivros();
                        break;
                    case "3":
                        biblioteca.pesquisarLivro();
                        break;
                    case "4":
                        biblioteca.removerLivro();
                        break;
                    case "5":
                        biblioteca.editarLivro();
                        break;
                    case "6":
                        biblioteca.listarLivrosOrdenados();
                        break;
                    case "0":
                        despedida();
                        scanner.close();
                        return;
                    default:
                        System.out.println("\nOpção inválida. Tente novamente.");
                        pressioneEnterParaContinuar();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("\nErro no programa: " + e.getMessage());
        }
    }

    private static void apresentarInicio() {
        System.out.println("══════════════════════════════════════════════════════════════");
        System.out.println("     Bem-vindo ao Sistema de Gerenciamento de Biblioteca    ");
        System.out.println("══════════════════════════════════════════════════════════════");
        aguardar(1500); // Aguardar 1,5 segundos para uma introdução mais amigável
    }

    private static void despedida() {
        System.out.println("\n══════════════════════════════════════════════════════════════");
        System.out.println("           Obrigado por usar o Sistema de Biblioteca!         ");
        System.out.println("════════════════════════════════════════════════════════════════");
        aguardar(1500); // Aguardar 1,5 segundos para uma despedida mais amigável
    }

    private static void mostrarMenu() {
        System.out.println("Menu:");
        System.out.println("1 - Adicionar um novo livro ao acervo.");
        System.out.println("2 - Listar todos os livros no acervo.");
        System.out.println("3 - Pesquisar um livro no acervo pelo título.");
        System.out.println("4 - Remover um livro do acervo.");
        System.out.println("5 - Editar informações de um livro.");
        System.out.println("6 - Listar todos os livros no acervo (Ordenados).");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void pressioneEnterParaContinuar() {
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    private static void aguardar(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

