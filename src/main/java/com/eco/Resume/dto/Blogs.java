package com.eco.Resume.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class Blogs {
  private String image;
  private String url;
  private String title;
  private String content;
  private String date;
}
