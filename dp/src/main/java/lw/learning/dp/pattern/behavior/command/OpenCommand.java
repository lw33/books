package lw.learning.dp.pattern.behavior.command;

/**
 * @Author lw
 * @Date 2018-12-18 17:10:06
 **/
public class OpenCommand implements Command{

    private Door door;

    public OpenCommand(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.open();
    }
}
