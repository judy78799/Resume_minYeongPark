package com.eco.Resume.repository;

import com.eco.Resume.dto.BlogsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogsRepository extends JpaRepository<BlogsDTO, Long> {
}
