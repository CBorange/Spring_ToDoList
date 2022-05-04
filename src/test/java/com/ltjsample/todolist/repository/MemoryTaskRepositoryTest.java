package com.ltjsample.todolist.repository;

import com.ltjsample.todolist.domain.Task;
import com.ltjsample.todolist.repository.MemoryTaskRepository;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryTaskRepositoryTest {
    MemoryTaskRepository repository = new MemoryTaskRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void add(){
        for(int i=0; i< 5; ++i)
        {
            // given

            Task task = new Task();
            task.setNo(i);
            task.setExplain(String.format("%s is No of This Task!", task.getNo()));
            task.setState("InProcess");

            // when
            repository.add(task);

            Task result = repository.findById(task.getId()).get();
            Assertions.assertThat(result).isEqualTo(task);
        }
    }

    @Test
    public void delete(){
        // given
        for(int i=0; i< 5; ++i)
        {
            Task task = new Task();
            task.setNo(i);
            task.setExplain(String.format("%s is No of This Task!", task.getNo()));
            task.setState("InProcess");

            repository.add(task);
        }

        // when
        repository.delete(1L);
        repository.delete(2L);
        repository.delete(3L);
        List<Task> storedTask = repository.findAll();
        Assertions.assertThat(storedTask.size()).isEqualTo(2);
    }
}
