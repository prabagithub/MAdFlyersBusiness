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
<body ng-controller="LoginController">
<jsp:include page="overtop.jsp"></jsp:include>
<form action="LoginServlet" method="post">
<div style="height:700px" width="100%">
<jsp:include page="beforeLogin.jsp"></jsp:include>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</form>
</body>
</html>