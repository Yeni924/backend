package com.mococo.core.account.dto;

import com.mococo.core.account.contstants.Role;
import com.mococo.core.account.vo.EmailAddress;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class AccountCreateCommand implements AccountSaveCommand{

     private EmailAddress emailAddress;
     private String password;
     private String nickName;

     @Override
     public Role getRole() {
        return Role.USER;
     }

     public void setCredentials(String credentials) {
          this.password = credentials;
     }
}
