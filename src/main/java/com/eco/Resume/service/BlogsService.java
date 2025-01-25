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

@Service
public class BlogsService {
  private static String Blogs_URL = "https://judy0465.tistory.com/";

  @PostConstruct
  public List<Blogs> getBlogsDatas() throws IOException{
    List<Blogs> blogsList = new ArrayList<>();

      Document document = Jsoup.connect(Blogs_URL).get();

    //정보 덩어리 한개
    Elements contents = document.select("div.area-common div.article-content");

    for(Element content : contents){
      Blogs blogs = Blogs.builder()
          .image(content.select("img.img-thumbnail").attr("abs:src"))
          .url(content.select("a").attr("abs:href"))
          .title(content.select("strong.title").text())
          .content(content.select("p.summary").text())
          .date(content.select("span.date").text())
          .build();
      blogsList.add(blogs);
    }
    return blogsList;
  }
}
