package com.ltjsample.todolist.controller.dto;

public class TaskFinishInfo {
    private Long taskID;

    public TaskFinishInfo(Long taskID){
        this.taskID = taskID;
    }

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }
}
