package com.mococo.core.common.constants;


import lombok.Getter;

@Getter
public enum ErrorCode {

    // 인증
    ALREADY_REGISTERED_MEMBER(400, "이미 가입된 회원 입니다."),
    MISMATCHED_PASSWORD(401, "패스워드가 일치하지 않습니다."),
    LOGIN_ERROR(401, "아이디 또는 비밀번호를 확인해주세요"),

    NOT_EXISTS_AUTHORIZATION(401, "Authorization Header가 빈값입니다."),
    NOT_VALID_BEARER_GRANT_TYPE(401, "인증 타입이 Bearer 타입이 아닙니다."),
    NOT_VALID_TOKEN(401, "유효하지않은 토큰 입니다."),
    ACCESS_TOKEN_EXPIRED(401, "해당 access token은 만료됐습니다."),
    FORBIDDEN_NOT_ADMIN(403, "관리자 권한이 없습니다."),

    // 회원
    USER_NOT_FOUND_ERROR(404, "일치하는 사용자를 찾을 수 없습니다."),

    INVALID_ADDRESS_EXCEPTION(400, "주소가 올바르지 않습니다."),
    INVALID_EMAIL_EXCEPTION(400, "이메일 주소가 올바르지 않습니다."),
    INVALID_PHONE_NUMBER_EXCEPTION(400, "전화번호가 올바르지 않습니다.")

    ;


    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private int status;
    private String message;

}