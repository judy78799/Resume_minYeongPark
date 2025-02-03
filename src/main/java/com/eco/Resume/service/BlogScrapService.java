//package com.eco.Resume.service;
//
//import com.eco.Resume.entity.Blogs;
//import com.eco.Resume.entity.BlogsScrap;
//import com.eco.Resume.entity.Member;
//import com.eco.Resume.repository.BlogsRepository;
//import com.eco.Resume.repository.BlogsScrapRepository;
//import com.eco.Resume.repository.MemberRepository;
//import jakarta.persistence.EntityNotFoundException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//public class BlogScrapService {
//
//
//  private final MemberRepository memberRepository;
//  private final BlogsRepository blogsRepository;
//  private final BlogsScrap blogsScrap;
//  private final BlogsScrapRepository blogsScrapRepository;
//
//
//  // 스크랩 추가
//  public void addScrap(Long memberId, Long megazineId) {
//    // memberId와 productId를 기반으로 각각 Member와 Product 엔티티 조회
//    Member member = memberRepository.findById(memberId)
//        .orElseThrow(() -> new EntityNotFoundException("회원이 존재하지 않습니다. ID: " + memberId));
//    Blogs blogs = blogsRepository.findById(megazineId)
//        .orElseThrow(() -> new EntityNotFoundException("매거진이 존재하지 않습니다. ID: " + megazineId));
//
//    // 이미 스크랩이 존재하는지 확인
//    if (blogsScrapRepository.existsByMemberAndBlogs(member, blogs)) {
//      throw new IllegalStateException("이미 스크랩된 상품입니다.");
//    }
//
//    // MegazineScrap 엔티티 생성 및 저장
//    BlogsScrap scrap = new BlogsScrap();
//    scrap.setMember(member);  // Member 엔티티 설정
//    scrap.setBlogs(blogs);  // Product 엔티티 설정
//    blogsScrapRepository.save(scrap);
//  }
//
//  // 스크랩 삭제
//  public void removeScrap(Long memberId, Long megazineId) {
//    // memberId와 productId를 기반으로 각각 Member와 Product 엔티티 조회
//    Member member = memberRepository.findById(memberId)
//        .orElseThrow(() -> new EntityNotFoundException("회원이 존재하지 않습니다. ID: " + memberId));
//    Blogs blogs = blogsRepository.findById(megazineId)
//        .orElseThrow(() -> new EntityNotFoundException("상품이 존재하지 않습니다. ID: " + megazineId));
//
//    // MegazineScrap 엔티티 삭제
//    blogsScrapRepository.deleteByMemberAndBlogs(member, blogs);
//  }
//
//  // 특정 사용자가 스크랩한 상품 목록 반환
//  public List<Long> getScrapBlogsIdsForUser(Long memberId) {
//    // memberId를 기반으로 스크랩된 상품 ID 목록 반환
//    return blogsScrapRepository.findBlogsIdsByMemberId(memberId);
//  }
//
//
//  //서버에서 메거진 자체를
//  public List<Blogs> getScrapMegazinesForUser(Long memberId) {
//    return blogsScrapRepository.findScrapBlogsByMemberId(memberId);
//  }
//
//  //새로 추가한 칭긔
//  @Transactional(readOnly = true)
//  public List<Blogs> getScrappedBlogs(Long memberId) {
//    return blogsScrapRepository.findScrapBlogsByMemberId(memberId);
//  }
//}
