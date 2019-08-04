package ru.basanov.se.repository;

import ru.basanov.se.api.repository.ITaskRepository;
import ru.basanov.se.entity.Task;

import java.util.*;

public class TaskRepository implements ITaskRepository {

    private final Map<String, Task> map = new LinkedHashMap<>();

    @Override
    public Task createTask(final String name) {
        final Task task = new Task();
        task.setName(name);
        merge(task);
        return task;
    }

    @Override
    public Task merge(final Task task) {
        if (task == null) return null;
        map.put(task.getId(), task);
        return task;
    }

    @Override
    public void merge(final Collection<Task> tasks) {
        if (tasks == null) return;
        for (final Task task: tasks) merge(task);
    }

    @Override
    public void merge(final Task... tasks) {
        if (tasks == null) return;
        for (final Task task: tasks) merge(task);
    }

    @Override
    public void load(final Collection<Task> tasks) {
        clear();
        merge(tasks);
    }

    @Override
    public void load(final Task... tasks) {
        clear();
        merge(tasks);
    }

    @Override
    public Task getTaskById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return map.get(id);
    }

    @Override
    public void removeTaskById(String id) {
        if (id == null || id.isEmpty()) return;
        map.remove(id);
    }

    @Override
    public List<Task> getListTask() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void clear() {
        map.clear();
    }
}
