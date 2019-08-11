package ru.basanov.se.controller;

import ru.basanov.se.api.repository.IProjectRepository;
import ru.basanov.se.api.repository.ITaskRepository;
import ru.basanov.se.api.service.IDomainService;
import ru.basanov.se.api.service.IProjectService;
import ru.basanov.se.api.service.ITaskService;
import ru.basanov.se.command.AbstractCommand;
import ru.basanov.se.repository.ProjectRepository;
import ru.basanov.se.repository.TaskRepository;
import ru.basanov.se.service.DomainService;
import ru.basanov.se.service.ProjectService;
import ru.basanov.se.service.TaskService;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public final class Bootstrap implements ServiceLocator {

    private final ITaskRepository taskRepository = new TaskRepository();

    private final IProjectRepository projectRepository = new ProjectRepository();

    private final IProjectService projectService = new ProjectService(projectRepository);

    private final ITaskService taskService = new TaskService(taskRepository);

    private final IDomainService domainService = new DomainService(this);

    private final Map<String, AbstractCommand> commands = new LinkedHashMap<>();

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

    public IDomainService getDomainService() {
        return domainService;
    }

    @Override
    public void init(Class[] classes) {
        boolean exit = false;
        String command;
        while (exit) {
            System.out.println("Введите команду:");

            command = scanner.next();

            
        }
    }
}
