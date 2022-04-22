package com.ltjsample.todolist.controller.dto;

public class TaskAddInfo {
    private String taskExplain;

    public TaskAddInfo(String taskExplain) {
        this.taskExplain = taskExplain;
    }

    public String getTaskExplain() {
        return taskExplain;
    }

    public void setTaskExplain(String taskExplain) {
        this.taskExplain = taskExplain;
    }
}
