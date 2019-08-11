package ru.basanov.se.command.project;

import ru.basanov.se.command.AbstractCommand;

public class ProjectClearCommand extends AbstractCommand {

    @Override
    public void execute() throws Exception {
        System.out.println("[PROJECT CLEAR COMMAND]");
        bootstrap.getProjectService().clear();

    }

    @Override
    public String command() {
        return "project-clear";
    }

    @Override
    public String description() {
        return "Clear all projects";
    }
}
