package com.mococo.core.account.domain.repository;

import com.mococo.core.account.domain.entity.Account;
import com.mococo.core.account.vo.EmailAddress;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByEmailAddress(EmailAddress email);
    Optional<Account> findByNickName(String nickName);
}
