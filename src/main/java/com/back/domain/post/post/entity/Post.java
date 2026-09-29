package com.back.domain.post.post.entity;

import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // JPA entity임을 명시. 아래 구조대로 DB 테이블을 만들어야 한다.
@Getter
@Setter
//@ToString
@NoArgsConstructor
public class Post extends BaseEntity {
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
