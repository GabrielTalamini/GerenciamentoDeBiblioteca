public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int numeroPaginas;

    public Livro(String titulo, String autor, int anoPublicacao, int numeroPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.numeroPaginas = numeroPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String toString() {
        return String.format("Título: '%s', Autor: '%s', Ano de Publicação: %d, Número de Páginas: %d",
                             titulo, autor, anoPublicacao, numeroPaginas);
    }
}
