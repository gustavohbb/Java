import models.GerenciadorDeLivros;
import models.Livro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorDeLivros gerenciadorDeLivros = new GerenciadorDeLivros();
        Scanner entrada = new Scanner(System.in);
        String isbn = null, titulo = null, autor = null;
        int anoPublicacao = 0, opcoesMenu = 0;
        while (opcoesMenu != 5) {
            System.out.println("1-Adicionar Livro\n2-Listar todos livros\n3-Atualizar livro\n4-Excluir livro\n5-Sair");
            opcoesMenu = entrada.nextInt();
            switch (opcoesMenu) {
                case 1:
                    System.out.println("Digite o ISBN desse livro");
                    isbn = entrada.next();
                    System.out.println("Digite o titulo");
                    titulo = entrada.next();
                    System.out.println("Digite o autor");
                    autor = entrada.next();
                    System.out.println("Digite o ano de lançamento");
                    anoPublicacao = entrada.nextInt();
                    Livro livroAdicionar = new Livro(isbn, titulo, autor, anoPublicacao);
                    gerenciadorDeLivros.adicionarLivro(livroAdicionar);
                    break;
                case 2:
                    gerenciadorDeLivros.listarTodosLivros();
                    break;
                case 3:
                      opcoesParaAtualizar(entrada, isbn, titulo, autor, gerenciadorDeLivros);
                    break;
                case 4:
                    System.out.println("ISBN do livro a ser excluido");
                    isbn = entrada.next();
                    gerenciadorDeLivros.excluirLivro(isbn);
                    break;
                case 5:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }
        entrada.close();
    }

    public static void opcoesParaAtualizar(Scanner entrada, String isbn, String titulo, String autor, GerenciadorDeLivros gerenciadorDeLivros) {

        System.out.println("Oque Deseja Atualizar\n1-Titulo e Autor\n2-Titulo\n3-Autor");
        int opcoesAtualizar = entrada.nextInt();
        switch (opcoesAtualizar) {
            case 1:
                System.out.println("ISBN do livro");
                isbn = entrada.next();
                System.out.println("Novo titulo");
                titulo = entrada.next();
                System.out.println("Novo autor");
                autor = entrada.next();
                gerenciadorDeLivros.atualizarLivro(isbn, titulo, autor);
                break;
            case 2:
                System.out.println("ISBN do livro");
                isbn = entrada.next();
                System.out.println("Novo titulo");
                titulo = entrada.next();
                gerenciadorDeLivros.atualizarLivro(isbn, titulo);
                break;
            case 3:
                System.out.println("ISBN do livro");
                isbn = entrada.next();
                System.out.println("Novo autor");
                autor = entrada.next();
                gerenciadorDeLivros.atualizarLivroAutor(isbn, autor);
                break;
            default:
                System.out.println("Opção Inválida");
                break;
        }
    }
}