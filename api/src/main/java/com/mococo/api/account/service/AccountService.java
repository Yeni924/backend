package com.mococo.api.account.service;


import com.mococo.api.account.controller.request.AccountCreateRequest;
import com.mococo.api.account.controller.response.AccountCreateResponse;
import com.mococo.api.account.controller.response.AccountResponse;
import com.mococo.core.account.domain.entity.Account;
import com.mococo.core.account.domain.service.AccountCommandService;
import com.mococo.core.account.domain.service.AccountQueryService;
import com.mococo.core.account.vo.EmailAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class AccountService {

     private final AccountCommandService accountCommandService;
     private final AccountQueryService accountQueryService;


     public AccountCreateResponse create(AccountCreateRequest request) {
          Account account = accountCommandService.create(request.toCommand());
          return AccountCreateResponse.from(account);
     }

    public AccountResponse get(Long id) {
        return AccountResponse.from(accountQueryService.requireGet(id));
    }

    public AccountResponse get(String email) {
        final EmailAddress emailAddress = EmailAddress.create(email);
        return AccountResponse.from(accountQueryService.requireGet(emailAddress));
    }
}
