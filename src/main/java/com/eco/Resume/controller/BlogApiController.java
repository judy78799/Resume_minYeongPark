package com.eco.Resume.controller;


import com.eco.Resume.entity.Blogs;
import com.eco.Resume.service.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blogs")
public class BlogApiController {

  @Autowired
  private BlogsService blogsService;

  //데이터베이스 상에서 값을 읽어오는 것이기 때문에 Blogs 엔티티 타입으로 받아오는 것이 맞다.
  @GetMapping
  public ResponseEntity<Page<Blogs>> getBlogs(
      @PageableDefault(page = 1, size = 4, sort = "date", direction = Sort.Direction.DESC) Pageable pageable) {

    Page<Blogs> blogs = blogsService.getListItemPage(pageable);

    return ResponseEntity.ok(blogs);
  }
}