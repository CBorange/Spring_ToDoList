package com.ltjsample.todolist.service;

import com.ltjsample.todolist.domain.Task;
import com.ltjsample.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public Long addTask(Task addTask){
        Task newTask = new Task();
        newTask.setExplain(addTask.getExplain());
        newTask.setState("InProgress");

        taskRepository.add(newTask);

        return newTask.getId();
    }

    public void deleteTask(Task deleteTask){
        if(deleteTask == null){
            System.out.println("TaskService : deleteTask로 전달된 Task VO가 null 이다.");
            return;
        }

        taskRepository.delete(deleteTask.getId());
    }

    public void finishTask(Task finishedTask){
        if(finishedTask == null){
            System.out.println("TaskService : finishTask 전달된 Task VO가 null 이다.");
            return;
        }

        System.out.println(String.format("TaskService : finishTask ID : %d", finishedTask.getId()));
        taskRepository.setState(finishedTask.getId(), "Finished");
    }
}
