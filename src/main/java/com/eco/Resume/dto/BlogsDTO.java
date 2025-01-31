package com.eco.Resume.dto;
import com.eco.Resume.entity.Blogs;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@ToString
@Builder
public class BlogsDTO {

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

  // 기본 생성자 추가
  public BlogsDTO() {
  }

  public BlogsDTO(String url, String image, String title, String content, String date) {
  }

  private static ModelMapper modelMapper = new ModelMapper();
  //Blog을 -> BlogDTO 로 매핑
  public Blogs createItem(){
    return modelMapper.map(this, Blogs.class);
  }

  //Java에서 ModelMapper라는 라이브러리를 사용하여 객체 간의 변환을 수행하기 위한 객체를 초기화하는 코드
  //객체의 속성을 간편하게 매핑할 수 있습니다.

  public static BlogsDTO of(Blogs blogs){
    return modelMapper.map(blogs, BlogsDTO.class);
  }
}



