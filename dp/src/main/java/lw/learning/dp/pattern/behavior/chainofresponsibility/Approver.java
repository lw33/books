package lw.learning.dp.pattern.behavior.chainofresponsibility;

/**
 * @Author lw
 * @Date 2018-12-16 16:54:04
 **/
public abstract class Approver {

    protected Approver approver;

    public void setNext(Approver approver) {
        this.approver = approver;
    }

    public abstract void deploy(Course course);

}
