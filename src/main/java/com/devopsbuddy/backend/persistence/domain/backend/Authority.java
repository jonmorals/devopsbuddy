package com.devopsbuddy.backend.persistence.domain.backend;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Jonathan on 11/3/2016.
 */
public class Authority implements GrantedAuthority {

    private final String authority;

    public Authority(String authority) {

        this.authority = authority;
    }


    @Override
    public String getAuthority() {
        return authority;
    }
}
