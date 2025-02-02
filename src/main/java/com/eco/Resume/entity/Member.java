package com.eco.Resume.entity;
import com.eco.Resume.dto.MemberDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@Setter
@ToString
@Table(name = "member") // 테이블 이름 명시 (선택적)
public class Member extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id")
  private Long id;

  @Column(name = "username")
  private String name;

  @Column(unique = true)
  private String email;

  private String password;

  private String address;

  public static Member createMember(MemberDTO memberDTO, PasswordEncoder passwordEncoder) {
    Member member = new Member();
    member.setName(memberDTO.getName());
    member.setEmail(memberDTO.getEmail());
    member.setAddress(memberDTO.getAddress());
    String password = passwordEncoder.encode(memberDTO.getPassword());
    member.setPassword(password);

    return member;
  }
}
