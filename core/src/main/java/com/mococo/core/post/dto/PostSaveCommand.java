package com.mococo.core.post.dto;

import com.mococo.core.account.domain.entity.Account;
import com.mococo.core.common.Tag;

import java.time.LocalDateTime;
import java.util.List;

public interface PostSaveCommand {

    Account getUser() ;
    List<Tag> getTags() ;
    String getTitle();
    String getContent() ;
    double getLongitude();
    double getLatitude() ;
    String getAddress() ;
    LocalDateTime getPostAt() ;

}
