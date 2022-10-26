package com.mococo.api.config.security;

import com.mococo.core.account.domain.entity.Account;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserDetailsImpl implements UserDetails {

    private final Account account;
    private final List<GrantedAuthority> authorities = new ArrayList<>();   // 계정 권한

    public UserDetailsImpl(Account account) {
        this.account = account;
        //TODO ROLE enum 추가하기
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + account.getRole().name()));
        authorities.add(new SimpleGrantedAuthority("ROLE_" + "USER"));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getEmailAddressValue();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}