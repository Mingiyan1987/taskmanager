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
    public void init(Class classes[]) {
        // считываем команды по по command и записываем в commands
        //
        for (int i = 0; i < classes.length; i++) {
            System.out.println(classes[i].getSimpleName());
            try {
                commands.put(classes[i].getSimpleName(), (AbstractCommand) classes[i].newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        Iterator<Map.Entry<String, AbstractCommand>> iterator = commands.entrySet().iterator();
        boolean exit = true;
        String com = null;
        while (exit) {
            System.out.println("ENTER COMMAND:");
            com = scanner.next();
            while (iterator.hasNext()) {
                Map.Entry<String, AbstractCommand> entry = iterator.next();
                if (com.equals(entry.getValue().command())) {
                    try {
                        entry.getValue().execute();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
