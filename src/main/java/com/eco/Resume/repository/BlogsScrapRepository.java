//package com.eco.Resume.repository;
//
//import com.eco.Resume.entity.Blogs;
//import com.eco.Resume.entity.BlogsScrap;
//import com.eco.Resume.entity.Member;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//
//public interface BlogsScrapRepository extends JpaRepository<BlogsScrap, Long> {
//
//  // 특정 사용자가 스크랩한 상품이 있는지 확인 (Member와 Product 객체 사용)
//  boolean existsByMemberAndBlogs(Member member, Blogs blogs);
//
//  // 특정 사용자가 스크랩한 상품 ID 목록 조회
//  @Query("SELECT ps.blogs.id FROM BlogsScrap bs WHERE bs.member.id = :memberId")
//  List<Long> findBlogsIdsByMemberId(@Param("memberId") Long memberId);
//
//  // 특정 사용자의 스크랩을 삭제 (Member와 Product 객체 사용)
//  void deleteByMemberAndBlogs(Member member, Blogs blogs);
//
//  @Query("SELECT s.blogs FROM BlogsScrap s WHERE s.member.id = :memberId")
//  List<Blogs> findScrapBlogsByMemberId(@Param("memberId") Long memberId);
//}
