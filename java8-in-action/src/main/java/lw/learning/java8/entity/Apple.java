package lw.learning.java8.entity;

/**
 * @Author lw
 * @Date 2018-12-27 17:58:07
 **/
public class Apple {
    private int weight = 0;
    private String color = "";

    public Apple() {
    }

    public Apple(String color) {
        this.color = color;
    }

    public Apple(int weight, String color){
        this.weight = weight;
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
