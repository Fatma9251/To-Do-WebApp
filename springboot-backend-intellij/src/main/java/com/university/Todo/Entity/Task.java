package com.university.Todo.Entity;
// database table(entity): Task

import javax.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
     private String description;
    @Enumerated(EnumType.STRING)
     private Status status;
     public Task(){
     }

    public Task(long id, String description, Status status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
