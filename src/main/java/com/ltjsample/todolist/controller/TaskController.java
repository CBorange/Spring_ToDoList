package com.ltjsample.todolist.controller;

import com.ltjsample.todolist.controller.dto.TaskAddInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    @PostMapping("/add")
    public String add(@ModelAttribute TaskAddInfo taskAddInfo){
        // TODO
        // service에 접근하여 신규 task 등록하는 로직 개발
        System.out.println(taskAddInfo.getTaskExplain());
        return "redirect:/";
    }

}
