package lw.learning.jmx.s2;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @Author lw
 * @Date 2018-12-06 15:46:00
 **/
public class PersonAgent {

    public static void main(String[] args) throws Exception{

        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName mBeanInfo = new ObjectName("lw.learning:name=PersonAgent");
        mBeanServer.registerMBean(new Person(), mBeanInfo);
        System.in.read();
    }
}
