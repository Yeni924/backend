package com.mococo.core.account.dto;

import com.mococo.core.account.vo.Address;
import com.mococo.core.account.vo.EmailAddress;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public interface AccountSaveCommand {


     EmailAddress getEmailAddress();
     String getPassword();
     String getNickName();
     String getPosition();
}
