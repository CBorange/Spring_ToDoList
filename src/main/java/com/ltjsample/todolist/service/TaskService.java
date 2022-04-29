package com.ltjsample.todolist.service;

import com.ltjsample.todolist.domain.Task;
import com.ltjsample.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public void addTask(Task addTask){
        Task newTask = new Task();
        newTask.setExplain(addTask.getExplain());
        newTask.setState("InProgress");
        taskRepository.add(newTask);
    }

    public void deleteTask(Task deleteTask){
        if(deleteTask == null)
            System.out.println("TaskService : deleteTask로 전달된 Task VO가 null 이다.");
        taskRepository.delete(deleteTask.getId());
    }

    public void finishTask(Task finishedTask){
        Optional<Task> optTask = taskRepository.findById(finishedTask.getId());
        if(optTask.isPresent()){
            optTask.get().setState("Finished");
        }
        else
            System.out.println("TaskService : finishTask로 전달된 Task VO가 null 이다.");
    }
}
