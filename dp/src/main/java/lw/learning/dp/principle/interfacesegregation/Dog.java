package lw.learning.dp.principle.interfacesegregation;

/**
 * @Author lw
 * @Date 2018-12-08 21:50:19
 **/
public class Dog implements ISwimAnimalAction, IEatAnimalAction{

    @Override
    public void eat() {
        System.out.println("Dog.eat");
    }

    @Override
    public void swim() {
        System.out.println("Dog.swim");
    }
}
