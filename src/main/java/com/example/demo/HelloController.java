package com.example.demo;   // Pacote onde esta classe está guardada.//

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;  // Importações usadas pelo Spring para controlar rotas e formatos.

@RestController  // Indica que esta classe é um controlador da API (retorna respostas HTTP).//
public class HelloController {

	@GetMapping("/")  // Indica que esta classe é um controlador REST. Ou seja, ela vai responder requisições HTTP.//
	public String index() {
		return "Greetings from Spring Boot!";
	}

    @Autowired(required = true)  //Faz o Spring criar e entregar um TarefaRepository pronto para usar. //
    private TarefaRepository tarefaRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addTarefa(@RequestParam String name, @RequestParam LocalDate data, @RequestParam String responsavel) {
        TarefaModel tarefa = new TarefaModel();  // Cria um novo objeto de Tarefa. //
        tarefa.setNome(name); // Coloca o nome enviado dentro da tarefa. //
        tarefa.setData(data); // Coloca a data enviada dentro da tarefa. //
        tarefa.setResponsavel(responsavel); //Coloca o responsável enviado dentro da tarefa. //
        tarefaRepository.save(tarefa); // Salva a tarefa no banco de dados. //
        return "Tarefa salva com sucesso!";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<TarefaModel> getAllTarefa(){ //Retorna uma lista com todas as tarefas do banco de dados. //
        return tarefaRepository.findAll();
    }

    @GetMapping(path="/update")
    public @ResponseBody String UpdateTarefa(@RequestParam Integer id, @RequestParam String nome, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data, @RequestParam String responsavel) {
        TarefaModel tarefa = new TarefaModel();// Cria um objeto tarefa para atualizar. //
        tarefa.setId(id); // Define o ID da tarefa que será atualizada. //
        tarefa.setNome(nome);  // Atualiza o nome da tarefa. //
        tarefa.setData(data);// Atualiza a data da tarefa. //
        tarefa.setResponsavel(responsavel);  // Atualiza o responsável. //
        tarefaRepository.save(tarefa);  // Salva a tarefa atualizada no banco de dados. //
        return "Tarefa atualizada com sucesso!"; // Retorna mensagem confirmando a atualização. //
    }

    @GetMapping(path="/delete")
    public @ResponseBody String deleteTarefa(@RequestParam Integer id) {// Pega o ID enviado na URL para saber qual tarefa apagar. //

        if (!tarefaRepository.existsById((int) id.longValue())) {  // Verifica se a tarefa existe. Se não existir, retorna mensagem. //
            return "Tarefa não encontrada!";
        }
        tarefaRepository.deleteById((int) id.longValue());// Deleta a tarefa do banco de dados. //
        return "Tarefa deletada com sucesso!"; // Retorna mensagem confirmando a exclusão. //
    }
}