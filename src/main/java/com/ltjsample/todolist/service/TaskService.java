package com.ltjsample.todolist.service;

import com.ltjsample.todolist.controller.dto.TaskAddInfo;
import com.ltjsample.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public void addTask(TaskAddInfo addInfo){

    }

    public void deleteTask(){

    }

    public void FinishTask(){

    }
}
