package ru.basanov.se.command.data.bin;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;
import ru.basanov.se.command.AbstractCommand;
import ru.basanov.se.constant.DataConstant;
import ru.basanov.se.entity.Project;
import ru.basanov.se.entity.Task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

public class DataBinarySaveCommand extends AbstractCommand {

    @Override
    public void execute() throws Exception {
        System.out.println("[DATA BINARY SAVE]");
        final Project[] projects = bootstrap.getProjectService().getListProject().toArray(new Project[]{});
        final Task[] tasks = bootstrap.getTaskService().getListTask().toArray(new Task[]{});
        final File file = new File(DataConstant.FILE_BINARY);
        Files.deleteIfExists(file.toPath());
        Files.createFile(file.toPath());

        final FileOutputStream fileOutputStream = new FileOutputStream(file);
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(projects);
        objectOutputStream.writeObject(tasks);
        fileOutputStream.close();

        System.out.println("[OK]");
        System.out.println();

    }


    @Override
    public String command() {
        return null;
    }

    @Override
    public String description() {
        return null;
    }
}
