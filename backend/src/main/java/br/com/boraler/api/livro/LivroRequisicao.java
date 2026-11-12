package br.com.boraler.api.livro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Transporta e valida os dados recebidos nas requisições de cadastro e atualização.
public record LivroRequisicao(
        // rejeita título nulo, vazio ou composto apenas por espaços.

        @NotBlank(message = "O título é obrigatório.") @Size(max = 120, message = "O título deve ter até 120 caracteres.") String titulo,

        // Aplica ao autor as mesmas regras de obrigatoriedade e tamanho.
        @NotBlank(message = "O autor é obrigatório.") @Size(max = 120, message = "O autor deve ter até 120 caracteres.") String autor,

        // Recebe a situação de Leitura informada pelo usuário.
        boolean lido) {

}
