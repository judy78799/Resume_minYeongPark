package com.eco.Resume.service;

import com.eco.Resume.dto.Blogs;
import jakarta.annotation.PostConstruct;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BlogsService {
  private static String Blogs_URL = "https://judy0465.tistory.com/";

  @PostConstruct
  public List<Blogs> getBlogsDatas() throws IOException{
    List<Blogs> blogsList = new ArrayList<>();

      Document document = Jsoup.connect(Blogs_URL).get();

    //블로그 리스트 덩어리 한개
    Elements contents = document.select("div.area-common div.article-content");

    int Blog_size = Math.min(contents.size(), 4); // contents의 크기와 4 중 작은 값 선택

    for(int i =0; i < Blog_size; i++){
      Element content = contents.get(i); // i번째 요소 가져오기
      String style = content.select("a.link-article[data-tiara-image]").attr("abs:data-tiara-image");
      //System.out.println("스타일 값을 가져오는가? : " + style);
      Blogs blogs = Blogs.builder()
          .image(style) // style 속성 가져오기) // 이미지 URL
          .url(content.select("a").attr("abs:href"))
          .title(content.select("strong.title").text())
          .content(content.select("p.summary").text())
          .date(content.select("span.date").text())
          .build();

      blogsList.add(blogs);
    }
    //System.out.println("for 문 밖에서 값을 가져오는가? : "+ contents.select("p.thumbnail").attr("style"));

    return blogsList;
  }
}
