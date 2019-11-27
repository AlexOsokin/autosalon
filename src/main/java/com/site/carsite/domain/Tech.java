package com.site.carsite.domain;

import javax.persistence.*;

@Entity//дает знать что это не просто кусок когда, а сущьность, которую необходимо сохранять в бд
@Table(name = "tech_t")
public class Tech {
    @Id//чтобы различать 2 записи в одной табличке
    @GeneratedValue(strategy = GenerationType.AUTO)//генератор идентификатора
    private Long id;
    private String type;
    private String name;
    private String cond;
    private String old;
    private Integer price;

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

    public Tech() {
    }
    public Tech(String type, String name, String cond, String old, Integer price) {
        this.name = name;
        this.type = type;
        this.cond = cond;
        this.old = old;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCondition() {
        return cond;
    }

    public void setCondition(String condition) {
        this.cond = condition;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
