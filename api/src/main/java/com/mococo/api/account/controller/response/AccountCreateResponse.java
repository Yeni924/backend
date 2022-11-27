package com.mococo.api.account.controller.response;

import com.mococo.core.account.contstants.Role;
import com.mococo.core.account.domain.entity.Account;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountCreateResponse {

     private Long id;
     private String email;
     private String nickName;
     private Role role;
     private LocalDateTime createAt;
     private LocalDateTime updateAt;

     public static AccountCreateResponse from(Account account){
          AccountCreateResponse response = new AccountCreateResponse();
          response.id = account.getId();
          response.email = account.getEmailAddressValue();
          response.nickName = account.getNickName();
          response.role = account.getRole();
          response.createAt = account.getCreateTime();
          response.updateAt = account.getUpdateTime();
          return response;
     }

}
