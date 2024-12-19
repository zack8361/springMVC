package spring.copany.study.MVC.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {

    private Long id;
    private String username;
    private int age;

    public Member(Long id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }
    public Member( String username, int age) {
        this.username = username;
        this.age = age;
    }
    public Member() {

    }
}
