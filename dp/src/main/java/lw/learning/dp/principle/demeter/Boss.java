package lw.learning.dp.principle.demeter;


/**
 * @Author lw
 * @Date 2018-12-08 22:24:39
 **/
public class Boss {

    public void commandCheckSum(TeamLeader teamLeader) {
        teamLeader.check();
    }
}
