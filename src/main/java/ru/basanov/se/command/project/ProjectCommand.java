package ru.basanov.se.command.project;

import ru.basanov.se.command.AbstractCommand;
import ru.basanov.se.entity.Project;

public class ProjectCommand extends AbstractCommand {

    @Override
    public void execute() throws Exception {
        System.out.println("[PROJECT LIST]");
        int index = 1;
        for (Project project : bootstrap.getProjectService().getListProject()) {
            System.out.println(index++ + ". " + project.getName());
        }
    }

    @Override
    public String command() {
        return "project-list";
    }

    @Override
    public String description() {
        return "SHow all projects";
    }
}
