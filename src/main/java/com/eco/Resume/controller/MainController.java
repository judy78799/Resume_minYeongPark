package com.eco.Resume.controller;

import com.eco.Resume.service.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  @Autowired
  private ExternalService externalService;

  @GetMapping("/")
  public String main(Model model){
    String url = "http://121.130.28.118:8080/BTLMS/ALPAS_TEST.do?name=박민영";
    String result = externalService.fetchData(url);
    model.addAttribute("result", result);
    return "main";  // main.html로 이동
  }
}
