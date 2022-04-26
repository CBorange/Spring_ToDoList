package com.ltjsample.todolist.controller;

import com.ltjsample.todolist.domain.Task;
import com.ltjsample.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private TaskService taskService;

    @Autowired
    public HomeController(TaskService taskService)
    {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model){
        List<Task> taskList = taskService.getAllTask();
        model.addAttribute("taskList", taskList);
        return "TodoListHome";
    }
}
