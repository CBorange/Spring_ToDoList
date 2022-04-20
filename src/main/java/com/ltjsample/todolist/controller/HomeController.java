package com.ltjsample.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        // TODO
        // model에 service에서 todo task 얻어내어 삽입하는 로직 개발
        return "TodoListHome";
    }
}
