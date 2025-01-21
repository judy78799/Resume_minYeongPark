package com.eco.Resume.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {

  @GetMapping("/")
  public String main(){
    return "main";  // main.html로 이동
  }
}
