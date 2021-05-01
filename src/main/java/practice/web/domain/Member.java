package practice.web.domain;

import javax.persistence.*;

@Entity //실제 DB의 테이블과 1:1로 매핑되는 클래스
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB가 알아서 생성해주는 전략
    private Long id;
    private String name;

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
