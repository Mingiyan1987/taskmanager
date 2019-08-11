package ru.basanov.se.controller;

import ru.basanov.se.api.service.IProjectService;
import ru.basanov.se.api.service.ITaskService;

public interface ServiceLocator {

    void init(Class[] classes);

    IProjectService getProjectService();

    ITaskService getTaskService();
}
