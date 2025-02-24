package com.eco.Resume;

import com.eco.Resume.dto.BlogsDTO;
import com.eco.Resume.service.BlogsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;


@SpringBootTest
public class CrawlingServiceTest {
  @Autowired
  private BlogsService blogService;
  @Test
  public void t1() throws Exception {
    List<BlogsDTO> list = blogService.getBlogsDatas();  //Jsoup 크롤링

    for(BlogsDTO data:list){
      System.out.println("블로그 url:" + data.getUrl());
      System.out.println("블로그 이미지 src:" + data.getImage());
      System.out.println("블로그 제목:" + data.getTitle());
      System.out.println("블로그 내용:" + data.getContent());
      System.out.println("블로그 날짜:" + data.getDate());
    }

  }
}
