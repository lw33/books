package lw.learning.dp.pattern.behavior.templatemethod;

/**
 * @Author lw
 * @Date 2018-12-16 20:33:17
 **/
public class DSCourse extends ACourse{
    @Override
    void packageCourse() {
        System.out.println("DSCourse.packageCourse");
    }

    @Override
    protected boolean needWriteArticle() {
        return true;
    }
}
