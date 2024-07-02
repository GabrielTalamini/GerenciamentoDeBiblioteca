import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Livro> acervo;
    private Scanner scanner;

    public Biblioteca() {
        acervo = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void adicionarLivro() {
        limparConsole();
        System.out.println("\n══════════════════════════════════════════════════════════════");
        System.out.println("               Adicionar um Novo Livro ao Acervo             ");
        System.out.println("══════════════════════════════════════════════════════════════");

        System.out.print("Digite o Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o nome do autor: ");
        String autor = scanner.nextLine();

        int ano = lerInteiro("Digite o ano de publicação: ");
        int paginas = lerInteiro("Digite o número de páginas: ");

        if (titulo.isEmpty() || autor.isEmpty()) {
            System.out.println("\n[TIP] Título e autor não podem ser vazios.");
            pressioneEnterParaContinuar();
            limparConsole();
            return;
        }

        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("\n[ERRO] Já existe um livro com este título.");
                pressioneEnterParaContinuar();
                limparConsole();
                return;
            }
        }

        Livro novoLivro = new Livro(titulo, autor, ano, paginas);
        acervo.add(novoLivro);
        System.out.println("\n[SUCESSO] Livro adicionado com sucesso!");
        pressioneEnterParaContinuar();
        limparConsole();
    }

    public void listarLivros() {
        limparConsole();
        System.out.println("\n══════════════════════════════════════════════════════════════");
        System.out.println("                     Listar Todos os Livros                   ");
        System.out.println("══════════════════════════════════════════════════════════════");
        if (acervo.isEmpty()) {
            System.out.println("O acervo está vazio!");
        } else {
            for (int i = 0; i < acervo.size(); i++) {
                System.out.println((i + 1) + ". " + acervo.get(i));
            }
        }
        pressioneEnterParaContinuar();
        limparConsole();
    }

    public void pesquisarLivro() {
        limparConsole();
        System.out.println("\n══════════════════════════════════════════════════════════════");
        System.out.println("                   Pesquisar Livro por Título                 ");
        System.out.println("══════════════════════════════════════════════════════════════");

        System.out.print("Digite o título do livro que deseja pesquisar: ");
        String titulo = scanner.nextLine();

        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("\n[SUCESSO] Livro encontrado:");
                System.out.println(livro);
                pressioneEnterParaContinuar();
                limparConsole();
                return;
            }
        }

        System.out.println("\n[ERRO] Livro não encontrado.");
        pressioneEnterParaContinuar();
        limparConsole();
    }

    public void removerLivro() {
        limparConsole();
        System.out.println("\n══════════════════════════════════════════════════════════════");
        System.out.println("                   Remover um Livro do Acervo                 ");
        System.out.println("══════════════════════════════════════════════════════════════");

        System.out.print("Digite o título do livro que deseja remover: ");
        String titulo = scanner.nextLine();

        Livro livroParaRemover = null;
        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livroParaRemover = livro;
                break;
            }
        }

        if (livroParaRemover != null) {
            acervo.remove(livroParaRemover);
            System.out.println("\n[SUCESSO] Livro removido com sucesso!");
        } else {
            System.out.println("\n[ERRO] Livro não encontrado.");
        }
        pressioneEnterParaContinuar();
        limparConsole();
    }

    public void editarLivro() {
        limparConsole();
        System.out.println("\n══════════════════════════════════════════════════════════════");
        System.out.println("                   Editar Informações de um Livro             ");
        System.out.println("══════════════════════════════════════════════════════════════");

        System.out.print("Digite o título do livro que deseja editar: ");
        String titulo = scanner.nextLine();

        Livro livroParaEditar = null;
        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livroParaEditar = livro;
                break;
            }
        }

        if (livroParaEditar != null) {
            System.out.print("Digite o novo título (atual: " + livroParaEditar.getTitulo() + "): ");
            String novoTitulo = scanner.nextLine();
            if (!novoTitulo.isEmpty()) {
                livroParaEditar.setTitulo(novoTitulo);
            }

            System.out.print("Digite o novo nome do autor (atual: " + livroParaEditar.getAutor() + "): ");
            String novoAutor = scanner.nextLine();
            if (!novoAutor.isEmpty()) {
                livroParaEditar.setAutor(novoAutor);
            }

            int novoAno = lerInteiro("Digite o novo ano de publicação (atual: " + livroParaEditar.getAnoPublicacao() + "): ");
            livroParaEditar.setAnoPublicacao(novoAno);

            int novasPaginas = lerInteiro("Digite o novo número de páginas (atual: " + livroParaEditar.getNumeroPaginas() + "): ");
            livroParaEditar.setNumeroPaginas(novasPaginas);

            System.out.println("\n[SUCESSO] Livro editado com sucesso!");
        } else {
            System.out.println("\n[ERRO] Livro não encontrado.");
        }
        pressioneEnterParaContinuar();
        limparConsole();
    }

    public void listarLivrosOrdenados() {
        limparConsole();
        System.out.println("\n══════════════════════════════════════════════════════════════");
        System.out.println("          Listar Livros Ordenados por Título                  ");
        System.out.println("══════════════════════════════════════════════════════════════");

        if (acervo.isEmpty()) {
            System.out.println("O acervo está vazio!");
        } else {
            List<Livro> acervoOrdenado = new ArrayList<>(acervo);
            acervoOrdenado.sort(Comparator.comparing(Livro::getTitulo));

            for (int i = 0; i < acervoOrdenado.size(); i++) {
                System.out.println((i + 1) + ". " + acervoOrdenado.get(i));
            }
        }
        pressioneEnterParaContinuar();
        limparConsole();
    }

    private void limparConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("[ERRO] Falha ao limpar o console.");
        }
    }

    private int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERRO] Por favor, digite um número válido.");
            }
        }
    }

    private void pressioneEnterParaContinuar() {
        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine();
    }
}
