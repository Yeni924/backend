package com.mococo.core.account.dto;

import com.mococo.core.account.vo.Address;
import com.mococo.core.account.vo.EmailAddress;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountCreateCommand implements AccountSaveCommand{

     private String name;
     private Address address;
     private EmailAddress emailAddress;
}
