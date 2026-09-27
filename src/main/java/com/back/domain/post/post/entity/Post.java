package com.back.domain.post.post.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity // JPA entity임을 명시. 아래 구조대로 DB 테이블을 만들어야 한다.
@Getter
@Setter
//@ToString
public class Post {
    @Id // PK
    @GeneratedValue(strategy = IDENTITY) // AUTO_INCREMENT. 기본 key 생성 전략
    private final int id; // INT

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    public Post(String title, String content) {
        this.id = 0;
        this.title = title;
        this.content = content;
    }

    // this("", "")가 위(같은 class)의 Post(String title, String content)을 호출
    // -> id가 초기화 된다.
    public Post() {
        this("", "");
    }

//    id가 final인데 초기화되지 않아서 사용할 수 없음
//    public Post() {
//        this.title = "";
//        this.content = "";
//    }

//    이건 id가 초기화되기 때문에 가능함
//    public Post() {
//        this.id = 0;
//        this.title = "";
//        this.content = "";
//    }
}
