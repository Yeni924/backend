package com.mococo.api.post.controller.response;

import com.mococo.core.post.domain.entity.Post;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostCreateResponse {

    private Long id;
    public static PostCreateResponse from(Post post) {
        PostCreateResponse response = new PostCreateResponse();
        response.id = post.getId();
        return response;
    }

}
