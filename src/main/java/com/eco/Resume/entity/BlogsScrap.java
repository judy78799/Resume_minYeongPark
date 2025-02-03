//package com.eco.Resume.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//
//@Entity
//@Getter
//@Setter
//@ToString
//
//public class BlogsScrap extends BaseEntity{
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "megazine_scrap_id")
//  private Long id;
//
//  @ManyToOne
//  @JoinColumn(name = "member_id")
//  private Member member;
//
//  @ManyToOne
//  @JoinColumn(name = "megazine_id")
//  @OnDelete(action = OnDeleteAction.CASCADE)
//  private Blogs blogs;
//}