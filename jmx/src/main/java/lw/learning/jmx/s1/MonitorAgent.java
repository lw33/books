package lw.learning.jmx.s1;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * @Author lw
 * @Date 2018-12-06 14:50:20
 **/
public class MonitorAgent {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName mbInfo = new ObjectName("lw.learning.jmx.s1:name=Fan");
        mbs.registerMBean(new Monitor(), mbInfo);
        Thread.sleep(Integer.MAX_VALUE);
    }
}
