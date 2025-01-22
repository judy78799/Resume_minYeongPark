package com.eco.Resume.controller;

import com.eco.Resume.service.ExternalService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    model.addAttribute("result", result);

    try {
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode jsonNode = objectMapper.readTree(result);

      // 'text' 요소 추출
      String text = jsonNode.get("text").asText();

      // 모델에 추가
      model.addAttribute("result", text);
    } catch (Exception e) {
      e.printStackTrace();
      model.addAttribute("result", "Error parsing JSON");
    }

    return "main";  // main.html로 이동
  }
}
