package lw.learning.dp.principle.singleresponsibility;

/**
 * @Author lw
 * @Date 2018-12-07 22:42:27
 **/
public class Test {

    public static void main(String[] args) {

        FlyBird flyBird = new FlyBird();
        flyBird.move("java");
        WalkBird walkBird = new WalkBird();
        walkBird.move("python");

    }
}
