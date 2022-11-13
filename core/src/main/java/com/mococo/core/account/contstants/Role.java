package com.mococo.core.account.contstants;

import lombok.Getter;

@Getter
public enum Role {
    USER("ROLE_USER"), ADMIN("ROLE_ADMIN");

    private String customType;

    Role (String customType){
        this.customType = customType;
    }
}