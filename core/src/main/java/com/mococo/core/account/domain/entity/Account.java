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

    @NotNull
    @Size(max = 20)
    private String name;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "emailAddress", length = 20))
    private EmailAddress emailAddress;

    @Embedded
    private Address address;

    @Size(max = 200)
    private String password;

    public static Account create(AccountSaveCommand command) {
        final Account user = new Account();
        user.name = command.getName();
        user.address = command.getAddress();
        user.emailAddress = command.getEmailAddress();
        return user;
    }

    public String getEmailAddressValue() {
        return Objects.isNull(this.emailAddress) ? null : this.emailAddress.getValue();
    }

    public String getAddressValue() {
        return Objects.isNull(this.address) ? null : this.address.getValue();
    }
}
