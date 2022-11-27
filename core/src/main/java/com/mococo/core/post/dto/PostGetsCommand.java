package com.mococo.core.post.dto;

import com.mococo.core.account.domain.entity.Account;
import com.mococo.core.common.Tag;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class PostGetsCommand {

    private Account user;
    private Long postId;
    private List<Tag> tags;
    private String title;
    private String content;
    private double longitude;
    private double latitude;
    private String address;
    private LocalDateTime postAt;
}
