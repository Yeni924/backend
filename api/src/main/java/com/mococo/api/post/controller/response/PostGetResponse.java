package com.mococo.api.post.controller.response;

import com.mococo.core.post.domain.entity.Post;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostGetResponse {

    private Long id;
    private String email;
    private String nickName;
    private String title;
    private String content;
    private double longitude;
    private double latitude;
    private String address;
    private LocalDateTime postAt;

    public static PostGetResponse from(Post post) {
        PostGetResponse response = new PostGetResponse();
        response.id = post. getId();
        response.email = post.getUser().getEmailAddressValue();
        response.nickName = post.getUser().getNickName();
        response.title = post.getTitle();
        response.content = post.getContent();
        response.longitude = post.getLongitude();
        response.latitude = post.getLatitude();
        response.address = post.getAddress();
        response.postAt = post.getPostAt();

        return response;
    }
}
