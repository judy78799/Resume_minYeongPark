package com.eco.Resume.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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
      String[] str = elem.text().split(" ");  //?

      Elements articlelist = doc.select(".article-content");
      //하나씩 가져오는 방법.
      String ar_title = articlelist.get(1).text();
      elem.forEach(element -> result.append(element.text()).append("\n"));
      //for (Element element : elem) {
      //  String dataTiaraName = element.attr("data-tiara-name"); // data-tiara-name 속성 값 가져오기
      //  result.append(dataTiaraName).append("\n"); // 결과에 추가
     // }

      System.out.println("ar_title은? :" + ar_title);
    } catch (IOException e) {
      e.printStackTrace();
      return "크롤링 중 오류가 발생했습니다."; // 오류 발생 시 메시지 반환
    }
    return result.toString(); // 최종 결과를 반환
  }
}
