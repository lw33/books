package lw.learning.springboot.autoconfigure.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/** {@link CalculateService}
 * @Author lw
 * @Date 2019-02-16 10:42:27
 **/
@Service
@Profile("java7")
public class Java7CalculateService implements CalculateService{


    @Override
    public Integer sum(Integer... values) {
        System.out.println("Java7CalculateService.sum");
        int sum = 0;
        for (Integer value : values) {
            sum += value;
        }
        return sum;
    }
}
