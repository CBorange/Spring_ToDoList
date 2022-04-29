package com.ltjsample.todolist.controller;

import com.ltjsample.todolist.domain.Task;
import com.ltjsample.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Task task){
        System.out.println("add: " + task.getExplain());
        taskService.addTask(task);
        return "redirect:/";
    }

    @PostMapping("/finish")
    public String finish(@ModelAttribute Task task){
        System.out.println("finish: " + task.getId());
        taskService.finishTask(task);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Task task){
        System.out.println("delete: " + task.getId());
        taskService.deleteTask(task);
        return "redirect:/";
    }

}
