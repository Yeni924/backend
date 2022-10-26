package com.mococo.api.account.controller.request;

import com.mococo.core.account.dto.AccountCreateCommand;
import com.mococo.core.account.vo.Address;
import com.mococo.core.account.vo.EmailAddress;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountCreateRequest {

    @NotEmpty(message = "이름은 필수 입력 값입니다.")
    private String name;

    @NotEmpty(message = "주소는 필수 입력 값입니다.")
    private String address;

    @Email(message = "이메일 형식이 아닙니다.")
    @NotEmpty(message = "이메일 주소는 필수 입력 값입니다.")
    private String email;


    public AccountCreateCommand toCommand() {
        return AccountCreateCommand.builder()
            .name(this.name)
            .address(Address.create(this.address))
            .emailAddress(EmailAddress.create(this.email))
            .build();
    }

}
