package ru.basanov.se.command.data.xml;

import ru.basanov.se.command.AbstractCommand;

public class DataXmlClearCommand extends AbstractCommand {
    @Override
    public void execute() throws Exception {
        System.out.println("[DATA XML CLEAR]");
        bootstrap.getProjectService().clear();
        bootstrap.getTaskService().clear();
    }

    @Override
    public String command() {
        return "data-xml-clear";
    }

    @Override
    public String description() {
        return "Clear data to xml";
    }
}
