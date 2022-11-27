package com.mococo.core.post.domain.service;


import com.mococo.core.post.domain.entity.Post;
import com.mococo.core.post.domain.repository.PostRepository;
import com.mococo.core.post.dto.PostSaveCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor

public class PostCommandService {
        private final PostRepository postRepository;

        public Optional<Post> get(Long postId){
            return postRepository.findById(postId);
        }

        public List<Post> gets(Pageable pageable){
            return postRepository.findWithPagination(pageable);
        }
        public Post create(PostSaveCommand command){
            Post post = Post.create(command);
            return postRepository.save(post);
        }
}

