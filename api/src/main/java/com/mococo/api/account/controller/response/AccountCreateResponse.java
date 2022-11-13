package com.mococo.api.account.controller.response;

import com.mococo.core.account.domain.entity.Account;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountCreateResponse {

     private Long id;
     private String email;
     private String nickName;
     private String position;

     public static AccountCreateResponse from(Account account){
          AccountCreateResponse response = new AccountCreateResponse();
          response.id = account.getId();
          response.email = account.getEmailAddressValue();
          response.nickName = account.getNickName();
          response.position = account.getPosition();
          return response;
     }

}
