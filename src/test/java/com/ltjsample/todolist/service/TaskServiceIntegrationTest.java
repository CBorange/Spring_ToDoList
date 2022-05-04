package com.ltjsample.todolist.service;

import com.ltjsample.todolist.domain.Task;
import com.ltjsample.todolist.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class TaskServiceIntegrationTest {
    @Autowired TaskService taskService;
    @Autowired TaskRepository taskRepository;

    @Test
    public void 일정추가() throws Exception {
        // Given
        Task task = new Task();
        task.setExplain("test job");

        // When
        Long addedId = taskService.addTask(task);

        // Then
        Task findTask = taskRepository.findById(addedId).get();
        assertEquals(task.getExplain(), findTask.getExplain());
    }

    @Test
    public void 일정제거(){
        // Given
        Task task = new Task();
        task.setExplain("test job");

        // When
        Long addedId = taskService.addTask(task);
        task.setId(addedId);    // View 에서 전달된 Task VO처럼 사용
        taskService.deleteTask(task);

        // Then
        Optional<Task> findTask = taskRepository.findById(addedId);
        assertThat(findTask).isNotNull();
    }

    @Test
    public void 일정완료() throws Exception{
        // Given
        Task task = new Task();
        task.setExplain("test job1");
        task.setState("InProgress");

        Task task2 = new Task();
        task.setExplain("test job2");
        task.setState("InProgress");

        // When
        Long task1_Id = taskService.addTask(task);
        Long task2_Id = taskService.addTask(task2);
        task2.setId(task2_Id);  // View에서 전달된 Task VO처럼 사용한다.


        taskService.finishTask(task2);

        // Then
        Optional<Task> optTask = taskRepository.findById(task2.getId());
        optTask.ifPresent((presentedTask) -> {
            assertEquals(presentedTask.getId(), task2_Id);
            assertEquals(presentedTask.getState(), "Finished");
        });
    }
}