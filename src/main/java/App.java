import ru.basanov.se.command.data.bin.DataBinaryClearCommand;
import ru.basanov.se.command.data.bin.DataBinaryLoadCommand;
import ru.basanov.se.command.data.bin.DataBinarySaveCommand;
import ru.basanov.se.command.data.json.DataJsonClearCommand;
import ru.basanov.se.command.data.json.DataJsonLoadCommand;
import ru.basanov.se.command.data.json.DataJsonSaveCommand;
import ru.basanov.se.command.data.xml.DataXmlClearCommand;
import ru.basanov.se.command.data.xml.DataXmlLoadCommand;
import ru.basanov.se.command.data.xml.DataXmlSaveCommand;
import ru.basanov.se.command.project.ProjectClearCommand;
import ru.basanov.se.command.project.ProjectCreateCommand;
import ru.basanov.se.command.project.ProjectListCommand;
import ru.basanov.se.command.project.ProjectRemoveCommand;
import ru.basanov.se.controller.Bootstrap;

public class App {

    private static final Class[] classes = {
        ProjectListCommand.class, ProjectClearCommand.class, ProjectCreateCommand.class, ProjectRemoveCommand.class,
            DataXmlSaveCommand.class, DataXmlClearCommand.class, DataXmlLoadCommand.class, DataJsonLoadCommand.class,
            DataJsonSaveCommand.class, DataJsonClearCommand.class, DataBinaryLoadCommand.class, DataBinarySaveCommand.class,
            DataBinaryClearCommand.class
    };

    public static void main(String[] args) throws Exception{
        final Bootstrap bootstrap = new Bootstrap();
        bootstrap.init(classes);
    }
}
