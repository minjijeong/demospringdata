package com.jpa.demospringdata;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Study {
    @Id @GeneratedValue
    private Long id;
    private String name;


    // 단방향 맵핑
    // Study : Account = N : 1
    // owner는 Study 객체
    @ManyToOne(cascade = CascadeType.PERSIST)   // 기존 데이타가 없어는데 insert 관계를 같이 집어 넣을때...에러남..
    private Account owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }
}
