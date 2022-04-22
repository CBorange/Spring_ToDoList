package com.ltjsample.todolist;

import com.ltjsample.todolist.domain.Task;
import com.ltjsample.todolist.repository.MemoryTaskRepository;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

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
}
