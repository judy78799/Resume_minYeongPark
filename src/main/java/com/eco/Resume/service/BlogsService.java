package com.eco.Resume.service;

import com.eco.Resume.controller.MainController;
import com.eco.Resume.dto.BlogsDTO;
import com.eco.Resume.repository.BlogsRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BlogsService {

  private final BlogsRepository blogsRepository;

  private static final Logger logger = LoggerFactory.getLogger(MainController.class);  //클래스 생성자

  private static String Blogs_URL = "https://judy0465.tistory.com/";

  @PostConstruct
  public List<BlogsDTO> getBlogsDatas() throws IOException {


      List<BlogsDTO> blogsList = new ArrayList<>();
    try {
      Document document = Jsoup.connect(Blogs_URL).get();

      //블로그 리스트 덩어리 한개
      Elements contents = document.select("div.area-common div.article-content");
      int Blog_size = Math.min(contents.size(), 4); // contents의 크기와 4 중 작은 값 선택

      //콘텐츠의 크기만큼 가져오기
      for (int i = 0; i <contents.size() ; i++) {
        Element content = contents.get(i); // i번째 요소 가져오기
        String style = content.select("a.link-article[data-tiara-image]").attr("abs:data-tiara-image");

        System.out.println("contents는? : "+contents);
        // 크롤링한 콘텐츠 텍스트 가져오기
        String content_element = contents.select("p.summary").text(); // 변수 이름 변경

        // 콘텐츠 길이 확인 및 자르기
        if (content_element.length() > 1000) { // 255자는 예시입니다.
          content_element = content_element.substring(0, 1000); // 자르기
        }

        //System.out.println("스타일 값을 가져오는가? : " + style);
        BlogsDTO blogs = BlogsDTO.builder()
            .image(style) // style 속성 가져오기) // 이미지 URL
            .url(content.select("a").attr("abs:href"))
            .title(content.select("strong.title").text())
            .content(content.select("p.summary").text())
            .date(content.select("span.date").text())
            .build();

        blogsList.add(blogs);
      }
      //System.out.println("for 문 밖에서 값을 가져오는가? : "+ contents.select("p.thumbnail").attr("style"));
      // 데이터베이스에 저장
      blogsRepository.saveAll(blogsList);
    } catch (IOException e) {
      // 예외 처리 로직
      logger.error("Error while crawling blogs: {}", e.getMessage());
      // 예외가 발생했을 경우 빈 리스트를 반환할 수 있습니다.
      return Collections.emptyList();
    }
      return blogsList;
  }



  @Transactional(readOnly = true)
  public Page<BlogsDTO> getListItemPage(Pageable pageable) {
    return blogsRepository.findAll(pageable); //모든 아이템을 가져온다.
  }

  public void saveCrawledBlogs(List<BlogsDTO> blogs) {
    blogsRepository.saveAll(blogs);
  }
}