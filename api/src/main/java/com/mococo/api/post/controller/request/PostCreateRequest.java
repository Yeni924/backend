package com.mococo.api.post.controller.request;

import com.mococo.core.account.domain.entity.Account;
import com.mococo.core.common.Tag;
import com.mococo.core.post.dto.PostCreateCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostCreateRequest {

    private String email;
   // private List<Tag> tags;
    private String title;
    private String content;
    private String address;
    private double latitude;
    private double longitude;
    private LocalDateTime postAt;

    public PostCreateCommand toCommand(Account user) {
        return PostCreateCommand.builder()
                .user(user)
           //     .tags(tags)
                .title(title)
                .content(content)
                .latitude(latitude)
                .longitude(longitude)
                .address(address)
                .postAt(postAt)
                .build();

    }
}
