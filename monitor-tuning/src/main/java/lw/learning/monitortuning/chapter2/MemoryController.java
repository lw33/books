package lw.learning.monitortuning.chapter2;

import lw.learning.monitortuning.Metaspace;
import lw.learning.monitortuning.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author lw
 * @Date 2018-12-24 17:13:22
 *
 * -XX:+HeapDumpOnOutOfMemoryError  -XX:HeapDumpPath=D:/
 *
 **/
@RestController
public class MemoryController {

    private List<User> userList = new ArrayList<>();
    private List<Class<?>> classList = new ArrayList<>();

    /**
     * -Xmx32M -Xms32M
     * @return
     */
    @GetMapping("/heap")
    public String heap() {
        long i = 0;
        while (true) {
            userList.add(new User(i++, UUID.randomUUID().toString()));
            System.out.println(i);
        }
    }

    /**
     * -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M
     * @return
     */
    @GetMapping("/noheap")
    public String noheap() {
        long i = 0;
        while (true) {
            List<Class<?>> classes = Metaspace.createClasses();
            classList.addAll(classes);
            System.out.println(i);
        }
    }

}
