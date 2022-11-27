package com.mococo.api.post.controller.response;

import com.mococo.core.post.domain.entity.Post;
import com.mococo.core.common.Tag;

import java.time.LocalDateTime;
import java.util.List;

public class PostGetsDetailResponse {
    private List<Tag> tags;
    private String title;
    private String content;
    private double latitude;
    private double longitude;
    private LocalDateTime postAt;

    public static PostGetsDetailResponse from(Post post) {
        PostGetsDetailResponse response = new PostGetsDetailResponse();

        response.title = post.getTitle();
        response.content = post.getContent();
        response.latitude = post.getLatitude();
        response.longitude = post.getLongitude();
        response.tags = post.getTags();
        response.postAt = post.getPostAt();

        return response;
    }
}
