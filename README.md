## 박민영의 이력서입니다.

## 개발기간
2025.1.21~2025.1.28 (약 7일)

## ✏️개발 환경
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

## 🖊️ 디자인
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

  <div style="display:flex;">  
  <h2>library</h2>
  <img src="https://img.shields.io/badge/mysql-003545?style=flat&logo=mysql&logoColor=#white"/>
  <img src="https://img.shields.io/badge/thymeleaf-005F0F?style=flat&logo=Thymeleaf&logoColor=#white"/>
  <img src="https://img.shields.io/badge/git-F05032?style=flat&logo=git&logoColor=#white"/>

  ## 파일 구조
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
