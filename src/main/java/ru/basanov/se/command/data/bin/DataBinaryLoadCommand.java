package ru.basanov.se.command.data.bin;

import ru.basanov.se.command.AbstractCommand;
import ru.basanov.se.constant.DataConstant;
import ru.basanov.se.entity.Project;
import ru.basanov.se.entity.Task;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DataBinaryLoadCommand extends AbstractCommand {

    @Override
    public void execute() throws Exception {
        System.out.println("[DATA BINARY LOAD]");
        final FileInputStream fileInputStream = new FileInputStream(DataConstant.FILE_BINARY);
        final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        loadProjects(objectInputStream.readObject());
        loadTasks(objectInputStream.readObject());
        objectInputStream.close();
        fileInputStream.close();
        System.out.println("[OK]");
    }

    private void loadTasks(final Object value) {
        if (!(value instanceof Task[])) return;
        final Task[] tasks = (Task[]) value;
        bootstrap.getTaskService().load(tasks);
    }

    private void loadProjects(final Object value) {
        if(!(value instanceof Project[])) return;
        final Project[] projects = (Project[]) value;
        bootstrap.getProjectService().load(projects);
    }

    @Override
    public String command() {
        return "data-bin-load";
    }

    @Override
    public String description() {
        return "Save data to binary file.";
    }
}
