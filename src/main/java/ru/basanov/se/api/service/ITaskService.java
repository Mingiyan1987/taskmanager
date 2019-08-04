package ru.basanov.se.api.service;

import ru.basanov.se.entity.Task;

import java.util.List;

public interface ITaskService {

    Task createTask(String name);

    Task merge(Task task);

    Task getTaskById(String id);

    void removeTaskById(String id);

    List<Task> getListTask();

    void clear();
}
