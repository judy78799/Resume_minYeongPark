package com.eco.Resume.entity;

import com.eco.Resume.dto.BlogsDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;


@Entity
@Setter
@Getter
@ToString
public class Blogs {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; //블로그 id

  @Column(nullable = true, length = 1000)
  private String image;

  @Column(nullable = false, length = 500)
  private String url;

  @Column(nullable = false, length = 500)
  private String title;

  @Column(nullable = false, length = 500)
  private String content;

  @Column(nullable = false, length = 100)
  private String date;

  private static ModelMapper modelMapper = new ModelMapper();

  public static BlogsDTO of(Blogs blogs){
    return modelMapper.map(blogs, BlogsDTO.class);
  }
}
