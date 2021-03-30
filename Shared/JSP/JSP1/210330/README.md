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

```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <form action="testPro2.jsp">
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