package ru.basanov.se.command.data.xml;

import ru.basanov.se.command.AbstractCommand;
import ru.basanov.se.constant.DataConstant;
import ru.basanov.se.entity.Project;
import ru.basanov.se.entity.Task;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DataXmlLoadCommand extends AbstractCommand {

    @Override
    public void execute() throws Exception {
        System.out.println("[DATA XML LOAD]");
        final FileInputStream fileInputStream = new FileInputStream(DataConstant.FILE_XML);
        final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        loadProjects(objectInputStream);
        loadTasks(objectInputStream);
    }

    private void loadTasks(final Object value) {
        if (!(value instanceof Task[])) return;
        final Task[] tasks = (Task[]) value;
        bootstrap.getTaskService().load(tasks);
    }

    private void loadProjects(final Object value) {
        if (!(value instanceof Project[])) return;
        final Project[] projects = (Project[]) value;
        bootstrap.getProjectService().load(projects);
    }

    @Override
    public String command() {
        return "data-xml-load";
    }

    @Override
    public String description() {
        return "Save data to xml load";
    }
}
