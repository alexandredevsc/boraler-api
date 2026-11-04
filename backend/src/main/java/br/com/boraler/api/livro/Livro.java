package br.com.boraler.api.livro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Informa ao JPA que esta classe representa uma entidade persistida no banco.
@Entity

// Define o nome da tabela que armazenará os livros.
@Table(name = "livros")
public class Livro {

    // Identificador único do Livro, gerado automaticamente pelo banco.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Titulo obrigatório no banco, com limite de 120 caracteres.
    @Column(nullable = false, length = 120)
    private String titulo;

    // Autor obrigatório no banco, com limite de 120 caracteres.
    @Column(nullable = false, length = 120)
    private String autor;

    // Indica a situação de Leitura: true = lido; false = não lido.
    private boolean lido;

    // Construtor sem argumentos exigido pelo JPA para criar os objetos

    protected Livro() {

    }

    // Construtor usado pela aplicação para criar um Livro com seus dados iniciais.

    public Livro(String titulo, String autor, boolean lido) {
        this.titulo = titulo;
        this.autor = autor;
        this.lido = lido;

    }

    // Permite consultar o ID gerado pelo banco.
    public Long getId() {
        return id;
    }

    // Permite consultar o título.
    public String getTitulo() {
        return titulo;
    }

    // Permite atualizar o título.
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Permite consultar o autor.
    public String getAutor() {
        return autor;
    }

    // Permite atualizar o autor.
    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Permite consultar se o livro já foi lido.
    public boolean isLido() {
        return lido;
    }

    // Permite alterar a situação de leitura do livro.
    public void setLido(boolean lido) {
        this.lido = lido;
    }

}
