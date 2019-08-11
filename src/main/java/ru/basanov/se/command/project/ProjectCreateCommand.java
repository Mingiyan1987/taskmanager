package ru.basanov.se.command.project;

import ru.basanov.se.command.AbstractCommand;

public class ProjectCreateCommand extends AbstractCommand {

    @Override
    public void execute() throws Exception {
        System.out.println("PROJECT CREATE");
        System.out.println("ENTER NAME");
    }

    @Override
    public String command() {
        return "[project-create]";
    }

    @Override
    public String description() {
        return "PROJECT CREATE";
    }
}
