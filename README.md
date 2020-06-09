# 포털서비스 개발 방법론 기말고사



## 도구

SpringBoot, SPring MVC, JPA, Mysql을 활용



## UI

Rest Api + JavaScript 또는 UI Template 활용



## 발표

6월 26일 오후 4시 1:1 면담 방식으로 실제 구현되는 환경 발표



## 특이사항

- commit 로그 자주 남기기



## 계획

- ~ 6.09 : 주제 선별

- 6.10 ~ 6.13 : 기본적인 템플릿 생성

- 6.14 ~ 6.21 : 백엔드 개발

- 6.22 ~ 6.25 : 프로젝트 수정 및 보완, 발표 준비

- 6.26 : 프로젝트 발표



## 주제 : Diarygram

- SNS와 다이어리 특징을 섞은 서비스

- DB
  - User(id / username / password)
  - Post(title / content / image / user / created_at)
  - Like(like / post / user)
  - Comment(content / post / user / created_at)
- 기능
  - 회원가입 / 로그인 / 로그아웃
  - 게시물 작성
  - 내 게시물 보기
  - 다른 사람의 게시물 보기
  - 좋아요
    - 게시물을 누르면 좋아요, 다시 누르면 좋아요 취소
  - 댓글

