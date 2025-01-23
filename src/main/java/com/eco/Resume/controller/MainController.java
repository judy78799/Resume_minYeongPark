package com.eco.Resume.controller;

import com.eco.Resume.dto.ImageUrlRequest;
import com.eco.Resume.service.ExternalService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.zip.GZIPInputStream;


@Controller
public class MainController {

  @Autowired
  private ExternalService externalService;

  //클래스 생성자
  public MainController(ExternalService externalService) {
    this.externalService = externalService;
  }

  @GetMapping("/")
  public String main(Model model){
  //text키 값은 get 방식으로 추출할 수도 있음.
//    String url = "http://121.130.28.118:8080/BTLMS/ALPAS_TEST.do?name=박민영";
//    String result = externalService.fetchData(url); //JSON응답을 가져옴.
//    System.out.println("result는 ? " + result);
//
//    //텍스트 추출
//    try {
//      ObjectMapper objectMapper = new ObjectMapper();
//      JsonNode jsonNode = objectMapper.readTree(result);
//
//      // 'text' 요소 추출
//      String text = jsonNode.get("text").asText();
//
//      // 모델에 추가
//      model.addAttribute("text", text);
//    } catch (Exception e) {
//      e.printStackTrace();
//      model.addAttribute("text", "Error parsing JSON");
//    }

    return "main";  // main.html로 이동
  }

  //POST 처리 로직
  @PostMapping("/uploadImageUrl")
  @ResponseBody // JSON 형식으로 응답할 것을 명시
  public String uploadImageUrl(@RequestBody ImageUrlRequest request) {
    String requestUrl = request.getImgUrl(); // 클라이언트가 보낸 URL을 가져옴. img + text (DTO 객체안의 JSON 데이터임.)
    String imgBase64 = "";
    String textVal = "";
    System.out.println("JSON.stringify({ imgUrl: requestUrl })의 requestUrl 값은 무엇일까요? " + requestUrl);
    try {
      // URL로부터 JSON 데이터 가져오기
      URL url = new URL(requestUrl);
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
}


