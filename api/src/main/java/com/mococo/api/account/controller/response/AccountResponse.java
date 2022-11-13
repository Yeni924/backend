package com.mococo.api.account.controller.response;

import com.mococo.core.account.domain.entity.Account;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountResponse {

     private Long id;
     private String nickName;
     private String emailAddress;
     private String position;


     public static AccountResponse from(Account account){
          AccountResponse response = new AccountResponse();
          response.id = account.getId();
          response.nickName = account.getNickName();
          response.emailAddress = account.getEmailAddressValue();
          response.position = account.getPosition();
          return response;
     }

}
