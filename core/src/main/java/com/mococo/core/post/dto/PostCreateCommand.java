package com.mococo.core.post.dto;

import com.mococo.core.account.domain.entity.Account;
import com.mococo.core.account.vo.Address;
import com.mococo.core.post.domain.entity.Tag;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class PostCreateCommand  implements  PostSaveCommand{

    private Account user;
    private List<Tag> tags;
    private String title;
    private String content;
    private double longitude;
    private double latitude;
    private Address address;
    private LocalDateTime postAt;


}
