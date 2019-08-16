package ru.basanov.se.command.data.bin;

import ru.basanov.se.command.AbstractCommand;

import java.io.BufferedOutputStream;

public class DataBinaryClearCommand extends AbstractCommand {

    @Override
    public void execute() throws Exception {
        System.out.println("[DATA BINARY CLEAR]");
        bootstrap.getProjectService().clear();
        bootstrap.getProjectService().clear();
    }

    @Override
    public String command() {
        return "data-binary-clear";
    }

    @Override
    public String description() {
        return "Clear data to binary";
    }
}
