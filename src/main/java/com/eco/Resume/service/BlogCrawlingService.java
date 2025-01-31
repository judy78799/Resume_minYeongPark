//package com.eco.Resume.service;
//
//import com.eco.Resume.dto.BlogsDTO;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.select.Elements;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class BlogCrawlingService {
//  public List<BlogsDTO> crawling() {
//    String URL = "https://judy0465.tistory.com/";
//    Document doc;
//    List<BlogsDTO> blogList = new ArrayList<>(); // 블로그 DTO를 저장할 리스트
//
//    try {
//      doc = Jsoup.connect(URL)
//          .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
//          .get();
//      Elements articleList = document.select("div.area-common div.article-content");
//
//      // 각 블로그 게시물에 대해 DTO 생성
//      for (int i = 0; i < articleList.size(); i++) {
//        String url = articleList.get(i).text();
//        String image = articleList.get(i).text();
//        String title = articleList.get(i).select("h3").text(); // 제목 추출
//        String content = articleList.get(i).text(); // 내용 추출
//        String date = ""; // 날짜를 추출하는 로직 추가 필요
//
//        BlogsDTO blog = new BlogsDTO(url, image, title, content, date); // DTO 생성
//        blogList.add(blog); // 리스트에 추가
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//      // 오류 발생 시 빈 리스트 반환
//      return new ArrayList<>();
//    }
//    return blogList; // 최종 블로그 리스트 반환
//  }
//}
//
