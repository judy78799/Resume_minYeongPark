package com.eco.Resume.initializer;

import com.eco.Resume.service.BlogsService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

  private boolean isDataLoaded = false;

  @Autowired
  private BlogsService blogsService;

  @PostConstruct
  public void init() throws InterruptedException {
    if (!isDataLoaded) {
      loadInitialData();
      isDataLoaded = true; // 데이터 로드 후 플래그 설정
    }
  }

  private void loadInitialData() throws InterruptedException {
    // 초기 데이터 로드 로직
    blogsService.createInitialBlogs(); // 초기 블로그 생성 메서드 호출
  }
}
