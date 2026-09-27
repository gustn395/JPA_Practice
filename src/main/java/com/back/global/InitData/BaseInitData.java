package com.back.global.InitData;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.service.PostService.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

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
    // 작업을 수행하다가 실패할 경우, 일부 데이터만 남아있는 찌꺼기를 방지하고 이전 상태로 깔끔하게 Rollback되도록 보호해준다
    @Transactional
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
    // 데이터 수정/생성 없이 조회(SELECT)만 발생하는 메서드에는 readOnly = true 옵션을 붙인다
    // -> 성능을 최적화하고 읽기 전용 DB 서버로 분기시킬 수 있다
    @Transactional(readOnly = true)
    void work2(){
        // SELECT * FROM post WHERE id = 1;
        Optional<Post> opPost1 = postService.findById(1);

        // opPost1.get() : 실제 Post 객체를 반환
        Post post1 = opPost1.get();

        System.out.println("post1 : " + post1);
    };
}
