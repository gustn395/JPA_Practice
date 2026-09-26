package com.back.domain.post.post.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity // JPA entity임을 명시. 아래 구조대로 DB 테이블을 만들어야 한다.
@Getter
@Setter
@RequiredArgsConstructor
//@ToString
public class Post {
    @Id // PK
    @GeneratedValue(strategy = IDENTITY) // AUTO_INCREMENT. 기본 key 생성 전략
    private int id; // INT

    private final String title;

    @Column(columnDefinition = "TEXT")
    private final String content;

    // BaseInitData의 postRepository.findById(1); 때문에 생성자 필요
    public Post() {
        this.title = "";
        this.content = "";
    }
}
