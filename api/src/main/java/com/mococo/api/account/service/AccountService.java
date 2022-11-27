package com.mococo.api.account.service;


import com.mococo.api.account.controller.request.AccountCreateRequest;
import com.mococo.api.account.controller.response.AccountCreateResponse;
import com.mococo.api.account.controller.response.AccountResponse;
import com.mococo.core.account.domain.entity.Account;
import com.mococo.core.account.domain.service.AccountCommandService;
import com.mococo.core.account.domain.service.AccountQueryService;
import com.mococo.core.account.vo.EmailAddress;
import com.mococo.core.common.constants.ErrorCode;
import com.mococo.core.common.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class AccountService {

     private final AccountCommandService accountCommandService;
     private final AccountQueryService accountQueryService;
     private final PasswordEncoder passwordEncoder;


    public AccountCreateResponse create(AccountCreateRequest request) {

        if(emailCheck(request.getEmail()))  throw new BusinessException(ErrorCode.ALREADY_REGISTERED_EMAIL);
        if(nickNameCheck(request.getNickName())) throw new BusinessException(ErrorCode.ALREADY_REGISTERED_NICKNAME);

        var credentials = passwordEncoder.encode(request.getPassword());
        Account account = accountCommandService.create(request.toCommand(credentials));
        return AccountCreateResponse.from(account);
     }

    public AccountResponse get(Long id) {
        return AccountResponse.from(accountQueryService.requireGet(id));
    }

    public boolean emailCheck(String email) {
        final EmailAddress emailAddress = EmailAddress.create(email);
        return accountQueryService.emailCheck(emailAddress);
    }

    public boolean nickNameCheck(String nickName){
        return accountQueryService.nickNameCheck(nickName);
    }

}
