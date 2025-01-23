package com.eco.Resume.controller;

import com.eco.Resume.dto.ImageUrlRequest;
import com.eco.Resume.service.ExternalService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
    String url = "http://121.130.28.118:8080/BTLMS/ALPAS_TEST.do?name=박민영";
    String result = externalService.fetchData(url); //JSON응답을 가져옴.
    System.out.println("result는 ? " + result);

    //텍스트 추출
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode jsonNode = objectMapper.readTree(result);

      // 'text' 요소 추출
      String text = jsonNode.get("text").asText();

      // 모델에 추가
      model.addAttribute("text", text);
    } catch (Exception e) {
      e.printStackTrace();
      model.addAttribute("text", "Error parsing JSON");
    }

    //이미지 추출
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode jsonNode = objectMapper.readTree(result);

      // 'image' 요소 추출
      String img = jsonNode.get("img").asText();
      // 모델에 추가
      model.addAttribute("img", img);
      saveImage(img); // // 이미지 디코딩 및 저장
    } catch (Exception e) {
      e.printStackTrace();
      model.addAttribute("img", "Error parsing JSON");
    }

    return "main";  // main.html로 이동
  }

/*
  private void saveImage(String base64Image) {
    // Base64 문자열이 유효한지 확인
    if (base64Image != null && !base64Image.isEmpty()) {
      try {
        // Base64 디코딩
        byte[] imageBytes = Base64.getDecoder().decode(base64Image);

        // 이미지 파일로 저장
        try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/decodedImage.png")) {
          fos.write(imageBytes);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("유효하지 않은 이미지 데이터입니다.");
    }
  }
*/

  // POST 요청을 처리하는 메서드 추가
//  @PostMapping("/")
//  public String uploadImage(@RequestBody ImageUploadRequest request) {
//    String base64Image = request.getImg(); // 요청에서 Base64 이미지 문자열 가져오기
//    saveImage(base64Image); // 이미지 저장 메서드 호출
//    return "이미지가 성공적으로 저장되었습니다."; // 응답 반환
//  }

  //클라이언트에서 Url 입력 요청 -> Post로 값을 받아와서 처리 -> 브라우저(클라)에서 결과물 확인
  @PostMapping("/")
  public String uploadImageUrl(@RequestBody ImageUrlRequest request) {
    String imageUrl = request.getImgUrl(); // 클라이언트가 보낸 URL을 가져옴
    // URL로부터 이미지를 가져오는 로직 추가
    return "이미지를 성공적으로 처리했습니다."; // 응답 반환
  }

  private void saveImage(String base64Image) {
    // Base64 문자열이 유효한지 확인
    if (base64Image != null && !base64Image.isEmpty()) {
      try {
        // Base64 디코딩
        byte[] imageBytes = Base64.getDecoder().decode(base64Image);

        // 이미지 파일로 저장
        try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/decodedImage.png")) {
          fos.write(imageBytes);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("유효하지 않은 이미지 데이터입니다.");
    }
  }
}

// 요청 DTO 클래스
class ImageUploadRequest {
  private String img;

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }
}


