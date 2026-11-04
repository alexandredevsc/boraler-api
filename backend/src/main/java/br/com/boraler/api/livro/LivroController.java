package br.com.boraler.api.livro;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
