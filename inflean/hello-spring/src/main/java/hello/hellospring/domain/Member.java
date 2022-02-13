package hello.hellospring.domain;

public class Member {

    private Long id; // 시스템이 데이터를 구분하기위해 저장하는 id
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
