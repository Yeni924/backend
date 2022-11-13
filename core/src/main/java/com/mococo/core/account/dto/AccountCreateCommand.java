package com.mococo.core.account.dto;

import com.mococo.core.account.vo.Address;
import com.mococo.core.account.vo.EmailAddress;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Builder
public class AccountCreateCommand implements AccountSaveCommand{

     private EmailAddress emailAddress;
     private String password;
     private String nickName;
     //Todo - Position enum 처리
     private String position;


}
