package com.eco.Resume.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriverConfig {

  @Bean
  public WebDriver webDriver() {
    System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe"); // 드라이버 경로 설정
    ChromeOptions options = new ChromeOptions();
    options.addArguments(
        "--remote-allow-origins=*",
        "--headless",
        "--disable-gpu",  //불필요한 스크립트나 스타일을 비활성화하여 페이지 로딩 속도를 높이기.
        "--disable-extensions"  //불필요한 스크립트나 스타일을 비활성화하여 페이지 로딩 속도를 높이기.
        ); // 필요한 옵션 설정

    return new ChromeDriver(options);
  }
}
