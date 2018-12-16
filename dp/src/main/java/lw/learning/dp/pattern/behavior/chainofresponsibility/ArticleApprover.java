package lw.learning.dp.pattern.behavior.chainofresponsibility;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author lw
 * @Date 2018-12-16 16:55:49
 **/
public class ArticleApprover extends Approver{

    @Override
    public void deploy(Course course) {
        if (StringUtils.isNotEmpty(course.getArticle())) {
            System.out.println(course.getArticle() + " pass...");
            if (approver != null) {
                approver.deploy(course);
            }
        } else {
            System.out.println("fail...");
        }
    }
}
