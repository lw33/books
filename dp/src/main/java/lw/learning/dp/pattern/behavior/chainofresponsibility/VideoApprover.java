package lw.learning.dp.pattern.behavior.chainofresponsibility;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author lw
 * @Date 2018-12-16 16:57:44
 **/
public class VideoApprover extends Approver{
    @Override
    public void deploy(Course course) {
        if (StringUtils.isNotEmpty(course.getVideo())) {
            System.out.println(course.getVideo() + " pass..");
            if (approver != null) {
                approver.deploy(course);
            }
        } else {
            System.out.println("video fail...");
        }
    }
}
