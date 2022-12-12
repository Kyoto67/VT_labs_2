package com.ifmo.cs.kyoto.alaba4.entities;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

    @Override
    public String getAuthority() {
        return "USER";
    }
}
