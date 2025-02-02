package com.eco.Resume.repository;
import com.eco.Resume.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
  Member findByEmail(String email);
}

