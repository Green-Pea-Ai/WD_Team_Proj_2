package com.wd.web.repositories;

import com.wd.web.entities.WnMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WnMemberRepository extends JpaRepository<WnMember, Long> {
}
