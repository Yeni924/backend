package com.mococo.core.account.domain.service;

import com.mococo.core.account.domain.entity.Account;
import com.mococo.core.account.domain.repository.AccountRepository;
import com.mococo.core.account.vo.EmailAddress;
import com.mococo.core.common.constants.ErrorCode;
import com.mococo.core.common.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class AccountQueryService {

    private final AccountRepository accountRepository;

    public Account requireGet(Long id) {
        return accountRepository.findById(id)
            .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND_ERROR));
    }

    public Account requireGet(EmailAddress emailAddress) {
        return accountRepository.findByEmailAddress(emailAddress)
            .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND_ERROR));
    }

    public boolean emailCheck(EmailAddress emailAddress) {
        return accountRepository.findByEmailAddress(emailAddress).isPresent();

    }
}
