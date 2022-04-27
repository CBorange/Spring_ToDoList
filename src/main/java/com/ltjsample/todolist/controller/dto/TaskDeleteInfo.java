package com.ltjsample.todolist.controller.dto;

public class TaskDeleteInfo {
    private Long taskID;

    public TaskDeleteInfo(Long taskID){
        this.taskID = taskID;
    }

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }
}
