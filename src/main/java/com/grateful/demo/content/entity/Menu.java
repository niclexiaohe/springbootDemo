package com.grateful.demo.content.entity;

import java.util.List;

/**
 * DESC: 菜单对象
 * USER: C.HE
 * DATE: 2018/10/21 16:19
 * VERSION: 0.0.1
 */
public class Menu {

    private Authority parentAuthority;//父菜单

    private List<Authority> childAuthorities;//子菜单

    public Authority getParentAuthority() {
        return parentAuthority;
    }

    public void setParentAuthority(Authority parentAuthority) {
        this.parentAuthority = parentAuthority;
    }

    public List<Authority> getChildAuthorities() {
        return childAuthorities;
    }

    public void setChildAuthorities(List<Authority> childAuthorities) {
        this.childAuthorities = childAuthorities;
    }
}
