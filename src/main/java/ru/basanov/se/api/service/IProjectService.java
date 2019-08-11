package ru.basanov.se.api.service;

import ru.basanov.se.entity.Project;
import ru.basanov.se.entity.Task;

import java.util.List;

public interface IProjectService {

    Project createProject(String name);

    Project merge(Project project);

    Project getProjectById(String id);

    void removeProjectById(String id);

    List<Project> getListProject();

    void clear();

    List<Task> getListTask();

    void load(Project[] projects);

    void load(List<Project> projects);
}
