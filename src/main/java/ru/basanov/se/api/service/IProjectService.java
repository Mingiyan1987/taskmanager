package ru.basanov.se.api.service;

import ru.basanov.se.entity.Project;

import java.util.List;

public interface IProjectService {

    Project createProject(String name);

    Project merge(Project project);

    Project getProjectById(String id);

    void removeProjectById(String id);

    List<Project> getListProject();

    void clear();
}
