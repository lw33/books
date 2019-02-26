package lw.learning.springboot.exconfiguration.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * @Author lw
 * @Date 2019-02-20 18:45:42
 **/
@Validated
public class User {

    private Long id;
    @Value("${user.name}")
    private String name;

    @NotEmpty
    private String java;

    public User(Long id) {
        this.id = id;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
