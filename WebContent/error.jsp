<%@ page import="com.verizon.hack.domain.*" %>
<html ng-app>
  <head>
    <script src="https://code.angularjs.org/1.3.0-beta.5/angular.js" 
    data-require="angular.js@*" data-semver="2.0.0-alpha.31"></script>
    <link href="style.css" rel="stylesheet" />
    <script src="script.js"></script>
  </head>
 <body ng-controller="ErrorController">
<% ADDetail ad = (ADDetail) request.getSession().getAttribute("ad");%>
<jsp:include page="overtop.jsp"/>
<jsp:include page="logo.jsp"/>
<div class=""> 
<div class="succmsg red">Error in posting Ad, Please try again</div>        
<form>
<div class="content" style="width:500px;float:left;margin-top:20px">
	<table>
	<tr>
	<td>Business Unit Name </td>
  <td class="tdwidth20"></td>
	  	<td class="verizoncolor"><%= ad.getBusinessName() %></td>
	</tr>
	<tr></tr>
	<tr>
	<td>Category </td>
  <td class="tdwidth20"></td>
	  	<td class="verizoncolor"><%= ad.getCategory()%></td>
	</tr>
	<tr></tr>
	
	
	<tr>
	<td>Address Line1 </td>
  <td class="tdwidth20"></td>
	  	<td class="verizoncolor"><%= ad.getAddr1() %></td>
	</tr>
	<tr></tr>
	
		<tr>
	<td >Address Line2</td>
  <td class="tdwidth20"></td>
	  	<td class="verizoncolor"><%= ad.getAddr2() %></td>
	</tr>
	<tr></tr>
	
		<tr>
	<td>Address Line3</td>
  <td class="tdwidth20"></td>
	  	<td class="verizoncolor"><%= ad.getAddr3() %></td>
	</tr>
	<tr></tr>
	
		<tr>
	<td>City </span></td>
  <td class="tdwidth20"></td>
	  	<td class="verizoncolor"><%= ad.getCity() %></td>
	</tr>
	<tr></tr>
	
		<tr>
	<td>State </td>
  <td class="tdwidth20"></td>
	  	<td class="verizoncolor"><%= ad.getState() %></td>
	</tr>
	<tr></tr>
	
	<tr>
	<td>Country </td>
  <td class="tdwidth20"></td>
	  	<td class="verizoncolor"><%=ad.getCountry() %></td>
	</tr>
	<tr></tr>
	
	<tr>
	<td>Pin code / Zip Code </td>
  <td class="tdwidth20"></td>
	  	<td class="verizoncolor"><%= ad.getPincode() %></td>
	</tr>
	<tr></tr>
	
	<tr>
	<td>Contact No. </td>
  <td class="tdwidth20"></td>
	  	<td class="verizoncolor"><%=ad.getPhone() %></td>
	</tr>
	<tr></tr>
	
	<tr>
	<td>AD Description </td>
  <td class="tdwidth20"></td>
	  	<td class="verizoncolor"><%=ad.getDesc() %></td>
	</tr>
	<tr></tr>			
	
	</table>
</div>
<div class="success">
<img src="images/warn.jpg" style="height:60px;width:60px">
<a href="home.jsp" class="button red xlarge" style="font-size:25px"><span class="white">Try again</span></a>
</div>
</form>
</div>
<div class="top">
</div>
   
</body>

</html>
