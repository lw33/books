package lw.learning.dp.pattern.behavior.command;

/**
 * @Author lw
 * @Date 2018-12-18 17:10:14
 **/
public class CloseCommand implements Command{

    private Door door;

    public CloseCommand(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.close();
    }
}
