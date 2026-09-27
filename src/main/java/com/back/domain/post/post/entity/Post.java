package com.back.domain.post.post.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity // JPA entity임을 명시. 아래 구조대로 DB 테이블을 만들어야 한다.
@Getter
@Setter
//@ToString
@NoArgsConstructor
public class Post {
    @Id // PK
    @GeneratedValue(strategy = IDENTITY) // AUTO_INCREMENT. 기본 key 생성 전략
    private  int id; // INT

    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    public Post(String title, String content) {
        this.createDate = LocalDateTime.now();
        this.modifyDate = this.createDate;
        this.title = title;
        this.content = content;
    }

}
