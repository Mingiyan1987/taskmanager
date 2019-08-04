package ru.basanov.se.service;

import ru.basanov.se.api.repository.ITaskRepository;
import ru.basanov.se.entity.Task;

import java.util.List;

public final class TaskService implements ru.basanov.se.api.service.ITaskService {

    private final ITaskRepository taskRepository;

    public TaskService(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(final String name) {
        if (name == null || name.isEmpty()) return null;
        return taskRepository.createTask(name);
    }

    @Override
    public Task merge(final Task task) {
        return taskRepository.merge(task);
    }

    @Override
    public Task getTaskById(final String id) {
        return taskRepository.getTaskById(id);
    }

    @Override
    public void removeTaskById(final String id) {
        taskRepository.removeTaskById(id);
    }

    @Override
    public List<Task> getListTask() {
        return taskRepository.getListTask();
    }

    @Override
    public void clear() {
        taskRepository.clear();
    }
}
