package com.mococo.core.account.dto;

import com.mococo.core.account.contstants.Role;
import com.mococo.core.account.vo.EmailAddress;


public interface AccountSaveCommand {


     EmailAddress getEmailAddress();
     String getPassword();
     String getNickName();
     String getPosition();
     Role getRole();
}
