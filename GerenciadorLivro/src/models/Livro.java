package models;

import java.util.MissingFormatArgumentException;

/**
 * Classe que representa um livro.
 */
public class Livro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anoPublicacao;

    /**
     * @param isbn          Identificador único do livro.
     * @param titulo        Titulo do livro.
     * @param autor         Autor do livro.
     * @param anoPublicacao Ano da publicação do livro.
     */
    public Livro(String isbn, String titulo, String autor, int anoPublicacao) {
        try {
            if (isbn.equals(null) || isbn.isEmpty()) {
                throw new IllegalArgumentException("ISBN não pode ser nulo");
            }
            if (!isbn.matches("\\d{3}-\\d{10}")) {
                throw new IllegalArgumentException("Formato ISBN incorreto");
            }
            if (titulo.equals(null) || titulo.isEmpty()) {
                throw new IllegalArgumentException("Titulo não pode ser nulo");
            }
            if (autor.equals(null) || autor.isEmpty()) {
                throw new IllegalArgumentException("Autor não pode ser nulo");
            }
            if (anoPublicacao <= 0) {
                throw new IllegalArgumentException("Número não pode ser negativo");
            }
            this.isbn = isbn;
            this.titulo = titulo;
            this.autor = autor;
            this.anoPublicacao = anoPublicacao;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public Livro() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        try {
            if (isbn.equals(null) || isbn.isEmpty()) {
                throw new IllegalArgumentException("ISBN não pode ser nulo");
            }
            if (!isbn.matches("\\d{3}-\\d{10}")) {
                throw new IllegalArgumentException("Formato ISBN incorreto");
            }
            this.isbn = isbn;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        try {
            if (titulo.equals(null) || titulo.isEmpty()) {
                throw new IllegalArgumentException("Titulo não pode ser nulo");
            }
            this.titulo = titulo;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        try {
            if (autor.equals(null) || autor.isEmpty()) {
                throw new IllegalArgumentException("Autor não pode ser nulo");
            }
            this.autor = autor;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        try {
            if (anoPublicacao <= 0) {
                throw new IllegalArgumentException("Nùmeros não pode ser negativo");
            }
            this.anoPublicacao = anoPublicacao;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }

    }

    @Override
    public String toString() {
        return "isbn='" + isbn + '\'' + ", titulo='" + titulo + '\'' + ", autor='" + autor + '\'' + ", anoPublicacao=" + anoPublicacao;
    }
}