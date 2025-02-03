//package com.eco.Resume.config;
//
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity(prePostEnabled = true)
//public class SecurityConfig {
//
//  @Bean
//  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    // 로그인 설정
//    System.out.println("------------SecurityFilterChain 영역임.");
//    http
//        .formLogin(form -> form
//            .loginPage("/members/login")
//            .defaultSuccessUrl("/")
//            .usernameParameter("email")
//            .failureUrl("/members/login/error")
//        )
//        .logout(logout -> logout
//            .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
//            .logoutSuccessUrl("/")
//        );
//
//    // 권한 설정
//    // 권한 설정
//    http.authorizeHttpRequests(authorize -> authorize
//        // 2. 관리자와 사용자 권한이 필요한 URL 패턴
////        .requestMatchers(
////         //   "/myPage"
////        ).hasAnyRole("USER")
//        // 3. 모든 사용자가 접근 가능한 URL 패턴 (로그인 불필요)
//        .requestMatchers(
//            "/**",
//            "/members/**",
//            "/img/**",
//            "/uploadImageUrl",
//            "/uploadImageUrl/**"
//        ).permitAll()
//        // 그 외 모든 요청은 인증 필요
//        .anyRequest().authenticated()
//    );
//
//    // 예외 처리
//    http.exceptionHandling(exceptionHandling ->
//        exceptionHandling.authenticationEntryPoint(new CustomAuthenticationEntryPoint())
//    );
//
//    return http.build();
//  }
//
//  @Bean
//  public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//  }
//
//  @Bean
//  public WebSecurityCustomizer webSecurityCustomizer() {
//    return (web) -> web.ignoring()
//        .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//  }
//
//  @Bean
//  public AuthenticationSuccessHandler authenticationSuccessHandler() {
//    return null; // 필요한 경우 구현
//  }
//}
