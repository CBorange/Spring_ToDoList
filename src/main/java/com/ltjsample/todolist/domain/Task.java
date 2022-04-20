package com.ltjsample.todolist.domain;

// Task 정보 Domain
public class Task {
    // Task 고유 ID
    private Long id;

    // Task 정렬 번호
    private int no;

    // Task 설명
    private String explain;

    // Task 상태
    private String state;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
