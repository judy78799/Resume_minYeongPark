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

    //정보 덩어리 한개
    Elements contents = document.select("div.area-common div.article-content");

    String backgroundImageUrl = "";

// style 속성에서 URL 추출
    //style이 비어있지 않고 background-image 포함한다면~

    for(Element content : contents){

      String style = content.select("a.link-article[data-tiara-image]").attr("abs:data-tiara-image");
      System.out.println("스타일 값을 가져오는가? : " + style);

      if (style != null && style.contains("background-image")) {
        // 정규 표현식으로 URL 추출
        Pattern pattern = Pattern.compile("url\\(\"?(.*?)\"?\\)");
        Matcher matcher = pattern.matcher(style);

        if (matcher.find()) {
          style = matcher.group(1); // 첫 번째 그룹(즉, URL) 가져오기
        }
      }
      Blogs blogs = Blogs.builder()
          .image(style) // style 속성 가져오기) // 이미지 URL
          .url(content.select("a").attr("abs:href"))
          .title(content.select("strong.title").text())
          .content(content.select("p.summary").text())
          .date(content.select("span.date").text())
          .build();
      blogsList.add(blogs);
      //System.out.println("blogsList add 후에는 Url 값을 가져오는가? : "+ contents.select("a").attr("abs:href"));
    }
    //System.out.println("for 문 밖에서 값을 가져오는가? : "+ contents.select("p.thumbnail").attr("style"));

    return blogsList;
  }
}
