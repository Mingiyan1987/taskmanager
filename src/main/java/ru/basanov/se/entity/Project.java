package ru.basanov.se.entity;

import java.util.HashSet;
import java.util.Set;

public class Project {

    private String id;
    private String name;
    private String description;
    private Set<Task> tasks = new HashSet<Task>();

    public Project() {
    }

    public Project(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
