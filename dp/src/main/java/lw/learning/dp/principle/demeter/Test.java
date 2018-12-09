package lw.learning.dp.principle.demeter;

/**
 * @Author lw
 * @Date 2018-12-08 22:27:49
 **/
public class Test {
    public static void main(String[] args) {
        Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();
        boss.commandCheckSum(teamLeader);
    }
}
