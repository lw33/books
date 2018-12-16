package lw.learning.dp.pattern.structural.flyweight;

/**
 * @Author lw
 * @Date 2018-12-16 15:30:35
 **/
public class Manager implements Employee{

    private String department;
    private String reportContent;

    public Manager(String department) {
        this.department = department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    @Override
    public void report() {
        System.out.println(department + " " + reportContent);
    }
}
