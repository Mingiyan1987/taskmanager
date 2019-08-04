package ru.basanov.se.repository;

import ru.basanov.se.entity.Project;

import java.util.*;

public class ProjectRepository implements ru.basanov.se.api.repository.IProjectRepository {

    private final Map<String, Project> map = new LinkedHashMap<String, Project>();

    public Project createProject(final String name) {
        final Project project = new Project();
        project.setName(name);
        merge(project);
        return project;
    }

    public Project merge(final Project project) {
        if (project == null) return null;
        map.put(project.getId(), project);
        return project;
    }

    public void merge(final Collection<Project> projects) {
        if (projects == null) return;
        for (final Project project: projects) merge(project);
    }

    public void merge(final Project... projects) {
        if (projects == null) return;
        for (final Project project: projects) merge(project);
    }

    public void load(final Collection<Project> projects) {
        clear();
        merge(projects);
    }

    public void load(final Project... projects) {
        clear();
        merge(projects);
    }

    public Project getProjectById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return map.get(id);
    }

    public void removeProjectById(final String id) {
        if (id == null || id.isEmpty()) return;
        map.remove(id);
    }

    public List<Project> getListProject() {
        return new ArrayList<>(map.values());
    }

    public void clear() {
        map.clear();
    }
}
