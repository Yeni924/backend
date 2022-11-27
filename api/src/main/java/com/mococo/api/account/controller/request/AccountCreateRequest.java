package com.mococo.api.account.controller.request;

import com.mococo.core.account.dto.AccountCreateCommand;
import com.mococo.core.account.vo.EmailAddress;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountCreateRequest {

    @Email(message = "이메일 형식이 아닙니다.")
    @NotEmpty(message = "이메일 주소는 필수 입력 값입니다.")
    private String email;

    @NotEmpty(message = "패스워드는 필수 입력 값입니다.")
    private String password;

    @NotEmpty(message = "닉네임은 필수 입력 값입니다.")
    private String nickName;

    public AccountCreateCommand toCommand(String credentials) {
        return AccountCreateCommand.builder()
            .emailAddress(EmailAddress.create(this.email))
            .password(credentials)
            .nickName(nickName)
            .build();
    }

}
