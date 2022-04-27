package com.ltjsample.todolist.controller;

import com.ltjsample.todolist.controller.dto.TaskAddInfo;
import com.ltjsample.todolist.controller.dto.TaskFinishInfo;
import com.ltjsample.todolist.domain.Task;
import com.ltjsample.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String add(@ModelAttribute TaskAddInfo taskAddInfo){
        taskService.addTask(taskAddInfo);
        return "redirect:/";
    }

    @PostMapping("/finish")
    public String finish(@ModelAttribute Task taskDTO){
        System.out.println(taskDTO.getId());
        taskService.finishTask(taskDTO);
        return "redirect:/";
    }

}
