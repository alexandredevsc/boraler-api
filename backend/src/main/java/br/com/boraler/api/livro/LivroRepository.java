package br.com.boraler.api.livro;

import org.springframework.data.jpa.repository.JpaRepository;

// Disponibiliza operações de persistência para a entidade livro.
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
