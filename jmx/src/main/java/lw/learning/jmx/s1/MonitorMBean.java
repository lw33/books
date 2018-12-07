package lw.learning.jmx.s1;

/**
 * @Author lw
 * @Date 2018-12-06 14:45:51
 **/
public interface MonitorMBean {

    int getOnlineSum();

    String getMemoInfo();

    void execScrpit();

    void shutdown();
}
