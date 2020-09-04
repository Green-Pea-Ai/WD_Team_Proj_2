package com.wd.web.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 구조 언어 : Structure
// SQL : Structured Query Language
// Entity 는 SQL 에서 Table 과 1대 1 매칭
// 엔티티 props = 테이블 column
// 객체는 기능 + 속성
// 객체는 Unique ID 를 반드시 가져야 한다.
@Getter
@Setter
@ToString
@Entity
@Table(name = "wn_member")
public class WnMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private Long userNo; // 정수 int long 7 vs 실수 float double 7.0

    @Column(length = 50, nullable = false)
    private String userId;

    @Column(length = 100, nullable = false)
    private String userName;

    @Column(length = 200, nullable = false)
    private String userPw;

    @Column(length = 16, nullable = false)
    private String job;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreationTimestamp
    private Date regDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @UpdateTimestamp
    private Date upDate;

    // 관계 (Relation )
    // 2가지 부모, 자식
    // 부서 1 <= 다수 M 사원
    // 1 : M 관계 -> @OneToMany
    // FK 유전자로 쉽게 생각해보면
    // FK 를 갖고 있는 테이블 (엔티티) 가 자식이 된다.

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_no")
    private List<WnAuth> authList = new ArrayList<WnAuth>();

    public void addAuth(WnAuth auth) {
        authList.add(auth);
    }

    public void clearAuth() {
        authList.clear();
    }

    @Builder
    public WnMember() {

    }
}
