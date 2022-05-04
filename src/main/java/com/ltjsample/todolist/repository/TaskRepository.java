package com.ltjsample.todolist.repository;

import com.ltjsample.todolist.domain.Task;

import java.util.List;
import java.util.Optional;

// DBMS 변경 가능성 있으므로 interface로 작성
public interface TaskRepository {
    Task add(Task task);
    void setState(Long id, String state);
    void delete(Long id);
    void sortRowNumbers();

    Optional<Task> findById(Long id);

    List<Task> findAll();
}
