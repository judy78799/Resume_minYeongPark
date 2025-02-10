# ✏️Resume
## 박민영의 이력서입니다.
SpringBoot(JDK 17) / JSOUP / Ajax / AWS(EC2+RDS)
<br>

## ⌛개발기간
2025.1.21~2025.1.28(약 7일)

## ⚙️개발 환경
<table>
    <tr>
      <th>속성</th>
      <th>버전/도구</th>
    </tr>
    <tr>
      <td>Java</td>
      <td>OpenJDK 17</td>
    </tr>
    <tr>
      <td>Gradle</td>
      <td>8.11.1</td>
    </tr>
    <tr>
      <td>IDE</td>
      <td>IntelliJ IDEA 2024.2.3</td>
    </tr>
    <tr>
      <td>FrameWork</td>
      <td>springBoot 3.4.1</td>
    </tr>
    <tr>
      <td>DB</td>
      <td>MySQL 8.0.33</td>
    </tr>
</table>

## 🖊️디자인
<a style="display: flex;" href="https://www.figma.com/?gad_source=1&gclid=Cj0KCQjwsoe5BhDiARIsAOXVoUsJka6YCtrhkvqra87DUVNSvr2kxpOmVRkQsI5u3MVyym41FojenhcaAujSEALw_wcB">Figma </a> 

<div style="display: flex;">
  <h2>Main Stack</h2>
  <img src="https://img.shields.io/badge/intellijidea-F57C00?style=flat&logo=intellijidea&logoColor=#white"/>
  <img src="https://img.shields.io/badge/gradle-02303A?style=flat&logo=gradle&logoColor=#white"/>
  <img src="https://img.shields.io/badge/Java-007396?style=flat&logo=OpenJDK&logoColor=white"/>
  <img src="https://img.shields.io/badge/Springboot-6DB33F?style=flat&logo=Springboot&logoColor=#white"/>
  <img src="https://img.shields.io/badge/Html5-E34F26style=flat&logo=Html5&logoColor=#white"/>
  <img src="https://img.shields.io/badge/css3-1572B6?style=flat&logo=css3&logoColor=#white"/>
  <img src="https://img.shields.io/badge/javaScript-F7DF1E?style=flat&logo=javaScript&logoColor=#black"/>
  <img src="https://img.shields.io/badge/github-181717?style=flat&logo=github&logoColor=#white"/>
  <img src="https://img.shields.io/badge/mysql-003545?style=flat&logo=mysql&logoColor=#white"/>

  <div style="display:flex;">  
  <h2>Library</h2>
  <img src="https://img.shields.io/badge/Jsoup-003545?style=flat&logo=Jsoup&logoColor=#white"/>
  <img src="https://img.shields.io/badge/thymeleaf-005F0F?style=flat&logo=Thymeleaf&logoColor=#white"/>
  <img src="https://img.shields.io/badge/git-F05032?style=flat&logo=git&logoColor=#white"/>

## ✏️컨텐츠 내용
- 자기소개
- 나의장점
- 교육 및 직무역량
- 지원동기
- Information Card
  - About Me
  - Activities
  - Education & Study
  - Work
- Skills (기술설명 탭 + 한눈에 보기 탭)
- 기술 블로그(JSOUP 크롤링 + Ajax) 

## ✏️주요 기능
### 블로그 JSOP 크롤링
보다 빠른 크롤링 작업을 수행하기 위해 JSOUP 라이브러리를 사용하여 제 개인블로그 정적 데이터만을 불러오고자 구현하였습니다.
### 블로그 데이터
이력서에서 데이터베이스를 사용하기 위해 SpringBoot에 엔티티를 하나 만들어 MySQL에 데이터를 넣어주었습니다.
### 블로그 데이터 Ajax 처리
Ajax GET 요청을 통해 데이터베이스에 저장되어 있는 데이터들을 가져와서 Javascript로 태그를 동적으로 생성하여 화면에 보여지도록 하였습니다.
### 블로그 데이터 Ajax 페이지네이션
Ajax를 사용하여 데이터 GET 요청과 함께 한 화면 당 4개의 데이터를 5페이지게 걸쳐 보여지도록 구성하였습니다. 화면의 깜빡거림 없이 이동이 가능하며, 왼쪽 및 오른쪽 화살표로 화면 이동이 가능합니다.
### 블로그 데이터 크롤링 단위 테스트
크롤링 데이터 단위 테스트를 통해 JSOUP과 Selenium 중 성능 이슈로 JSOUP을 선정하여 구현하였습니다. (<a href="https://judy0465.tistory.com/150">JSOUP vs Selenium 단위 테스트</a>)
### AWS 배포
AWS의 EC2 인스턴스와 RDS를 사용하여 웹페이지를 배포하였습니다.(http://3.34.189.18:8080/ -> 현재는 비용이슈로 인스턴스 삭제하였습니다.)


## 📁파일 구조
```
D:.
│  .gitattributes
│  .gitignore
│  build.gradle
│  gradlew
│  gradlew.bat
│  HELP.md
│  README.md
│  settings.gradle
│  
├─.gradle
│  │  file-system.probe
│  │  
│  ├─8.11.1
│  │  │  gc.properties
│  │  │  
│  │  ├─checksums
│  │  │      checksums.lock
│  │  │      md5-checksums.bin
│  │  │      sha1-checksums.bin
│  │  │      
│  │  ├─executionHistory
│  │  │      executionHistory.bin
│  │  │      executionHistory.lock
│  │  │      
│  │  ├─expanded
│  │  ├─fileChanges
│  │  │      last-build.bin
│  │  │      
│  │  ├─fileHashes
│  │  │      fileHashes.bin
│  │  │      fileHashes.lock
│  │  │      resourceHashesCache.bin
│  │  │      
│  │  └─vcsMetadata
│  ├─buildOutputCleanup
│  │      buildOutputCleanup.lock
│  │      cache.properties
│  │      outputFiles.bin
│  │      
│  └─vcs-1
│          gc.properties
│          
├─.idea
│  │  .gitignore
│  │  compiler.xml
│  │  dbnavigator.xml
│  │  gradle.xml
│  │  jarRepositories.xml
│  │  misc.xml
│  │  modules.xml
│  │  uiDesigner.xml
│  │  vcs.xml
│  │  workspace.xml
│  │  
│  └─modules
│          Resume.main.iml
│          
├─build
│  │  resolvedMainClassName
│  │  
│  ├─classes
│  │  └─java
│  │      ├─main
│  │      │  └─com
│  │      │      └─eco
│  │      │          └─Resume
│  │      │              │  ResumeApplication.class
│  │      │              │  
│  │      │              ├─constant
│  │      │              │      Role.class
│  │      │              │      
│  │      │              ├─controller
│  │      │              │      BlogApiController.class
│  │      │              │      MainController.class
│  │      │              │      TestController.class
│  │      │              │      
│  │      │              ├─dto
│  │      │              │      BlogsDTO$BlogsDTOBuilder.class
│  │      │              │      BlogsDTO.class
│  │      │              │      BlogsScrapDTO.class
│  │      │              │      ImageUrlRequest.class
│  │      │              │      
│  │      │              ├─entity
│  │      │              │      BaseEntity.class
│  │      │              │      BaseTimeEntity.class
│  │      │              │      Blogs.class
│  │      │              │      
│  │      │              ├─initializer
│  │      │              │      DataInitializer.class
│  │      │              │      
│  │      │              ├─repository
│  │      │              │      BlogsRepository.class
│  │      │              │      
│  │      │              ├─restTemplate
│  │      │              │      AppConfig.class
│  │      │              │      
│  │      │              └─service
│  │      │                      BlogsService.class
│  │      │                      ExternalService.class
│  │      │                      
│  │      └─test
│  │          └─com
│  │              └─eco
│  │                  └─Resume
│  │                          CrawlingServiceTest.class
│  │                          ResumeApplicationTests.class
│  │                          
│  ├─generated
│  │  └─sources
│  │      ├─annotationProcessor
│  │      │  └─java
│  │      │      ├─main
│  │      │      └─test
│  │      └─headers
│  │          └─java
│  │              ├─main
│  │              └─test
│  ├─libs
│  │      Resume-0.0.1-SNAPSHOT-plain.jar
│  │      Resume-0.0.1-SNAPSHOT.jar
│  │      
│  ├─reports
│  │  └─tests
│  │      └─test
│  │          │  index.html
│  │          │  
│  │          ├─classes
│  │          │      com.eco.Resume.CrawlingServiceTest.html
│  │          │      com.eco.Resume.ResumeApplicationTests.html
│  │          │      
│  │          ├─css
│  │          │      base-style.css
│  │          │      style.css
│  │          │      
│  │          ├─js
│  │          │      report.js
│  │          │      
│  │          └─packages
│  │                  com.eco.Resume.html
│  │                  
│  ├─resources
│  │  └─main
│  │      │  application.properties
│  │      │  
│  │      ├─driver
│  │      ├─static
│  │      │  ├─css
│  │      │  │      common.css
│  │      │  │      footer.css
│  │      │  │      header.css
│  │      │  │      information.css
│  │      │  │      main.css
│  │      │  │      skill.css
│  │      │  │      
│  │      │  ├─img
│  │      │  │      artInHome.png
│  │      │  │      back.png
│  │      │  │      default-img.png
│  │      │  │      ecoLogo.png
│  │      │  │      faceImg.png
│  │      │  │      next.png
│  │      │  │      plasticWorld.png
│  │      │  │      publicApi.png
│  │      │  │      tourUs.png
│  │      │  │      
│  │      │  └─javascript
│  │      │          blogPagination.js
│  │      │          information.js
│  │      │          skill.js
│  │      │          
│  │      └─templates
│  │          │  main.html
│  │          │  
│  │          ├─fragments
│  │          │      footer.html
│  │          │      header.html
│  │          │      
│  │          ├─layout
│  │          │      layout.html
│  │          │      
│  │          └─member
│  │                  login.html
│  │                  memberForm.html
│  │                  memberRegisterForm.html
│  │                  myPage.html
│  │                  
│  ├─test-results
│  │  └─test
│  │      │  TEST-com.eco.Resume.CrawlingServiceTest.xml
│  │      │  TEST-com.eco.Resume.ResumeApplicationTests.xml
│  │      │  
│  │      └─binary
│  │              output.bin
│  │              output.bin.idx
│  │              results.bin
│  │              
│  └─tmp
│      ├─bootJar
│      │      MANIFEST.MF
│      │      
│      ├─compileJava
│      │      previous-compilation-data.bin
│      │      
│      ├─compileTestJava
│      │      previous-compilation-data.bin
│      │      
│      ├─jar
│      │      MANIFEST.MF
│      │      
│      └─test
├─gradle
│  └─wrapper
│          gradle-wrapper.jar
│          gradle-wrapper.properties
│          
└─src
    ├─main
    │  ├─java
    │  │  └─com
    │  │      └─eco
    │  │          └─Resume
    │  │              │  ResumeApplication.java
    │  │              │  
    │  │              ├─config
    │  │              │      CustomAuthenticationEntryPoint.java
    │  │              │      SecurityConfig.java
    │  │              │      
    │  │              ├─constant
    │  │              │      Role.java
    │  │              │      
    │  │              ├─controller
    │  │              │      BlogApiController.java
    │  │              │      MainController.java
    │  │              │      MemberController.java
    │  │              │      TestController.java
    │  │              │      
    │  │              ├─driver
    │  │              │      WebDriverConfig.java
    │  │              │      
    │  │              ├─dto
    │  │              │      BlogsDTO.java
    │  │              │      BlogsScrapDTO.java
    │  │              │      ImageUrlRequest.java
    │  │              │      MemberDTO.java
    │  │              │      
    │  │              ├─entity
    │  │              │      BaseEntity.java
    │  │              │      BaseTimeEntity.java
    │  │              │      Blogs.java
    │  │              │      BlogsScrap.java
    │  │              │      Member.java
    │  │              │      
    │  │              ├─initializer
    │  │              │      DataInitializer.java
    │  │              │      
    │  │              ├─repository
    │  │              │      BlogsRepository.java
    │  │              │      BlogsScrapRepository.java
    │  │              │      MemberRepository.java
    │  │              │      
    │  │              ├─restTemplate
    │  │              │      AppConfig.java
    │  │              │      
    │  │              └─service
    │  │                      BlogCrawlingService.java
    │  │                      BlogScrapService.java
    │  │                      BlogsService.java
    │  │                      CrawlingExample.java
    │  │                      ExternalService.java
    │  │                      MemberService.java
    │  │                      
    │  └─resources
    │      │  application.properties
    │      │  
    │      ├─driver
    │      ├─static
    │      │  ├─css
    │      │  │      common.css
    │      │  │      footer.css
    │      │  │      header.css
    │      │  │      information.css
    │      │  │      main.css
    │      │  │      skill.css
    │      │  │      
    │      │  ├─img
    │      │  │      artInHome.png
    │      │  │      back.png
    │      │  │      default-img.png
    │      │  │      ecoLogo.png
    │      │  │      faceImg.png
    │      │  │      next.png
    │      │  │      plasticWorld.png
    │      │  │      publicApi.png
    │      │  │      tourUs.png
    │      │  │      
    │      │  └─javascript
    │      │          blogPagination.js
    │      │          information.js
    │      │          skill.js
    │      │          
    │      └─templates
    │          │  main.html
    │          │  
    │          ├─fragments
    │          │      footer.html
    │          │      header.html
    │          │      
    │          ├─layout
    │          │      layout.html
    │          │      
    │          └─member
    │                  login.html
    │                  memberForm.html
    │                  memberRegisterForm.html
    │                  myPage.html
    │                  
    └─test
        └─java
            └─com
                └─eco
                    └─Resume
                            CrawlingServiceTest.java
                            ResumeApplicationTests.java
                            
```
