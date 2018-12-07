package lw.learning.jmx.s1;

/**
 * @Author lw
 * @Date 2018-12-06 14:47:49
 **/
public class Monitor implements MonitorMBean{

    @Override
    public int getOnlineSum() {
        return (int) (Math.random() * 100);
    }

    @Override
    public String getMemoInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("free: ").append(String.format("%.2f",(double)Runtime.getRuntime().freeMemory()/1024/1024) + "M")
                .append(" total: ").append((double)Runtime.getRuntime().totalMemory()/1024/1024 + "M");
        return sb.toString();
    }

    @Override
    public void execScrpit() {
        System.out.println("Monitor.execScrpit");
    }

    @Override
    public void shutdown() {
        System.out.println("Monitor.shutdown");
    }
}
