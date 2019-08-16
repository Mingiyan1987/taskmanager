package ru.basanov.se.command.data.json;

import ru.basanov.se.command.AbstractCommand;

public class DataJsonClearCommand extends AbstractCommand {

    @Override
    public void execute() throws Exception {
        System.out.println("[DATA JSON CLEAR]");
        bootstrap.getProjectService().clear();
        bootstrap.getTaskService().clear();
    }

    @Override
    public String command() {
        return "data-json-clear";
    }

    @Override
    public String description() {
        return "Clear data to json";
    }
}
