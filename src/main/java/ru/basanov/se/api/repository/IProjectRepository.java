package ru.basanov.se.api.repository;

import ru.basanov.se.entity.Project;

import java.util.Collection;
import java.util.List;

public interface IProjectRepository {

    Project createProject(String name);

    Project merge(Project project);

    void merge(Collection<Project> projects);

    void merge(Project... projects);

    void load(Collection<Project> projects);

    void load(Project... projects);

    Project getProjectById(String id);

    void removeProjectById(String id);

    List<Project> getListProject();

    void clear();
}
