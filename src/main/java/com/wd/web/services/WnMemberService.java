package com.wd.web.services;

import com.wd.web.entities.WnMember;
import com.wd.web.repositories.WnMemberRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface WnMemberService {
    void save(WnMember param);
    Optional<WnMember> findById(Long userNo);
    List<WnMember> findAll();
    Long count();
    void update(WnMember param);
    void delete(WnMember param);
}
@Service
class WnMemberServiceImpl implements WnMemberService {
    // 싱글톤 사용 이유
    // 객체를 new 로 생성하면 여러개가 생성됨
    // 호출 구조상에 해당 객체 호출시 시간 랙이 걸림...
    // UI 쪽에서 로그인 -> OkAuth 를 호출시 쓰레드
    final private WnMemberRepository repository;

    WnMemberServiceImpl(WnMemberRepository repository) {
        this.repository = repository;
    }


    @Override
    public void save(WnMember param) {
        repository.save(param);
    }

    @Override
    public Optional<WnMember> findById(Long userNo) {
        // return Optional.empty();
        return repository.findById(userNo);
    }

    @Override
    public List<WnMember> findAll() {
        return repository.findAll();
    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override @Modifying
    public void update(WnMember param) {
        repository.save(param);

    }

    @Override
    public void delete(WnMember param) {
        repository.delete(param);
    }
}
