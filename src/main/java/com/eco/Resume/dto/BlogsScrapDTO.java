package com.eco.Resume.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class BlogsScrapDTO {
  private Long id;
  private Long memberId;  // 엔티티 대신 ID 사용
  private Long megazineId; // 엔티티 대신 ID 사용
}
