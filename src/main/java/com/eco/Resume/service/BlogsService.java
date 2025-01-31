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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

@Service
@Transactional
@RequiredArgsConstructor
public class BlogsService {

  public WebDriver driver;


  private final BlogsRepository blogsRepository;

  private static final Logger logger = LoggerFactory.getLogger(MainController.class);  //클래스 생성자
  private static final String Blogs_URL = "https://judy0465.tistory.com/";


  // 생성자를 통한 의존성 주입

//  public BlogsService(BlogsRepository blogsRepository) {
//    this.blogsRepository = blogsRepository;
//  }
  //서비스가 초기화될 때 자동으로 호출되도록 할 수 있습니다.
  //이렇게 하면 서비스가 생성될 때마다 크롤링 프로세스가 실행됩니다.
//  @PostConstruct
//  public void process() {
//    //크롬 드라이버 위치를 추가해 줍니다
//    System.setProperty("webdriver.chrome.driver", "D:\\chrome_driver\\chrome-win64");
//
//    //크롬 버전이 111인 경우 사용합니다. 이 설정이 없을 경우 403 에러가 나오는 이슈가 있습니다.
//    //버전이 111 이전 버전인 경우에는 무관합니다.
////    ChromeOptions options = new ChromeOptions();
////    BlogsService(BlogsRepository)
//
//    //위의 옵션이 필요하지 않은 경우 driver = new ChromeDriver() 이렇게 쓰시면 됩니다.
//    //driver = new ChromeDriver(options);
//    driver = new ChromeDriver();
//
//    try{
//      //크롤링 실행
//      getDataList();
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//
//    driver.close(); //탭 닫기
//    driver.quit();	//브라우저 닫기
//
//  }

  //데이터를 가져옵니다 셀레니움 버전
  @PostConstruct
  @Transactional
  public List<BlogsDTO> getDataList() throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

    // 크롬 옵션 설정
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    options.addArguments("--headless"); // 헤드리스 모드 추가
    WebDriver driver = new ChromeDriver(options);


    // 페이지 번호 설정
    int pageNumber = 1;

    // 반환할 BlogsDTO 리스트 생성
    List<BlogsDTO> blogsDTOList = new ArrayList<>();

    while (true) {
      // URL에 페이지 번호 추가
      driver.get(Blogs_URL + "?page=" + pageNumber);

      // area-common 클래스의 모든 자식 요소 선택
      List<WebElement> articles = driver.findElements(By.cssSelector("div.area-common div.article-content"));

      // 가져온 글이 없으면 종료
      if (articles.isEmpty()) {
        break;
      }

      // 콘텐츠의 크기만큼 가져오기
      //for (int i = 0; i < all_elements.size(); i++) {
      for (WebElement article : articles) {
        //WebElement content = elements.get(i); // i번째 요소 가져오기
        String style = article.findElement(By.cssSelector("a.link-article[data-tiara-image]")).getAttribute("abs:data-tiara-image");

        // 크롤링한 콘텐츠 텍스트 가져오기
        String contentElement = article.getText();
        // 각각의 콘텐츠 길이 확인 및 자르기
        String subStringElement = contentElement.length() > 255
            ? contentElement.substring(0, 255)
            : contentElement; // 길이 확인 후 자르기

        //잘린 내용들 출력

        System.out.println("image src :" + style);
        System.out.println("url : " + article.findElement(By.tagName("a")).getAttribute("href"));
        System.out.println("title : " + article.findElement(By.cssSelector("strong.title")).getText());
        System.out.println("잘린 content 내용들 subStringElement ? = " + subStringElement);
        System.out.println("date : " + article.findElement(By.cssSelector("span.date")).getText());

        BlogsDTO blogs = BlogsDTO.builder()
            .image(style) // 이미지 URL
            .url(article.findElement(By.tagName("a")).getAttribute("href")) // 링크 URL
            .title(article.findElement(By.cssSelector("strong.title")).getText()) // 제목
            .content(subStringElement) // 내용
            .date(article.findElement(By.cssSelector("span.date")).getText()) // 날짜
            .build();

        blogsDTOList.add(blogs);  //blogsDTOList에 추가
        //DTO blogs를 엔티티 Blogs로 매핑
        Blogs blogsEntity = blogs.createItem();
        try {
          blogsRepository.save(blogsEntity);  //데이터 베이스에 저장
        } catch (Exception e) {
          System.err.println("데이터베이스 저장 실패: " + e.getMessage());
        }

      }

      pageNumber++; //페이지 번호 증가
    }

    driver.quit();
    return blogsDTOList; //blogsDTOList 반환
  }
//  @PostConstruct
//  public  List<BlogsDTO> getDataList() throws InterruptedException {
//
//    List<BlogsDTO> blogsList = new ArrayList<>();
//    try {
//      //process 추가한 부분
//      //크롬 드라이버 위치를 추가해 줍니다
//        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
//
//      //크롬 버전이 111인 경우 사용합니다. 이 설정이 없을 경우 403 에러가 나오는 이슈가 있습니다.
//      //버전이 111 이전 버전인 경우에는 무관합니다.
////      ChromeOptions options = new ChromeOptions();
////      options.addArguments("--remote-allow-origins=*");
//
//      //위의 옵션이 필요하지 않은 경우 driver = new ChromeDriver() 이렇게 쓰시면 됩니다.
//      //driver = new ChromeDriver(options);
//      driver = new ChromeDriver();
//      //여기까지 process 추가한 부분
//      // Selenium을 사용하여 페이지 열기
//      driver.get(Blogs_URL);
//      Thread.sleep(1000); // 페이지가 로드될 시간을 기다립니다.
//
//      // 블로그 리스트 덩어리 한개
//      List<WebElement> elements = driver.findElements(By.cssSelector("div.area-common div.article-content"));
//      List<WebElement> contentElements = driver.findElements(By.cssSelector("p.summary"));
//
//      // 콘텐츠의 크기만큼 가져오기
//      for (int i = 0; i < elements.size(); i++) {
//        WebElement content = elements.get(i); // i번째 요소 가져오기
//        String style = content.findElement(By.cssSelector("a.link-article[data-tiara-image]")).getAttribute("abs:data-tiara-image");
//
//        WebElement eachContent = contentElements.get(i);
//        // 크롤링한 콘텐츠 텍스트 가져오기
//        String contentElement = eachContent.getText();
//
//        // 각각의 콘텐츠 길이 확인 및 자르기
//        String subStringElement = contentElement.length() > 255
//            ? contentElement.substring(0, 255)
//            : contentElement; // 길이 확인 후 자르기
//
//        BlogsDTO blogs = BlogsDTO.builder()
//            .image(style) // 이미지 URL
//            .url(content.findElement(By.tagName("a")).getAttribute("href")) // 링크 URL
//            .title(content.findElement(By.cssSelector("strong.title")).getText()) // 제목
//            .content(subStringElement) // 내용
//            .date(content.findElement(By.cssSelector("span.date")).getText()) // 날짜
//            .build();
//
//        blogsList.add(blogs);
//      }
//
//      // 데이터베이스에 저장
//      blogsRepository.saveAll(blogsList);
//    } catch (InterruptedException e) {
//      // 예외 처리 로직
//      logger.error("Error while crawling blogs: {}", e.getMessage());
//      // 예외가 발생했을 경우 빈 리스트를 반환할 수 있음
//    } catch (Exception e) {
//      logger.error("Unexpected error: {}", e.getMessage());
//    }
//    return blogsList;
//  }


@PostConstruct
  public List<BlogsDTO> getBlogsDatas() throws IOException {
      List<BlogsDTO> blogsList = new ArrayList<>();
    try {
      Document document = Jsoup.connect(Blogs_URL).get();

      //블로그 리스트 덩어리 한개
      Elements contents = document.select("div.area-common div.article-content");
      //int Blog_size = Math.min(contents.size(), 4); // contents의 크기와 4 중 작은 값 선택
      Elements content_element_substring = document.select("p.summary"); // 크롤링한 텍스트 가져오기


      //콘텐츠의 크기만큼 가져오기
      for (int i = 0; i <contents.size(); i++) {
        Element content = contents.get(i); // i번째 요소 가져오기
        String style = content.select("a.link-article[data-tiara-image]").attr("abs:data-tiara-image");

        Element each_content = content_element_substring.get(i);
        // 크롤링한 콘텐츠 텍스트 가져오기
        String content_element = each_content.text();

        // 각각의 콘텐츠 길이 확인 및 자르기
        String subStringElement = content_element.length() > 255
            ? content_element.substring(0, 255)
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
        Blogs blogsEntity = blogs.createItem();
        blogsRepository.save(blogsEntity);
      }
      //System.out.println("for 문 밖에서 값을 가져오는가? : "+ contents.select("p.thumbnail").attr("style"));
      // 데이터베이스에 저장.

    } catch (IOException e) {
      // 예외 처리 로직.
      logger.error("Error while crawling blogs: {}", e.getMessage());
      // 예외가 발생했을 경우 빈 리스트를 반환할 수 있음.
      return Collections.emptyList();
    }
      return blogsList;
  }


  @Transactional(readOnly = true)
  public Page<Blogs> getListItemPage(Pageable pageable) {
    return blogsRepository.findAll(pageable); //모든 아이템을 가져온다.
//    Page<BlogsDTO> blogsPage = blogsRepository.findAll(pageable); //페이지 제대로 가져오는지 확인
//    System.out.println(String.format("Total pages: %d, Total elements: %d", blogsPage.getTotalPages(), blogsPage.getTotalElements()));
//    return blogsPage;
  }

  public void saveCrawledBlogs(List<Blogs> blogs) {
    blogsRepository.saveAll(blogs);
  }
}