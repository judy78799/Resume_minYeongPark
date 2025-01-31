package com.eco.Resume.repository;

import com.eco.Resume.dto.BlogsDTO;
import com.eco.Resume.entity.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BlogsRepository extends JpaRepository<Blogs, Long> {
}
