package br.com.ohashi.taskswithwebflux.service;

import br.com.ohashi.taskswithwebflux.model.Task;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class TaskService {

    public static List<Task> taskList;

    public Mono<Task> insert(Task task) {
        return Mono.just(task)
                .map(Task::insert)
                .flatMap(this::save);
    }

    public Mono<List<Task>> list() {
        return Mono.just(taskList);
    }

    private Mono<Task> save(Task task) {
        return Mono.just(task)
                .map(Task::newTask);
    }
}
