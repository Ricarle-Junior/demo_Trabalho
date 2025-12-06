package com.example.demo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity // Diz que esta classe representa uma tabela no banco de dados. //
@Table(name = "tarefa", schema = "mydb")// Define o nome da tabela ("tarefa") e o schema ("mydb"). //
public class TarefaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtarefa", nullable = false)
    private Integer id;//Campo "idtarefa" é a chave primária.É gerado automaticamente pelo banco.//

    @Column(name = "nome", length = 45)
    private String nome;    // Campo "nome" da tabela, com no máximo 45 caracteres. //

    @Column(name = "data")
    private LocalDate data;    // Campo "data" da tarefa (do tipo LocalDate). //

    @Column(name = "responsavel", length = 45)
    private String responsavel;  // Campo "responsavel" da tarefa, também limitado a 45 caracteres. //

    public Integer getId() {
        return id;
    } // Retorna o ID da tarefa. //

    public void setId(Integer id) {
        this.id = id;
    }   // Define o ID da tarefa. //

    public String getNome() {
        return nome;
    }  // Retorna o nome da tarefa. //

    public void setNome(String nome) {
        this.nome = nome;
    }// Define o nome da tarefa. //

    public LocalDate getData() {
        return data;
    }  // Retorna a data da tarefa. //

    public void setData(LocalDate data) {
        this.data = data;
    }    // Define a data da tarefa. //

    public String getResponsavel() {
        return responsavel;
    }   // Retorna o responsável pela tarefa. //

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;     // Define o responsável pela tarefa. //
    }

}