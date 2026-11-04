package br.com.boraler.api.exception;

// Representa a tentativa de acessar um Livro que não existe.
public class LivroNaoEncontradoException extends RuntimeException {
    // Monta a mensagem de erro com o identificador pesquisado.

    public LivroNaoEncontradoException(Long id) {
        super("Livro não encontrado com o ID " + id + ".");
    }
}
