package com.mococo.api.config.security;

import com.mococo.core.account.domain.entity.Account;
import com.mococo.core.account.domain.service.AccountQueryService;
import com.mococo.core.account.vo.EmailAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountQueryService accountQueryService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final EmailAddress emailAddress = EmailAddress.create(email);
        Account account = accountQueryService.requireGet(emailAddress);

        return new UserDetailsImpl(account);
    }

}