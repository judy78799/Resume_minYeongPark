package com.eco.Resume.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalService {
  @Autowired
  private RestTemplate restTemplate;

  public String fetchData(String url) {
    return restTemplate.getForObject(url, String.class);
  }
}
