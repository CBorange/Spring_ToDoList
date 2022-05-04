package com.ltjsample.todolist;

import com.ltjsample.todolist.repository.JdbcTemplateTaskRepository;
import com.ltjsample.todolist.repository.MemoryTaskRepository;
import com.ltjsample.todolist.repository.TaskRepository;
import com.ltjsample.todolist.service.TaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.swing.*;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public TaskService taskService(){
        return new TaskService(taskRepository());
    }

    @Bean
    public TaskRepository taskRepository(){
        //return new MemoryTaskRepository();
        return new JdbcTemplateTaskRepository(dataSource);
    }
}
