package br.com.boraler.api.livro;

import java.util.List;

import org.springframework.stereotype.Service;

// Registra esta classe como um serviço gerenciado pelo Spring.
@Service
public class LivroService {

    // Guarda a referência ao componente que acessa os livros no banco.
    private final LivroRepository repository;

    // O Spring fornece o Repository ao criar este serviço.
    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    // Cria um livro com os dados recebidos e salva no banco.
    public Livro cadastrar(LivroRequisicao requisicao) {

        // Converte dados recebidos no DTO em uma entidade livro.
        Livro livro = new Livro(
                requisicao.titulo(),
                requisicao.autor(),
                requisicao.lido());

        // Salva o livro no banco e retorna a entidade com o ID gerado.
        return repository.save(livro);

    }

    // Consulta e retorna todos os livros cadastradso no banco.
    public List<Livro> listarTodos() {
        return repository.findAll();
    }
}
