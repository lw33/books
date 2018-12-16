package lw.learning.dp.pattern.behavior.templatemethod;

/**
 * @Author lw
 * @Date 2018-12-16 20:27:09
 **/
public abstract class ACourse {

    public final void makeCourse() {
        makePPT();
        makePPT();
        if (needWriteArticle()) {
            writeArticle();
        }
        packageCourse();
    }

    final void makePPT() {
        System.out.println("ACourse.makePPT");
    }

    final void makeVideo() {
        System.out.println("ACourse.makeVideo");
    }

    final void writeArticle() {
        System.out.println("ACourse.writeArticle");
    }

    protected boolean needWriteArticle() {
        return false;
    }

    abstract void packageCourse();
}
