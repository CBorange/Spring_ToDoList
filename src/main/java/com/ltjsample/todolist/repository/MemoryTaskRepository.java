package com.ltjsample.todolist.repository;

import com.ltjsample.todolist.domain.Task;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
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
        task.setNo(store.size() + 1);
        store.put(task.getId(), task);
        return task;
    }

    @Override
    public void delete(Long id) {
        System.out.println("TaskRepository[delete] : " + id);
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
