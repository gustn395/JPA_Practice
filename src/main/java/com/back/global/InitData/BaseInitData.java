package com.back.global.InitData;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class BaseInitData {
    @Autowired
    private PostRepository postRepository;

    @Bean
    ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {
            work1();
            work2();
        };
    }

    // 생성 logic
    void work1(){
        // 게시글이 이미 있는지 확인. 하나라도 있으면 여기서 종료
        if (postRepository.count() > 0) return;

        Post post1 = postRepository.save(new Post("제목 1", "내용 1"));
        Post post2 = postRepository.save(new Post("제목 2", "내용 2"));

        System.out.println("기본 게시글 2개를 생성했습니다");
    };

    // 조회 logic
    void work2(){
        // SELECT * FROM post WHERE id = 1;
        Optional<Post> opPost1 = postRepository.findById(1);
    };
}
