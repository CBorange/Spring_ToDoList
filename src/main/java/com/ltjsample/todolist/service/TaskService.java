package com.ltjsample.todolist.service;

import com.ltjsample.todolist.controller.dto.TaskAddInfo;
import com.ltjsample.todolist.controller.dto.TaskFinishInfo;
import com.ltjsample.todolist.domain.Task;
import com.ltjsample.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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

    public void addTask(TaskAddInfo addInfo){
        Task newTask = new Task();
        newTask.setExplain(addInfo.getTaskExplain());
        newTask.setState("InProgress");
        taskRepository.add(newTask);
    }

    public void deleteTask(){

    }

    public void finishTask(Task finishedTask){
        Optional<Task> optTask = taskRepository.findById(finishedTask.getId());
        if(optTask.isPresent()){
            optTask.get().setState("Finished");
        }
        System.out.println("TaskService : finishTask로 전달된 Task DTO가 null 이다.");
    }
}
