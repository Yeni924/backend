package com.mococo.api.account.controller.response;

import com.mococo.core.account.domain.entity.Account;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountResponse {

     private Long id;
     private String name;
     private String address;
     private String emailAddress;


     public static AccountResponse from(Account account){
          AccountResponse response = new AccountResponse();
          response.id = account.getId();
          response.name = account.getName();
          response.address = account.getAddressValue();
          response.emailAddress = account.getEmailAddressValue();
          return response;
     }

}
