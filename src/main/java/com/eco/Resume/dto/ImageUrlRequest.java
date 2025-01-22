package com.eco.Resume.dto;

public class ImageUrlRequest {
  private String imgUrl; // 이미지 URL을 저장할 필드

  // 기본 생성자
  public ImageUrlRequest() {
  }

  // getter 메서드
  public String getImgUrl() {
    return imgUrl;
  }

  // setter 메서드
  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }
}