package com.mococo.core.account.domain.service;

import com.mococo.core.account.domain.entity.Account;
import com.mococo.core.account.domain.repository.AccountRepository;
import com.mococo.core.account.dto.AccountSaveCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class AccountCommandService {

     private final AccountRepository accountRepository;

     public Account create(AccountSaveCommand command) {

          Account user = Account.create(command);
          return accountRepository.save(user);
     }

}
