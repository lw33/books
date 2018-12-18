package lw.learning.dp.pattern.behavior.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-18 17:11:52
 **/
public class Staff {

    private List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void executeCommands() {
        for (Command command : commandList) {
            command.execute();
        }
        commandList.clear();
    }
}
