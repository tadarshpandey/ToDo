package com.todo.start.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id; 

@Entity
public class TodoModel {
    @Id
    private String id;
    private String content;

    // Constructor
    public TodoModel(String id, String content) {
        this.id = id;
        this.content = content;
    }

    // Default constructor
    public TodoModel(){
        this.id = null;
        this.content = null;
    }
    // Getters to get : id
    public String getId() {
        return id;
    }
    // Setters to set : id
    public void setId(String id) {
        this.id = id;
    }
    // Getters to get : content
    public String getContent() {
        return content;
    }
    // Setters to set : content
    public void setContent(String content) {
        this.content = content;
    }
}


/*
 * we have to give @Entity annotation to make this class as entity class
 * we have to give @Id annotation to the primary key field
 * JSP: java server pages
 * or JSP: jakarta servelet pages
 * JPA: java persistence api
 * Hibernate: JPA implementation
 */