package ru.basanov.se.service;

import ru.basanov.se.api.service.IDomainService;
import ru.basanov.se.controller.ServiceLocator;
import ru.basanov.se.entity.Domain;

public class DomainService implements IDomainService {

    private ServiceLocator serviceLocator;

    public DomainService(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public void load(final Domain domain) {
        if (domain == null) return;
        serviceLocator.getProjectService().load(domain.getProjects());
        serviceLocator.getTaskService().load(domain.getTasks());
    }

    @Override
    public void export(final Domain domain) {
        if (domain == null) return;
        domain.setProjects(serviceLocator.getProjectService().getListProject());
        domain.setTasks(serviceLocator.getTaskService().getListTask());
    }
}
