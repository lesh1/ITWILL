
# 쿠키 (p.279)
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
 크롬 쿠키가 저장되는 HDD 공간
 C:/Users/ITWILL/AppData/Local/Google/Chrom/User Data/Default/Cache
	
(이스케이프문자<유니코드>)예시
System.out.println("\uC548\uB155\uD558\uC138\uC694");

```
### cookieTest.jsp
```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
		// 쿠키값 사용하기 (받아오기)
		Cookie[] cookies= request.getCookies();
		
		String name="";
		String value="";
		
		if(cookies != null){
			for(int i=0;i<cookies.length;i++)
			{
				// 특정 쿠키정보를 가져오기 => 쿠키의 이름만 비교해서 값을 사용
				if(cookies[i].getName().equals("CookName"))
				{
					name=cookies[i].getName();
					value=cookies[i].getValue();
				}
			}
		}
	%>
		<h2>쿠키 이름: <%=name %>, 쿠키값: <%=value %></h2>
	<hr/>
	<h2>클라이언트</h2>
	<input type="button" value="쿠키값생성(저장)" onclick="location.href='cookieSet.jsp'"><br/>
	<input type="button" value="쿠키값 삭제" onclick="location.href='cookieDel.jsp'"><br/>
</body>
</html>	
```
### cookieSet.jsp
```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>서버</h2>
<%
	// 쿠키 객체 생성(쿠키값 생성) - 서블릿API 활용
	// Cookie cookie = new Cookie("이름","값");
	// 메모리에는 올라가 있음. 클라이언트 HDD에는 저장이 되어있지 않음

	Cookie cookie = new Cookie("CookName","cookieValue");

	// 필요한 설정

	cookie.setMaxAge(600); // 600초 --> 10분

	// 클라이언트에 전달(응답객체에 담아서)

	response.addCookie(cookie);
%>

<script type="text/javascript">
	alert("쿠키값 생성! & 응답객체에 저장후 전달!");
	location.href="cookieTest.jsp";
</script>
</body>
</html>
```
### cookieDel.jsp
```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>서버</h2>
<%
	// 쿠키 객체 생성(쿠키값 생성) - 서블릿API 활용
	// Cookie cookie = new Cookie("이름","값");
	// 메모리에는 올라가 있음. 클라이언트 HDD에는 저장이 되어있지 않음

	Cookie cookie = new Cookie("CookName","cookieValue");

	// 필요한 설정

	cookie.setMaxAge(600); // 600초 --> 10분

	// 클라이언트에 전달(응답객체에 담아서)

	response.addCookie(cookie);
%>

<script type="text/javascript">
	alert("쿠키값 생성! & 응답객체에 저장후 전달!");
	location.href="cookieTest.jsp";
</script>
</body>
</html>
```

### cookieForm.jsp
```
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>WebContent/JSP4/cookieForm.jsp</h1>
   
   <%
     String lang = "";
     // 쿠키값 가져오기
     Cookie[] cookieArr = request.getCookies();
   
     // "lang" 쿠키이름을 가진 값을 가져와서 비교 -> 결과출력
     if(cookieArr != null){
    	 for(int i=0;i<cookieArr.length;i++){
    		 if(cookieArr[i].getName().equals("lang")){
    			 lang = cookieArr[i].getValue();
    		 }    		 
    	 }
     }
     
     // 쿠키값에 따른 비교후 출력
   
   %>
   " 안녕하세요. 쿠키연습! " or " Hello, Cookie Test! " 출력<br>
   <hr>
   <%
      if(lang.equals("kor")){
    	  %>
    	  <h3> 결과 데이터 :  안녕하세요. 쿠키연습!</h3>
    	  <%
      }else{
    	  %>
    	  <h3> 결과 데이터 :  Hello, Cookie Test!</h3>
    	  <%
      }
   %>
   
   <hr>
   
   <form action="cookiePro.jsp" method="get">
	   <input type="radio" name="language" value="kor" 
	     <%
	       if(lang.equals("kor")){
	    	   %>
	    	     checked
	           <%
	       }
	     %>
	   > 한국어
	   <input type="radio" name="language" value="eng"
	      <% if(lang.equals("eng")){ %>  checked  <%    }   %>
	       > 영어
	   <hr>
	   <input type="submit" value="전송">
   </form>

</body>
</html>
```

### cookieFormPro.jsp
```
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h1>WebContent/JSP4/cookiePro.jsp</h1>
    
    <%
      String lang = request.getParameter("language");
    
      // 쿠키값 생성
      Cookie cookie = 
         //new Cookie("lang",lang);
         new Cookie("lang",request.getParameter("language"));
      
      // 쿠키 설정
      cookie.setMaxAge(3600);
      
      // 쿠키를 응답객체에 저장
      response.addCookie(cookie);
    
    %>
    <script type="text/javascript">
         alert("언어 쿠키값 생성! ");
         location.href="cookieForm.jsp";    
    </script>
    
</body>
</html>
```
# MySQL

### MySQL 다운
[MySQL](https://dev.mysql.com/downloads/file/?id=500616)
```
No thanks, just start my download 눌러서 다운
```

### MySQL 설치
```
root 비밀번호  : 1234

Add User

User Name: jspid
Password : jsppass

```
### MySQL5.7 인코딩변경
```
C:\ProgramData\MySQL\MySQL Server 5.7 (경로)

my.ini 파일열기

[mysqld] 아래에서

charater-set-server=utf8

입력후 저장

Window 창에서 '서비스' 프로그램 실행

MySQL57 --> 더블클릭 --> 중지 --> 시작

```

### 환경변수 잡기
```
내PC -> C드라이브 ->Program Files -> MYSQL -> MYSQLServer 5.7- bin

cmd 창에서

mysql -u root -p {입력시}
Enter password: {비밀번호 입력}

mysql -u 계정명 -p -h[서버주소] [db]명
```

### DB 기본 설정값 조회
```
status
```

### 목록 조회
```
show databases;
```

### DB생성
```
create database [DB명];

ex) create database itwill;
```

### DB선택
```
use [DB명];
		ex) use itwill;
```

### DB삭제
```
drop database [DB명];
	ex) drop database itwill;
```

### 수업용 DB만들기
```
create database jspdb;

use jspdb;

```

### 테이블 생성 , 삭제, 조회, 구조확인


#### 테이블 생성
```
create table [테이블명] (
	필드명 데이터타입  (제약조건),
	필드명 데이터타입  (제약조건),
	필드명 데이터타입  (제약조건),
	....
	);

```

## 주의사항
```
		※문자데이터※

오라클 : varchar2
MySQL : varchar


		※숫자데이터※

오라클 : number
MySQL : int
```

### 테이블 조회
```
show tables;
```

### 테이블 삭제
```
drop table [테이블명];
```

### 구조확인
```
desc [테이블명]
```

## 예시

### 테이블 생성 예시
```
create table itwill(
	idx INT
	);
```

### 테이블 조회 예시
```
show tables;
```

### 구조확인 예시
```
desc itwill;
```
### 테이블 삭제 예시
```
drop table itwill;
```