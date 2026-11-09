package br.com.boraler.api.livro;

import br.com.boraler.api.exception.LivroNaoEncontradoException;

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

    // Consulta e retorna todos os livros cadastrados no banco.

    public List<Livro> listarTodos() {
        return repository.findAll();
    }

    // Busca um livro pelo identificador informado.
    public Livro buscarPorId(Long id) {
        // Retorna o livro encontrado ou lança uma exceção se ele não existir.
        return repository.findById(id)
                .orElseThrow(() -> new LivroNaoEncontradoException(id));
    }

    // Atualiza os dados de um livro existente, preservando seu ID.

    public Livro atualizar(Long id, LivroRequisicao requisicao) {
        // Reutiliza a busca que lança uma exceção caso o livro não exista

        Livro livro = buscarPorId(id);

        // Substitui os dados editáveis pelos valores recebidos no DTO.
        livro.setTitulo(requisicao.titulo());
        livro.setAutor(requisicao.autor());
        livro.setLido(requisicao.lido());

        // Salva as alterações e retorna o livro atualizado.

        return repository.save(livro);
    }
}
