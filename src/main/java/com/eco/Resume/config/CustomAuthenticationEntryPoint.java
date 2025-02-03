//package com.eco.Resume.config;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//// Spring Security에서 인증되지 않은 사용자가 보호된 리소스에 접근하려고 할 때의 동작을 정의하는 사용자 정의 클래스
//public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//  // 네트워크 요청은 비동기~~
//  @Override
//  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
//      throws IOException, ServletException {
//
//    // 요청 헤더에서 x-requested-with 값을 확인하여 AJAX 요청인지 판별합니다.
//    if ("XMLHttpRequest".equals(request.getHeader("x-requested-with"))) {
//      response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UnAuthorized"); // 401
//    } else {
//      // AJAX 요청이 아닌 경우, 사용자가 인증되지 않았음을 알리고 로그인 페이지로 리다이렉트합니다.
//      response.sendRedirect("/members/login"); // 나머지는 로그인을 유도하기 위해 리다이렉트
//    }
//  }
//}
//
