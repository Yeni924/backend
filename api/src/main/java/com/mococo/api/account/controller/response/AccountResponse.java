package com.mococo.api.account.controller.response;

import com.mococo.core.account.contstants.Role;
import com.mococo.core.account.domain.entity.Account;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountResponse {

     private Long id;
     private String nickName;
     private String emailAddress;
     private Role role;
     private LocalDateTime createAt;
     private LocalDateTime updateAt;


     public static AccountResponse from(Account account){
          AccountResponse response = new AccountResponse();
          response.id = account.getId();
          response.nickName = account.getNickName();
          response.emailAddress = account.getEmailAddressValue();
          response.role = account.getRole();
          response.createAt = account.getCreateTime();
          response.updateAt = account.getUpdateTime();
          return response;
     }

}
