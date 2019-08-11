import ru.basanov.se.command.project.ProjectClearCommand;
import ru.basanov.se.command.project.ProjectCreateCommand;
import ru.basanov.se.command.project.ProjectListCommand;
import ru.basanov.se.command.project.ProjectRemoveCommand;
import ru.basanov.se.controller.Bootstrap;

public class App {

    private static final Class[] classes = {
        ProjectListCommand.class, ProjectClearCommand.class, ProjectCreateCommand.class, ProjectRemoveCommand.class
    };

    public static void main(String[] args) throws Exception{
        final Bootstrap bootstrap = new Bootstrap();
        bootstrap.init(classes);
    }
}
