package lw.learning.dp.pattern.structural.facade;

/**
 * @Author lw
 * @Date 2018-12-15 22:34:54
 **/
public class QualifyService {

    public boolean isAvaliable(PointGift pointGift) {
        System.out.println("check " + pointGift.getName());
        return true;
    }
}
