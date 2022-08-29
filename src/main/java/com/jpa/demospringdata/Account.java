package com.jpa.demospringdata;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Account {
    @Id
    @GeneratedValue  // 전략 따로 설정 가능 (strategy = ) /
    private Long id; // unique key

    @Column(nullable = false, unique = true)
    private String userName;
    private String password;


    // 단방향 맵핑
    // Account 테이블이 owner 입장
    // Account : Study = 1 : N
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Study> studies = new HashSet<>();

    public Set<Study> getStudies() {
        return studies;
    }

    public void setStudies(Set<Study> studies) {
        this.studies = studies;
    }

    // Date, Calender 타입으로 변환하여 setting
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    private String yes;

    // db 컬럼 추가 제외
    @Transient
    private  String no;

    // 객체 embedded
    // db 컬럼 같이 테이블 스키마에 추가
    @Embedded
    private Address officeAddress;

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
