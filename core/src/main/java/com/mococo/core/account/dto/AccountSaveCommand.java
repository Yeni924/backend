package com.mococo.core.account.dto;

import com.mococo.core.account.vo.Address;
import com.mococo.core.account.vo.EmailAddress;

public interface AccountSaveCommand {

     String getName();

     Address getAddress();

     EmailAddress getEmailAddress();

}
