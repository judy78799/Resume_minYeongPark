//package com.eco.Resume.service;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class CrawlingExample {
//
//  private static final String url = "https://yourei.jp/腕を磨く";
//  public void process() {
//    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Desktop\\chromedriver.exe");
//    //크롬 드라이버 셋팅 (드라이버 설치한 경로 입력)
//
//    driver = new ChromeDriver();
//    //브라우저 선택
//
//    try {
//      getDataList();
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//
//    driver.close();	//탭 닫기
//    driver.quit();	//브라우저 닫기
//  }
//
//
//  /**
//   * data가져오기
//   */
//  public List<String> getDataList() throws InterruptedException {
//    List<String> list = new ArrayList<>();
//
//    driver.get(url);    // 브라우저에서 url로 이동한다.
//    Thread.sleep(1000); // 브라우저 로딩될 때까지 잠시 기다린다.
//
//    List<WebElement> elements = driver.findElements(By.cssSelector("#sentence-example-list .sentence-list li"));
//    for (WebElement element : elements) {
//      String text = element.getText(); // 텍스트 가져오기
//      list.add(text); // 리스트에 추가
//      System.out.println("----------------------------");
//      System.out.println(text); // 텍스트 출력
//    }
//
//    return list; // 수정된 부분
//  }
//
//
//}