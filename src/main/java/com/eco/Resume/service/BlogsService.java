package com.eco.Resume.service;

import com.eco.Resume.controller.MainController;
import com.eco.Resume.dto.BlogsDTO;
import com.eco.Resume.entity.Blogs;
import com.eco.Resume.repository.BlogsRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Transactional
@RequiredArgsConstructor
@Service
public class BlogsService {

  @Autowired
  private final BlogsRepository blogsRepository;

  private static final Logger logger = LoggerFactory.getLogger(MainController.class);  //클래스 생성자
  private static final String Blogs_URL = "https://judy0465.tistory.com/";

  //데이터 저장 메서드
  public void saveBlogs(List<BlogsDTO> blogsDTOList) {
    List<Blogs> blogsList = new ArrayList<>();

    for (BlogsDTO blogsDTO : blogsDTOList) {
      Blogs blogEntity = blogsDTO.createItem(); // DTO를 엔티티로 변환
      blogsList.add(blogEntity);
    }

    try {
      blogsRepository.saveAll(blogsList); // 한 번에 저장
    } catch (Exception e) {
      System.err.println("데이터베이스 저장 실패: " + e.getMessage());
    }
  }

  //초기 데이터를 로드
  @PostConstruct
  @Transactional
  public void init() throws InterruptedException, IOException {
    blogsRepository.deleteAll(); // 기존 데이터 삭제 같은 데이터를 누적시키지 않기 위함.
    System.out.println("삭제 후 데이터 개수: " + blogsRepository.count());
    // ID값을 리셋 합니다.
    blogsRepository.resetIdSequence();

    List<BlogsDTO> blogsDTOList = getBlogsDatas(); // 크롤링한 데이터 가져오기
    saveBlogs(blogsDTOList); // 데이터베이스에 저장
  }

//JSOUP을 사용한 크롤링
@PostConstruct
  public List<BlogsDTO> getBlogsDatas() throws IOException {
    int pageNumber = 1;
    int blogCount = 0; // 가져온 블로그 수를 카운트
    // 반환할 BlogsDTO 리스트 생성
    List<BlogsDTO> blogsList = new ArrayList<>();
    try {
      while (true) {
        Document document = Jsoup.connect(Blogs_URL + "?page=" + pageNumber).get();

        //블로그 리스트 덩어리 한개
        //Elements contents = document.select("div.area-common div.article-content");
        //이미지를 못가져와서 해보는 테스트
        Elements contents = document.select("div.area-common article.article-type-common");

        //int Blog_size = Math.min(contents.size(), 4); // contents의 크기와 4 중 작은 값 선택
        Elements content_element_substring = document.select("p.summary"); // 크롤링한 텍스트 가져오기

        // 가져온 글이 없으면 종료
        if (contents.isEmpty()) {
          break;
        }
          if (blogCount >= 12) {
            break;
          }

        System.out.println("JSOUP contents 전체 사이즈는?" + contents.size());
        //콘텐츠의 크기만큼 가져오기
        for (int i = 0; i < contents.size(); i++) {
          // 12개를 초과하면 종료
//          if (blogCount >= 12) {
//            break;
//          }

          Element content = contents.get(i); // i번째 요소 가져오기
          //String style = content.select("a.link-article[data-tiara-image]").attr("abs:data-tiara-image").text();
          String style = content.select("a.link-article").attr("data-tiara-image");
          String content_element_string = document.select("p.summary").text();
          Element each_content = content_element_substring.get(i);
          // 크롤링한 콘텐츠 텍스트 가져오기
          String content_element = each_content.text();

          System.out.println("스타일 값을 가져오는가? : " + style);

          //각각의 콘텐츠 길이 확인 및 자르기
        String subStringElement = content_element.length() > 100
            ? content_element.substring(0, 100)
            : content_element; // 길이 확인 후 자르기

          //System.out.println("스타일 값을 가져오는가? : " + style);
          BlogsDTO blogs = BlogsDTO.builder()
              .image(style) // style 속성 가져오기) // 이미지 URL
              .url(content.select("a").attr("abs:href"))
              .title(content.select("strong.title").text())
              .content(subStringElement)
              .date(content.select("span.date").text())
              .build();

          blogsList.add(blogs);
          blogCount++; // 블로그 수를 증가시킵니다.
        }
        //System.out.println("for 문 밖에서 값을 가져오는가? : "+ contents.select("p.thumbnail").attr("style"));
        pageNumber++;
      }
    }catch (IOException e) {
      // 예외 처리 로직.
      logger.error("Error while crawling blogs: {}", e.getMessage());
      // 예외가 발생했을 경우 빈 리스트를 반환할 수 있음.
      return Collections.emptyList();
    }
    return blogsList;
}

  //@Transactional(readOnly = true)
  public Page<Blogs> getListItemPage(Pageable pageable) {
    return blogsRepository.findAll(pageable); //모든 아이템을 가져온다.
  }

  public void saveCrawledBlogs(List<Blogs> blogs) {
    blogsRepository.saveAll(blogs);
  }
}