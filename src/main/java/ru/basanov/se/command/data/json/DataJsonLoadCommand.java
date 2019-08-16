package ru.basanov.se.command.data.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.basanov.se.command.AbstractCommand;
import ru.basanov.se.constant.DataConstant;
import ru.basanov.se.entity.Domain;
import ru.basanov.se.entity.Project;
import ru.basanov.se.entity.Task;
import sun.jvm.hotspot.utilities.ObjectReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;

public class DataJsonLoadCommand extends AbstractCommand {

    @Override
    public void execute() throws Exception {
        System.out.println("[DATA JSON LOAD]");
        final FileInputStream fileInputStream = new FileInputStream(DataConstant.FILE_JSON);
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
        return "data-json-load";
    }

    @Override
    public String description() {
        return "Save data to json file";
    }
}
