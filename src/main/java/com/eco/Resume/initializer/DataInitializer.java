package com.eco.Resume.initializer;

import com.eco.Resume.dto.BlogsDTO;
import com.eco.Resume.entity.Blogs;
import com.eco.Resume.service.BlogsService;
import jakarta.annotation.PostConstruct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    //blogsService.getDataList(); // 초기 블로그 생성 메서드 호출
  }
//
//  //데이터를 가져옵니다 셀레니움 버전
//  @PostConstruct
//  @Transactional
//  public List<BlogsDTO> getDataList() throws InterruptedException {
//
//    System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
//
//    // 크롬 옵션 설정
//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("--disable-popup-blocking");       //팝업안띄움
//    options.addArguments("headless");                       //브라우저 안띄움
//    options.addArguments("--disable-gpu");			//gpu 비활성화
//    options.addArguments("--blink-settings=imagesEnabled=false"); //이미지 다운 안받음
//    WebDriver driver = new ChromeDriver(options);
//
//
//    // 페이지 번호 설정
//    int pageNumber = 1;
//
//    // 반환할 BlogsDTO 리스트 생성
//    List<BlogsDTO> blogsDTOList = new ArrayList<>();
//
//    while (true) {
//      // URL에 페이지 번호 추가
//      driver.get(Blogs_URL + "?page=" + pageNumber);
//
//      // area-common 클래스의 모든 자식 요소 선택
//      List<WebElement> articles = driver.findElements(By.cssSelector("div.area-common div.article-content"));
//
//      // 가져온 글이 없으면 종료
//      if (articles.isEmpty()) {
//        break;
//      }
//
//      // 콘텐츠의 크기만큼 가져오기
//      //for (int i = 0; i < all_elements.size(); i++) {
//      for (WebElement article : articles) {
//        //WebElement content = elements.get(i); // i번째 요소 가져오기
//        String style = article.findElement(By.cssSelector("a.link-article[data-tiara-image]")).getAttribute("abs:data-tiara-image");
//
//        // 크롤링한 콘텐츠 텍스트 가져오기
//        String contentElement = article.getText();
//        // 각각의 콘텐츠 길이 확인 및 자르기
//        String subStringElement = contentElement.length() > 255
//            ? contentElement.substring(0, 255)
//            : contentElement; // 길이 확인 후 자르기
//
//        //잘린 내용들 출력
//
//        System.out.println("image src :" + style);
//        System.out.println("url : " + article.findElement(By.tagName("a")).getAttribute("href"));
//        System.out.println("title : " + article.findElement(By.cssSelector("strong.title")).getText());
//        System.out.println("잘린 content 내용들 subStringElement ? = " + subStringElement);
//        System.out.println("date : " + article.findElement(By.cssSelector("span.date")).getText());
//
//        BlogsDTO blogs = BlogsDTO.builder()
//            .image(style) // 이미지 URL
//            .url(article.findElement(By.tagName("a")).getAttribute("href")) // 링크 URL
//            .title(article.findElement(By.cssSelector("strong.title")).getText()) // 제목
//            .content(subStringElement) // 내용
//            .date(article.findElement(By.cssSelector("span.date")).getText()) // 날짜
//            .build();
//
//        blogsDTOList.add(blogs);  //blogsDTOList에 추가
//        //DTO blogs를 엔티티 Blogs로 매핑
//        Blogs blogsEntity = blogs.createItem();
//      }
//      //페이지 번호 증가 tistory는 1페이지 당 10개씩 볼 수 있도록 설정해놓았기 때문에 페이지++ 해서 읽어와야 함.
//      pageNumber++;
//    }
//    driver.quit();
//    return blogsDTOList; //blogsDTOList 반환
//  }











}
