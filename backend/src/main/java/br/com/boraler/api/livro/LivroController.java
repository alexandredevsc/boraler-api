package br.com.boraler.api.livro;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Identifica o componente que receberá requisições HTTP e retornará dados.
@RestController

// Define o endereço-base das futuras operações de Livros.
@RequestMapping("/api/livros")
public class LivroController {

    // Guarda a referência ao serviço responsável pelas operações dos livros.

    private final LivroService service;

    // O Spring fornece o Service ao Criar este controller.
    public LivroController(LivroService service) {
        this.service = service;
    }

    // Recebe uma requisição POST para cadastrar um Livro

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@Valid @RequestBody LivroRequisicao requisicao) {

        // Salva o Livro e recebe a entidade com o ID gerado.
        Livro livro = service.cadastrar(requisicao);

        // Monta o endereço do recurso recém criado.
        URI localizacao = URI.create("/api/livros/" + livro.getId());

        // Retorna HTTP 201, cabeçalho location e o Livro salvo no corpo.

        return ResponseEntity.created(localizacao).body(livro);

    }

    // Recebe uma requisição GET e retorna todos os livros cadastrados.
    @GetMapping
    public List<Livro> listar() {
        return service.listarTodos();
    }

    // Recebe uma requisição GET para consultar um livro pelo ID.
    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Long id) {
        // Encaminha o identificador ao service e retorna o livro encontrado.
        return service.buscarPorId(id);
    }

}
