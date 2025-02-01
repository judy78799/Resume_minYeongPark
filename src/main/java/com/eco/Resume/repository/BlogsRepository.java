package com.eco.Resume.repository;

import com.eco.Resume.dto.BlogsDTO;
import com.eco.Resume.entity.Blogs;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface BlogsRepository extends JpaRepository<Blogs, Long> {
  @Modifying
  @Transactional
  @Query(value = "ALTER TABLE blogs AUTO_INCREMENT = 1", nativeQuery = true)  //기존 데이터 삭제 시, 다시 1로 초기화
  void resetIdSequence(); // AUTO_INCREMENT 리셋 메서드
}
