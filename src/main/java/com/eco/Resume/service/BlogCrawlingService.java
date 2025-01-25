package com.eco.Resume.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BlogCrawlingService {
  public String crawling() {
    String URL = "https://judy0465.tistory.com/";
    Document doc;
    StringBuilder result = new StringBuilder(); // StringBuilder 객체 생성

    Elements elem = null;
    try {
      doc = (Document) Jsoup.connect(URL)
          .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
          .get();
      elem = doc.select("div.area-common");

      elem.forEach(element -> result.append(element.text()).append("\n"));


    } catch (IOException e) {
      e.printStackTrace();
      return "크롤링 중 오류가 발생했습니다."; // 오류 발생 시 메시지 반환
    }
    return result.toString(); // 최종 결과를 반환
  }
}
