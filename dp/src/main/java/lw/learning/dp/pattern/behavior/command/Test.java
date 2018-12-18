package lw.learning.dp.pattern.behavior.command;

/**
 * @Author lw
 * @Date 2018-12-18 17:14:43
 **/
public class Test {

    public static void main(String[] args) {
        Door door = new Door();
        OpenCommand openCommand = new OpenCommand(door);
        CloseCommand closeCommand = new CloseCommand(door);
        Staff staff = new Staff();
        staff.addCommand(openCommand);
        staff.addCommand(closeCommand);
        staff.executeCommands();
    }
}
