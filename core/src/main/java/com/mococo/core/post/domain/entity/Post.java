package com.mococo.core.post.domain.entity;

import com.mococo.core.account.domain.entity.Account;
import com.mococo.core.account.vo.Address;
import com.mococo.core.common.Base.BaseTimeEntity;
import com.mococo.core.common.Tag;
import com.mococo.core.post.dto.PostSaveCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "userId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Account user;

    @OneToMany
    @JoinColumn(name="Tag_ID")
    private List<Tag> tags;

    @Column
    private String title;

    @Column(length = 2000, nullable = false)
    private String content;

    @Column
    private double longitude;

    @Column
    private double latitude;

    @Embedded
    private Address address;

    @Column
    private LocalDateTime postAt;

    public static Post create(PostSaveCommand command) {
        final Post post = new Post();

        post.user = command.getUser();
        post.tags = command.getTags();
        post.title = command.getTitle();
        post.content = command.getContent();
        post.latitude = command.getLatitude();
        post.longitude = command.getLongitude();
        post.address = command.getAddress();
        post.postAt = command.getPostAt();

        return post;
    }
}
