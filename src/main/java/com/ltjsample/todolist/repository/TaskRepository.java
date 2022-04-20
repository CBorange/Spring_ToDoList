package com.ltjsample.todolist.repository;

import com.ltjsample.todolist.domain.Task;

import java.util.List;
import java.util.Optional;

// DBMS 변경 가능성 있으므로 interface로 작성
public interface TaskRepository {
    Task add(Task task);
    void delete(Long id);

    Optional<Task> findById(Long id);

    List<Task> findAll();
}
