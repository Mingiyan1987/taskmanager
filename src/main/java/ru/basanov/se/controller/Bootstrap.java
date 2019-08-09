package ru.basanov.se.controller;

import ru.basanov.se.api.repository.IProjectRepository;
import ru.basanov.se.api.repository.ITaskRepository;
import ru.basanov.se.api.service.IProjectService;
import ru.basanov.se.api.service.ITaskService;
import ru.basanov.se.repository.ProjectRepository;
import ru.basanov.se.repository.TaskRepository;
import ru.basanov.se.service.ProjectService;
import ru.basanov.se.service.TaskService;

import java.util.Scanner;

public final class Bootstrap implements ServiceLocator {

    private final ITaskRepository taskRepository = new TaskRepository();

    private final IProjectRepository projectRepository = new ProjectRepository();

    private final IProjectService projectService = new ProjectService(projectRepository);

    private final ITaskService taskService = new TaskService(taskRepository);

    private final Scanner scanner = new Scanner(System.in);

    public ITaskRepository getTaskRepository() {
        return taskRepository;
    }

    public IProjectRepository getProjectRepository() {
        return projectRepository;
    }

    public IProjectService getProjectService() {
        return projectService;
    }

    public ITaskService getTaskService() {
        return taskService;
    }

    @Override
    public void init() {
        System.out.println("Введите команду:");
        String command = scanner.next();
    }
}
