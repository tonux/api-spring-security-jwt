package com.sn.atos.atosspringsecurityjwt.model;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {


    public static final String USER_ADMIN="USER_ADMIN";
    public static final String AUTHOR_ADMIN="AUTHOR_ADMIN";
    public static final String BOOK_ADMIN="BOOK_ADMIN";

    private String authority;

    public Role() {
    }

    public Role(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
