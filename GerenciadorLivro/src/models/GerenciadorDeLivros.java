package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que gerencia livros no formato CRUD.
 */
public class GerenciadorDeLivros {
    private List<Livro> listaDeLivros = new ArrayList<>();

    public GerenciadorDeLivros() {
    }

    /**
     * Metodo usado para adicionar um novo livro a lista, caso
     * o livro a ser adicionado tenha o ISBN repetido não deixará
     * ser adicionado.
     * @param livroParaAdicionar Livro a ser adicionado.
     */
    public void adicionarLivro(Livro livroParaAdicionar) {
        for (Livro livrosNaLista: listaDeLivros) {
            if (livrosNaLista.getIsbn().equals(livroParaAdicionar.getIsbn())){
                System.out.println("ISBN ja adicionado");
                return;
            }
        }
        listaDeLivros.add(livroParaAdicionar);
    }

    /**
     * Lista todos os livros da lista caso
     * a lista não esteja vazia.
     */
    public void listarTodosLivros() {
        if (listaDeLivros.isEmpty()){
            System.out.println("Lista vazia");
            return;
        }
        listaDeLivros.forEach(System.out::println);
    }

    /**
     * Recebe o ISBN para buscar o livro que contém o ISBN,
     * caso não encontre retorna um valor nulo.
     * @param isbnParaBuscar Identificador único de livro a ser buscado
     * @return O livro a ser encontrado.
     */
    public Livro obterLivroPorIsbn(String isbnParaBuscar){
        for (Livro livrosDentroDaLista:listaDeLivros) {
            if (livrosDentroDaLista.getIsbn().equals(isbnParaBuscar)) {
                return livrosDentroDaLista;
            }
        }
        return null;
    }

    /**
     * Atualiza as informações do livro após receber o ISBN
     * caso não exista imprime uma mensagem de aviso que o livro não existe.
     * @param isbnLivroAtualizar Identificador único do livro a ser atualizado
     * @param Novotitulo Novo titulo do livro
     * @param Novoautor Novo autor do livro
     */
    public void atualizarLivro(String isbnLivroAtualizar, String Novotitulo, String Novoautor) {
        Livro livroParaAtualizar = obterLivroPorIsbn(isbnLivroAtualizar);
        if (!livroParaAtualizar.equals(null)) {
            livroParaAtualizar.setTitulo(Novotitulo);
            livroParaAtualizar.setAutor(Novoautor);
        } else {
            System.out.println("Livro não existe");
        }
    }

    /**
     * Atualiza as informações do livro após receber o ISBN
     * caso não exista imprime uma mensagem de aviso que o livro não existe.
     * @param isbnLivroAtualizar Identificador único do livro a ser atualizado
     * @param Novotitulo Novo titulo do livro
     */
    public void atualizarLivro(String isbnLivroAtualizar, String Novotitulo) {
        Livro livroParaAtualizar = obterLivroPorIsbn(isbnLivroAtualizar);
        if (!livroParaAtualizar.equals(null)) {
            livroParaAtualizar.setTitulo(Novotitulo);
        } else {
            System.out.println("Livro não existe");
        }
    }

    /**
     * Atualiza as informações do livro após receber o ISBN
     * caso não exista imprime uma mensagem de aviso que o livro não existe.
     * @param isbnLivroAtualizar Identificador único do livro a ser atualizado
     * @param Novoautor Novo titulo do livro
     */
    public void atualizarLivroAutor(String isbnLivroAtualizar, String Novoautor) {
        Livro livroParaAtualizar = obterLivroPorIsbn(isbnLivroAtualizar);
        if (!livroParaAtualizar.equals(null)) {
            livroParaAtualizar.setAutor(Novoautor);
        } else {
            System.out.println("Livro não existe");
        }
    }

    /**
     * Recebe o ISBN de um livro para excuílo.
     * @param isbnDoLivroParaExcluir Identificador único do livro a ser excluido
     */
    public void excluirLivro(String isbnDoLivroParaExcluir) {
        Livro livroParaExcluir = obterLivroPorIsbn(isbnDoLivroParaExcluir);
        if (!livroParaExcluir.equals(null)) {
            listaDeLivros.remove(livroParaExcluir);
        } else {
            System.out.println("Livro Inexistente");
        }
    }
}
