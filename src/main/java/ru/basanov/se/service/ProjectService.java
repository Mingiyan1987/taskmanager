package ru.basanov.se.service;

import ru.basanov.se.api.repository.IProjectRepository;
import ru.basanov.se.entity.Project;
import ru.basanov.se.entity.Task;

import java.util.List;

public final class ProjectService implements ru.basanov.se.api.service.IProjectService {

    private final IProjectRepository projectRepository;

    public ProjectService(final IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project createProject(final String name) {
        if (name == null || name.isEmpty()) return null;
        return projectRepository.createProject(name);
    }

    @Override
    public Project merge(final Project project) {
        return projectRepository.merge(project);
    }


    @Override
    public Project getProjectById(final String id) {
        return projectRepository.getProjectById(id);
    }

    @Override
    public void removeProjectById(final String id) {
        projectRepository.removeProjectById(id);
    }

    @Override
    public List<Project> getListProject() {
        return projectRepository.getListProject();
    }

    @Override
    public void clear() {
        projectRepository.clear();
    }

    @Override
    public List<Task> getListTask() {
        return projectRepository.getListTask();
    }

    @Override
    public void load(Project[] projects) {
        projectRepository.merge(projects);
    }

    @Override
    public void load(List<Project> projects) {
        projectRepository.merge(projects);
    }
}
