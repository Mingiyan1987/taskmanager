package ru.basanov.se.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class Domain {

    private List<Project> projects = new ArrayList<>();

    private List<Task> tasks = new ArrayList<>();

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
