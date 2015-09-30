<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MAdFlyers</title>
<script src="https://code.angularjs.org/1.3.0-beta.5/angular.js"  
data-require="angular.js@*" data-semver="2.0.0-alpha.31"></script> 
<script src="script.js"></script>
<link href="style.css" rel="stylesheet" />
</head>
<body>
<% String errid = null; 
String loginerrid = "";
String regerrid = "";
if(null != request.getSession().getAttribute("username")){
	request.getSession().removeAttribute("username");}
	if(null != request.getAttribute("error")){
	errid= (String) request.getAttribute("error");
	if(null != errid && "login".equalsIgnoreCase(errid)){
		loginerrid = "show";
	}else if(null != errid && "reg".equalsIgnoreCase(errid)){
		regerrid = "show";
	}
	}	
	%>
<jsp:include page="overtop.jsp"></jsp:include>

<div class="newuser" id="newuser" ng-controller="RegisterController">
<form action=RegisterServlet method="post" onsubmit="return checkRegister()">
<jsp:include page="useraccount.jsp">
<jsp:param value="reg" name="reg"/>
<jsp:param value="<%=regerrid %>" name="errid"/>
</jsp:include>
</form>
</div>


<div class="exiuser" id = "existuser" ng-controller="LoginController">
<form action="LoginServlet" method="post" onsubmit="return checkLogin()">
<jsp:include page="useraccount.jsp">
<jsp:param value="login" name="reg"/>
<jsp:param value="<%=loginerrid %>" name="errid"/>
</jsp:include>
</form>
</div>


</body>
</html>