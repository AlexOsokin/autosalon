package com.site.carsite.domain;

import javax.persistence.*;

@Entity//дает знать что это не просто кусок когда, а сущьность, которую необходимо сохранять в бд
@Table(name = "contract_t")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long t_id;
    private String u_name;
    private String tel;
    private String email;

    public Contract() {
    }

    public Contract(Long t_name, String u_name, String tel, String email) {
        this.t_id = t_name;
        this.u_name = u_name;
        this.tel = tel;
        this.email = email;
    }

    @CollectionTable(name = "sp_user", joinColumns = @JoinColumn(name = "name"))


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public Long getTech_id() {
        return t_id;
    }

    public void setTech_id(Long tech_id) {
        this.t_id = tech_id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
