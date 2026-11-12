package br.com.boraler.api.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Centraliza o tratamento das exceções dos controllers da API.
@RestControllerAdvice
public class ApiExceptionHandler {

    // Converte a exceção de livro inexistente em uma resposta HTTP 404.
    @ExceptionHandler(LivroNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> tratarLivroNaoEncontrado(
            LivroNaoEncontradoException exception) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("erro", exception.getMessage()));
    }

    // Converte falhas de validação do DTO em uma resposta HTTP 400.
    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<Map<String, String>> tratarValidacao(
            MethodArgumentNotValidException exception) {

        // Obtém os detalhes da validação e procura o primeiro campo inválido.
        var erro = exception.getBindingResult().getFieldError();

        // Usa a mensagem da anotação de validação ou uma mensagem padrão.
        String mensagem = erro != null
                ? erro.getDefaultMessage()
                : "Dados inválidos.";

        return ResponseEntity
                .badRequest()
                .body(Map.of("erro", mensagem));
    }
}