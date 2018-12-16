package lw.learning.dp.pattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lw
 * @Date 2018-12-16 15:31:49
 **/
public class EmployeeFactory {

    private static final Map<String, Employee> EMPLOYEE_MAP = new HashMap<>();

    public static Employee getManager(String department) {
        Manager manager = (Manager) EMPLOYEE_MAP.get(department);
        if (manager == null) {
            manager = new Manager(department);
            manager.setReportContent(" report...");
            EMPLOYEE_MAP.put(department, manager);
            System.out.println("create manager " + department);
        }
        return manager;
    }
}
