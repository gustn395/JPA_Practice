package com.back.domain.post.post.service.PostService;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public long count() {
        return postRepository.count();
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    public void modify(Post post, String title, String content) {
        post.setTitle(title);
        post.setContent(content);

        postRepository.save(post);
        // UPDATE post SET title = ?, content = ?, modify_date = ? WHERE id = ?;
    }

    public Post write(String title, String content) {
        Post post = new Post(title, content);
        postRepository.save(post);

        return post;
    }
}
