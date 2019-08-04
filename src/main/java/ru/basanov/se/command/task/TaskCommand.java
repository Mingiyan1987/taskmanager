package ru.basanov.se.command.task;

import ru.basanov.se.command.AbstractCommand;
import ru.basanov.se.entity.Task;

public class TaskCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[TASK LIST]");
        int index = 1;
        for (Task task : bootstrap.getTaskService().getListTask()) {
            System.out.println(index++ + ". " + task.getName());
        }
        System.out.println();
    }

    @Override
    public String command() {
        return "task-list";
    }

    @Override
    public String description() {
        return "Show all tasks";
    }
}
