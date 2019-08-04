package ru.basanov.se.command;

import ru.basanov.se.controller.Bootstrap;

public abstract class AbstractCommand {

    protected Bootstrap bootstrap;

    public Bootstrap getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    public abstract void execute() throws Exception;

    public abstract String command();

    public abstract String description();
}
