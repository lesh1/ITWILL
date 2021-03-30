# testForm-1.jsp

```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<legend>정보 입력</legend>
	<form action="testPro1.jsp" method="get">
		숫자입력 :<input type="text" name="num"><br/>
	<input type="submit" value="전송">
	</form>
</fieldset>
</body>
</html>
```

# testPro1.jsp
```
<%
	//JSP코드(java코드) 작성가능

	// 요청객체(request)로 부터 전달된 정보를 사용

	// 이전페이지에서 전달되는 정보 -> 파라미터 

	// request.getParameter("파라미터명");

	// 전달된 모든 파라미터는 String타입으로 저장됨

%>
```

```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

String num=request.getParameter("num");
int num2=Integer.parseInt(request.getParameter("num"));
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	전달받은 숫자 : <%=num %><br/>
	전달받은 숫자 +100 : <%=num+100 %><br/>
	전달받은 숫자(정수로 변경)+100 : <%=Integer.parseInt(num)+100 %>
</body>
</html>
```
# testForm-2.jsp
```
		사용자의 이름, 나이를 입력받아서 결과를 전달
		testPro2.jsp 페이지에서 결과를 출력
		"이름: ㅇㅇㅇ, 나이 ㅇㅇ"

```

### get 방식
```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <form action="testPro2.jsp" method="get">
	 	이름:<input type="text" name="name"><br/>
	 	나이:<input type="text" name="age"><br/>
	 	<input type="submit" value="전송">
	 </form>
</body>
</html>
```

### post 방식
```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <form action="testPro2.jsp" method="post">
	 	이름:<input type="text" name="name"><br/>
	 	나이:<input type="text" name="age"><br/>
	 	<input type="submit" value="전송">
	 </form>
</body>
</html>
```

# testPro2.jsp
```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String name = request.getParameter("name");
	int age= Integer.parseInt(request.getParameter("age"));
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름:<%=name %>, 나이:<%=age %>
</body>
</html>
```

### get방식 출력 결과
```
이름 : 홍길동 , 나이 :12 

한글데이터 전달시 문제없음
```

### post방식 출력 결과
```
이름:íㅁㅁê¸ㅁ, 나이:123
한글데이터 전달시 문제가 있음
```

### post방식으로 파라미터를 보낼때 값이 깨지지 않도록 하기위해 testPro2.jsp 수정
```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8"); // 추가
	String name = request.getParameter("name");
	int age= Integer.parseInt(request.getParameter("age"));
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름:<%=name %>, 나이:<%=age %>
</body>
</html>
```
# testPro2.jsp 수정

## 회원정보 확인

### 회원의 나이가 20살 미만이면 "수업 참여 불가"

### 회원의 나이가 20살 이상이면 "수업 참여 가능"

```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8"); // 추가
	String name = request.getParameter("name");
	int age= Integer.parseInt(request.getParameter("age"));
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름:<%=name %>, 나이:<%=age %>
	<hr>
	<h2>회원정보 확인</h2>

	<%
		if(age<20)
			{
				out.println("<h3>수업 참여 불가</h3>");
			}
			else
			{
				out.println("<h3>수업 참여 가능</h3>");
			}
	%>
</body>
</html>

```
# testForm-3.jsp

```
이름, 나이, 성별(radio),강의장(select),취미(checkbox)를 입력받아 testPro3.jsp페이지로 전달
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
	<h2>사용자 정보를 입력받아서 testPro3.jsp페이지로 전달 (출력)</h2>
	<form action="testPro3.jsp" method="get">
		이름: <input type="text" name="name"><br/>
		나이: <input type="text" name="age"><br/>
		성별 : <input type="radio" name="gender" value="남자">남자 &nbsp;&nbsp;<input type="radio" name="gender" value="여자">여자<br/>
		강의장 : <select name="lecture">
		<option>1강의장</option>
		<option>2강의장</option>
		<option>3강의장</option>
		<option>4강의장</option>
		<option>5강의장</option>
		<option>6강의장</option>
		<option>7강의장</option>
		</select>
		<br/>
		취미 : <br/>
		<input type="checkbox" name="hobby" value="게임">게임<br/>
		<input type="checkbox" name="hobby" value="독서">독서<br/>
		<input type="checkbox" name="hobby" value="잠자기">잠자기<br/>
		<input type="submit" value="전송">
	</form>
</body>
</html>
```

# TestPro3.jsp
```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
// 한글처리(인코딩 복구)
request.setCharacterEncoding("utf-8");

String name = request.getParameter("name");
int age= Integer.parseInt(request.getParameter("age"));
String gender = request.getParameter("gender");
String lecture = request.getParameter("lecture");
String[] hobArr = request.getParameterValues("hobby");

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름: <%=name %> <br/>
	나이: <%=age %><br/>
	성별: <%=gender %><br/>
	강의장: <%=lecture %><br/>
	취미: <%
	if(hobArr!=null){
		for(int i=0;i<hobArr.length;i++)
		{
			if(hobArr.length==i+1)
			{
				out.print(hobArr[i]);	
			}
			else
			{
				out.print(hobArr[i]+ ",");
			}
		}
	}
	%>
</body>
</html>
```
# JSP2/IncludeTest.jsp

```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>include 기술을 사용하여 중복사용된 페이지를 줄임<br/>
	1) &lt;%@include file="" %&gt;(JSP지시어)<br/>
	2) &lt;jsp:include page=""&gt;&lt;jsp:include&gt;(JSP 액션태그)<br/>
</h2>
<table border="1" width="600" height="600">
	<tr>
		<td colspan="2" height="100">헤더(top)</td>
	</tr>
	<tr>
		<td>메뉴(left)</td>
		<td width="400">본문(right)</td>
	</tr>
	<tr>
		<td colspan="2" height="100">푸터(bottom)</td>
	</tr>
</table>
</body>
</html>
```
### 액션태그
```
태그를 사용해서 다른 동작(JSP)을 실행가능한 코드의 형태

'''
JSP페이지 내에서 어떤 동작을 하도록 지시하는 태그(흐름 제어기능)

forwad(이동), include(포함),param(데이터 넘기기), bean(클래스파일)

'''
```

### 지시어와 액션태그 차이점

```
지시어

컴파일되기 전에 소스코드를 결합후 컴파일(1개의 파일로 생성)
페이지에서 사용될 공통의 값(변수)

액션태그

태그를 사용해서 다른 동작(JSP)을 실행가능한 코드의 형태
각각의 파일을 컴파일 후 해당 코드에 추가(여러개의 파일이 추가된 1개의 파일)
특정페이지를 해당 페이지에 추가
```

## include 하기위한 jsp 파일 만들기
```
top.jsp	left.jsp	bottom.jsp
```

# JSP2/IncludeTest.jsp /수정

```

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="color.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>include 기술을 사용하여 중복사용된 페이지를 줄임<br/>
	1) &lt;%@include file="" %&gt;(JSP지시어)<br/>
	컴파일되기 전에 소스코드를 결합후 컴파일(1개의 파일로 생성)<br/>
	페이지에서 사용될 공통의 값(변수)<br/><br/>

	2) &lt;jsp:include page=""&gt;&lt;jsp:include&gt;(JSP 액션태그)<br/>
	태그를 사용해서 다른 동작(JSP)을 실행가능한 코드의 형태<br/>
	각각의 파일을 컴파일 후 해당 코드에 추가(여러개의 파일이 추가된 1개의 파일)<br/>
	특정페이지를 해당 페이지에 추가<br/>
</h2>
<table border="1" width="600" height="600">
	<tr>
		<td colspan="2" height="100">
		<!-- 인클루드 페이지에 정보전달 가능(파라미터) -->
		<jsp:include page="top.jsp">
			<jsp:param value="itwill" name="id"/>
		</jsp:include>
		</td>
	</tr>
	<tr>
		<td>
			<jsp:include page="left.jsp"/>
		</td>
		<td width="400"><img src="https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile7.uf.tistory.com%2Fimage%2F24283C3858F778CA2EFABE" width="400" height="400"></td>
	</tr>
	<tr>
		<td colspan="2" height="100">
			<jsp:include page="bottom.jsp"/>
		</td>
	</tr>
</table>
</body>
</html>
```
## color.jspf 파일 생성
```
<%
	String col1="yellow";
	String col2="pink";
	String col3="orange";
%>
```

# ※중요※ P.209 영역객체(Scope) | 속성(Attribute) 
```
내장 객체중 page(pageContext),request, session, application
특수한 기능이 있음 -> 각각의 범위를 사용하며, 그 범위안에서 데이터를 공유가능

Scope : 공유가능한 범위
Attribute : 공유되는 데이터
```

## [영역 Scope] - [ 영역객체 ]	-	[속성의 유효 범위]
```
page 		-	 pageContext	- 	해당페이지

request		-	 request		-	요청이 처리되는 페이지

session		-	 session		-	세션이 유지되는 동안 모든 페이지

application	-	application		-	서버 실행 후 프로그램의 모든 페이지

```

# 내장객체
```
	[javax.servlet 패키지] - 8개 (rrs poa cp)
	
	request : 사용자의 요청정보를 저장하는 객체
	response : 요청정보에 대한 응답정보를 처리하는 객체
	session : 클라이언트의 세션 정보를 저장하는 객체
	pageContext : 페이지에 실행을 할때 필요한 정보를 저장하는 객체(프로젝트)
	out : 응답 페이지 전송을 위한 출력스트림
	application : 해당 어플리케이션의 컨텍스트 정보를 저장한 객체
	config : 해당 페이지에 필요한 서블릿 설정정보를 저장하는 객체정보
	page : 해당 페이지 서블릿 객체(인스턴스)
			
	[java.lang 패키지] - 1개
	
	exeception : 예외 처리 객체
```

```
pageContext: jsp 페이지 정보를 저장객체
			- 다른 내장객체 호출, 페이지 흐름제어, 에러데이터 추출

request : 페이지 요청시 정보를 저장하는 객체
			- 페이지 이동시 정보를 가지고 이동

session : 하나의 웹 브라우저당 하나씩 생성, 정보를 유지하는 객체

application : 웹 애플리케이션(프로젝트)정보를 저장하는 객체
			- 서버 자체의 정보, 서버 이벤트 로그...
			- 프로젝트당 1개만 생성
```

### scopeForm.jsp 생성
```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="scopePro.jsp" method="get">
	아이디: <input type="text" name="id"><br/>
	<input type="submit" value="전송하기">
</form>
</body>
</html>
```

### scopePro.jsp 생성
```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>전달된 파라미터값을 저장후 출력</h2>
	<%
		String id= request.getParameter("id");
	%>
	아이디:<%=id %><br/>

	<h2>영역객체의 값을 출력</h2>

	<%
		pageContext.setAttribute("page", "page영역 객체 정보!");
		request.setAttribute("req","request영역 객체 정보(itwill)");
		session.setAttribute("ses","session영역 객체 정보(itwill)");
		application.setAttribute("app","application영역 객체 정보(itwill)");
	%>

			pageContext 내장객체 공유데이터(속성) : <%=pageContext.getAttribute("page")%><br/>
			request 내장객체 공유데이터(속성) : <%=request.getAttribute("req")%><br/>
			session 내장객체 공유데이터(속성) : <%=session.getAttribute("ses")%><br/>
			application 내장객체 공유데이터(속성) : <%=application.getAttribute("app")%><br/>
			<hr/><hr/>

			<h2>페이지 이동시 사용가능한 데이터</h2>
			1. a 태그 사용 <br>
			파라미터값전달 가능
			영역객체 : session, applcation정보만 사용가능<br/>
			<a href="scopePro2.jsp?id=<%=id%>&pw=1234">scopePro2.jsp 페이지 이동</a>

			<hr/>
			2. javascript 사용<br>
			파라미터값전달 가능 +
			영역객체 : session, applcation정보만 사용가능<br/>
			<script type="text/javascript">
				alert("scopePro2.jsp 페이지로 이동");
				location.href="scopePro2.jsp?id=<%=id%>&pw=1234";
			</script>
		</body>
		</html>
```

### 영역객체의 값 저장 및 가져오기

```
		
		해당 영역에 데이터를 저장
		해당 영역에서 데이터를 공유해서 사용가능
		
		영역객체.setAttribute("이름",값);

		영역데이터 사용
		영역객체.getAttribute("이름");
```

## scopePro2.jsp 생성

```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디:<%= %><br/>
비밀번호:<%= %><br/>
<hr/>
	pageContext 내장객체 공유데이터(속성) : <%=pageContext.getAttribute("page")%><br/>
	request 내장객체 공유데이터(속성) : <%=request.getAttribute("req")%><br/>
	session 내장객체 공유데이터(속성) : <%=session.getAttribute("ses")%><br/>
	application 내장객체 공유데이터(속성) : <%=application.getAttribute("app")%><br/>
</body>
</html>
```