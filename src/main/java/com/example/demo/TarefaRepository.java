package com.example.demo;

import org.springframework.data.repository.CrudRepository;// Importa a interface que oferece operações prontas de CRUD. //

public interface TarefaRepository extends CrudRepository<TarefaModel, Integer>{
} // Repositório que acessa o banco de dados da tabela Tarefa. //
