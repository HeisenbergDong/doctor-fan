package com.ruoyi.framework.security.auth;

import java.security.Principal;

/**
 * 创建人: 武奇
 * 创建时间: 2022/3/4
 */
public class SocketUser implements Principal {

    private final String name;

    public SocketUser(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
