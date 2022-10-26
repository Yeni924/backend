package com.mococo.api.account.controller.response;

import com.mococo.core.account.domain.entity.Account;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountCreateResponse {

     private Long id;


     public static AccountCreateResponse from(Account account){
          AccountCreateResponse response = new AccountCreateResponse();
          response.id = account.getId();
          return response;
     }

}
