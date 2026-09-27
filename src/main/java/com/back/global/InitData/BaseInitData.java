package com.back.global.InitData;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.service.PostService.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {
    private final PostService postService;

    private int callCount = 0;

    @Bean
    ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {
            work1();
            work2();

            callCount++;
        };
    }

    // 생성 logic
    void work1(){
        // 게시글이 이미 있는지 확인. 하나라도 있으면 여기서 종료
        if (postService.count() > 0) return;

        Post post1 = new Post("제목 1", "내용 1");
        postService.save(post1);
        Post post2 = postService.save(new Post("제목 1", "내용 2"));

        System.out.println(post1.getId());
        System.out.println(post2.getId());

        System.out.println("기본 게시글 2개를 생성했습니다");
    };

    // 조회 logic
    void work2(){
        // SELECT * FROM post WHERE id = 1;
        Optional<Post> opPost1 = postService.findById(1);

        // opPost1.get() : 실제 Post 객체를 반환
        Post post1 = opPost1.get();

        // 출력값 :
        // com.back.domain.post.post.entity.Post @ 64ccfc68
        // └─ 패키지를 포함한 클래스 이름           └─ 해시 코드의 16진수 표현
        System.out.println("post1 : " + post1);
    };
}
