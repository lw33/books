package lw.learning.springinaction.chapter2;

import org.springframework.stereotype.Component;

/**
 * @Author lw
 * @Date 2019-01-15 20:43:40
 **/
@Component
public class SgtPeppers implements CompactDisc{

    private String title = "Sgt...";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("SgtPeppers.play");
    }

}
