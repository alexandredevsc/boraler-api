package br.com.boraler.api.livro;

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
}
