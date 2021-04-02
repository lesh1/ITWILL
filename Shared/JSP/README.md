# 쿠키(p.279~)
```
클라이언트 쪽에서 사용(관리)되는 데이터
생존기간동안 계속해서 유지
하드디스크에 저장 => 보안위협
```

## 사용법 및 용도

```
- 이름, 값, 유효기간, 도메인, 경로..... 생성됨
- 쿠키의 이름은 알파벳+숫자, 쿠키값 - 일반적인 데이터(공백,괄호,세미콜론.. 추가 인코딩)
    
    서버가 해야하는 일
    1) 쿠키를 생성 (객체)
    2) 쿠키안에 필요한 설정을 저장 
       (쿠키유효기간, 설명, 도메인,...)
    3) 웹 브라우저에 생성된 쿠키를 전달
    
    클라이언트가 사용할때 처리되는 동작
    1) 웹 페이지 요청정보에서 쿠키값을 가져옴    
    2) 쿠키 생성 =>  (이름,값) 쌍으로 생성된 배열의 형태로 리턴         
    3) 쿠키 설정값 지정    
    4) 웹 페이지에 응답정보를 사용해서 쿠키를 전달    
    5) 쿠키이름을 사용해서 쿠키의 값을 꺼내서 사용
```
```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	

</body>
</html>
```