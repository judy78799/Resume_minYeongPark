package com.eco.Resume.controller;
import com.eco.Resume.dto.ImageUrlRequest;
import com.eco.Resume.entity.Blogs;
import com.eco.Resume.service.BlogsService;
import com.eco.Resume.service.ExternalService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; // SLF4J Logger 임포트
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable; // 올바른 import
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Controller
@RequiredArgsConstructor
public class MainController {

  @Autowired
  private ExternalService externalService;

  @Autowired
  private BlogsService blogsService;

  private static final Logger logger = LoggerFactory.getLogger(MainController.class);  //클래스 생성자

  @GetMapping("/")
  public String main(Model model, Principal principal, @PageableDefault(page = 0, size = 4, sort = "date", direction = Sort.Direction.ASC) Pageable pageable) throws Exception{

    //날짜와 시간을 표기해주기 위해 LocalDateTime 사용함.
    LocalDateTime now = LocalDateTime.now();
    String formatNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
    System.out.println(formatNow);
    model.addAttribute("now", formatNow);

//    //블로그 크롤링 데이터
//    Page<Blogs> list;
//    list = blogsService.getListItemPage(pageable); // 메인페이지 리스트 부분
//
//    model.addAttribute("list", list);
//
//    int nowPage = list.getPageable().getPageNumber() + 1; // 현재 페이지
//    int startPage = Math.max(nowPage - 4, 1);
//    int endPage = Math.min(nowPage + 5, list.getTotalPages());
//
//    model.addAttribute("nowPage", nowPage);
//    model.addAttribute("startPage", startPage);
//    model.addAttribute("endPage", endPage);
//    model.addAttribute("maxPage", 5); // 한 화면에 5개의 페이지네이션
    return "main";  // main.html로 이동
  }


  //POST 처리 로직
  @CrossOrigin(origins = "*") // 모든 출처에서 요청을 허용
  @PostMapping("/uploadImageUrl")
  @ResponseBody // JSON 형식으로 응답할 것을 명시함.
  public String uploadImageUrl(@RequestBody ImageUrlRequest request) {
    String requestUrl = request.getImgUrl(); // 클라이언트가 보낸 URL을 가져옴. img + text (DTO 객체안의 JSON 데이터임.)
    String imgBase64 = "";  //img 키 값 추출을 위한 변수
    String textVal = "";    //texts 키 값 추출을 위한 변수
    System.out.println("JSON.stringify({ imgUrl: requestUrl })의 requestUrl 값은 무엇일까요? " + requestUrl);
    try {
      //Url 디코딩
      requestUrl = URLDecoder.decode(requestUrl, StandardCharsets.UTF_8.name());  //URL 디코딩 진행.
      // URL로부터 JSON 데이터 가져오기
      URL url = new URL(requestUrl);  //get 요청 보낼 때의 Url
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.connect();

      // HTTP 응답 코드 확인
      if (connection.getResponseCode() != 200) {
        throw new IOException("Failed to fetch data from URL: " + connection.getResponseCode());
      }

      // JSON 응답 파싱
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode jsonResponse = objectMapper.readTree(connection.getInputStream());

      // JSON 응답 로그 출력 ("img" + "text" 키 값)
      System.out.println("JSON 응답: " + jsonResponse.toString());  //jsonResponse 결과값: "img" 키 + "text" 키

      // img 키가 존재하는지 확인 테스트
      if (!jsonResponse.has("img")) {
        throw new IOException("JSON 응답에 img 키가 없습니다.");
      }else{
        System.out.println("JSON 응답에 img 키가 존재합니다.");
      }

      imgBase64 = jsonResponse.get("img").asText(); // JSON 응답에서 img 키에 해당하는 값, 즉 Base64로 인코딩된 이미지 데이터를 나타냄. AAA...
        System.out.println("클라이언트에서 받아온 JSON 응답의 img 키, imgBase64의 값은? " + imgBase64); // URL의 값 중, "img" 키의 값 제대로 가져와짐.
      textVal = jsonResponse.get("text").asText(); // JSON 응답에서 text 키에 해당하는 값, 즉 Base64로 인코딩된 이미지 데이터를 나타냄. AAA...

      // 올바른 형식으로 변환 브라우저에 이미지로 보여지기 위해 "data:image/png;base64," 접두사를 추가
      //추가한 접두사임 data:image/png;base64
      String base64Image = "data:image/png;base64," + imgBase64; // PNG 형식으로 가정

      // 만약 JSON 응답이 null이라면, 각각 키 값을 확인.
      if (imgBase64 == null || imgBase64.isEmpty()) {
        throw new IOException("img 키는 null 입니다.");
      }else{
        System.out.println("img 키는 null이 아닙니다.");
      }
      if (textVal == null || textVal.isEmpty()) {
        throw new IOException("text 키는 null 입니다.");
      }else{
        System.out.println("text 키는 null이 아닙니다.");
      }

      // JSON 형식으로 반환
      ObjectNode responseNode = objectMapper.createObjectNode();
      responseNode.put("img", base64Image); // img 키에 올바른 Base64 문자열 할당
      responseNode.put("text", textVal);  //text 키에 textVal 값 할당.
      return objectMapper.writeValueAsString(responseNode); // JSON 문자열로 반환

      //이 수정된 코드를 사용하면 서버에서 반환되는 JSON 형식이 {"img":"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAUA..."}와 같이 된다.
      //그럼 이 코드를 가지로 main.html의 img 태그에 출력하게 된다.
    } catch (Exception e) {
      e.printStackTrace(); // 오류 로그 출력
      return "Error fetching image: " + e.getMessage(); // 에러 메시지 반환
    }
  }


//  @PostMapping("/crawl")
//  public ResponseEntity<String> crawlBlogs() {
//    try {
//      // 크롤링 및 저장
//      List<BlogsDTO> blogs = blogsService.getBlogsDatas();
//      //blogsService.saveCrawledBlogs(blogs);
//      return ResponseEntity.ok("블로그 크롤링 및 저장 성공.");
//    } catch (IOException e) {
//      logger.error("블로그 크롤링 중 에러 발생: {}", e.getMessage());
//      return ResponseEntity.status(500).body("블로그 크롤링 실패: " + e.getMessage());
//    } catch (Exception e) {
//      logger.error("알 수 없는 에러 발생: {}", e.getMessage());
//      return ResponseEntity.status(500).body("알 수 없는 에러 발생: " + e.getMessage());
//    }
//  }

}


