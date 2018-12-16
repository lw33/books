package lw.learning.dp.pattern.behavior.chainofresponsibility;

/**
 * @Author lw
 * @Date 2018-12-16 16:59:12
 **/
public class Test {

    public static void main(String[] args) {

        Approver articleApprover = new ArticleApprover();
        Approver videoApprover = new VideoApprover();
        Course course = new Course("ds", "", "ds & algorithm");
        articleApprover.setNext(videoApprover);
        articleApprover.deploy(course);
    }
}
