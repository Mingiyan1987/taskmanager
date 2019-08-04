package ru.basanov.se.api.repository;

import ru.basanov.se.entity.Task;

import java.util.Collection;
import java.util.List;

public interface ITaskRepository {

    Task createTask(String name);

    Task merge(Task task);

    void merge(Collection<Task> tasks);

    void merge(Task... tasks);

    void load(Collection<Task> tasks);

    void load(Task... tasks);

    Task getTaskById(String id);

    void removeTaskById(String id);

    List<Task> getListTask();

    void clear();
}
