package com.mococo.core.post.dto;

import com.mococo.core.account.domain.entity.Account;
import com.mococo.core.account.vo.Address;
import com.mococo.core.post.domain.entity.Tag;

import java.time.LocalDateTime;
import java.util.List;

public interface PostSaveCommand {

    Account getUser() ;
    List<Tag> getTags() ;
    String getTitle();
    String getContent() ;
    double getLongitude();
    double getLatitude() ;
    Address getAddress() ;
    LocalDateTime getPostAt() ;

}
