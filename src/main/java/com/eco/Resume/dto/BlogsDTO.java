package com.eco.Resume.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
@Entity
public class BlogsDTO {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; //블로그 id
  private String image;  //블로그 크롤링 이미지
  private String url;   //블로그 크롤링 url
  private String title;   //블로그 크롤링 제목
  private String content;   //블로그 크롤링 내용
  private String date;    //블로그 크롤링 날짜


  public BlogsDTO(Long id, String image, String url, String title, String content, String date) {
    this.id = id;
    this.image = image;
    this.url = url;
    this.title = title;
    this.content = content;
    this.date = date;
  }
}

