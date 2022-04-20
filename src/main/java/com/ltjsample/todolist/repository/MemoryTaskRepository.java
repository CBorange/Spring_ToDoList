package com.ltjsample.todolist.repository;

import com.ltjsample.todolist.domain.Task;

import java.util.*;

public class MemoryTaskRepository implements TaskRepository{

    private Map<Long, Task> store;
    private long sequence;

    public MemoryTaskRepository(){
        store = new HashMap<>();
        sequence = 0L;
    }

    @Override
    public Task add(Task task) {
        task.setId(++sequence);
        store.put(task.getId(), task);
        return task;
    }

    @Override
    public void delete(Long id) {
        store.remove(id);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
