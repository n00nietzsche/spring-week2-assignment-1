package com.codesoom.assignment.repositories;

import com.codesoom.assignment.models.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TaskRepository {

    private Map<Long, Task> taskMap = new ConcurrentHashMap<>();

    public List<Task> findAll() {
        return new ArrayList<>(taskMap.values());
    }

    public Task save(Task task) {
        taskMap.put(task.getId(), task);

        return task;
    }

    public Optional<Task> findOne(Long id) {
        return Optional.ofNullable(taskMap.get(id));
    }

    public void delete(Long id) {
        taskMap.remove(id);
    }

    public void removeAll() {
        taskMap.clear();
    }
    
}
