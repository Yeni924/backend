package com.mococo.core.account.domain.entity;

import com.mococo.core.account.dto.AccountSaveCommand;
import com.mococo.core.account.vo.Address;
import com.mococo.core.account.vo.EmailAddress;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private EmailAddress emailAddress;

    @Embedded
    private Address address;

    @Column
    private String password;

    @Column
    private String nickName;

    @Column
    private String position;

    public static Account create(AccountSaveCommand command) {
        final Account user = new Account();
        user.emailAddress = command.getEmailAddress();
        user.password = command.getPassword();
        user.nickName = command.getNickName();
        user.position = command.getPosition();
        return user;
    }

    public String getEmailAddressValue() {
        return Objects.isNull(this.emailAddress) ? null : this.emailAddress.getEmail();
    }

    public String getAddressValue() {
        return Objects.isNull(this.address) ? null : this.address.getValue();
    }
    
    //TODO 비밀번호 암호화 추가  할것
}
