package com.ltjsample.todolist.service;

import com.ltjsample.todolist.controller.dto.TaskAddInfo;
import com.ltjsample.todolist.domain.Task;
import com.ltjsample.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void addTask(TaskAddInfo addInfo){
        Task newTask = new Task();
        newTask.setExplain(addInfo.getTaskExplain());
        newTask.setState("InProgress");
        taskRepository.add(newTask);
    }

    public void deleteTask(){

    }

    public void FinishTask(){

    }
}
