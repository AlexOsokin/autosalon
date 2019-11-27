package com.site.carsite.domain;

import javax.persistence.*;
import java.util.Set;

@Entity//дает знать что это не просто кусок когда, а сущьность, которую необходимо сохранять в бд
@Table(name = "sp_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String pass;
    private boolean active;//признак активности

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)//жадная подгрузка сразу все для роли
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))//табличка пользователь соединяется по средством столбца user_id
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
