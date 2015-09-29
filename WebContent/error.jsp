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
<jsp:include page="slideshow.jsp"/>
<div class="branding container_12">         
<form>
<div class="content">
	<table>
	<tr>
	<td>Organization Name </td>
  <td></td>
	  	<td class="verizoncolor"><%= ad.getBusinessName() %></td>
	</tr>
	<tr></tr>
	
	<tr>
	<td>Address Line1 </td>
  <td></td>
	  	<td class="verizoncolor"><%= ad.getAddr1() %></td>
	</tr>
	<tr></tr>
	
		<tr>
	<td >Address Line2</td>
  <td></td>
	  	<td class="verizoncolor"><%= ad.getAddr2() %></td>
	</tr>
	<tr></tr>
	
		<tr>
	<td>Address Line3</td>
  <td></td>
	  	<td class="verizoncolor"><%= ad.getAddr3() %></td>
	</tr>
	<tr></tr>
	
		<tr>
	<td>City </span></td>
  <td></td>
	  	<td class="verizoncolor"><%= ad.getCity() %></td>
	</tr>
	<tr></tr>
	
		<tr>
	<td>State </td>
  <td></td>
	  	<td class="verizoncolor"><%= ad.getState() %></td>
	</tr>
	<tr></tr>
	
	<tr>
	<td>Country </td>
  <td></td>
	  	<td class="verizoncolor"><%=ad.getCountry() %></td>
	</tr>
	<tr></tr>
	
	<tr>
	<td>Pin code / Zip Code </td>
  <td></td>
	  	<td class="verizoncolor"><%= ad.getPincode() %></td>
	</tr>
	<tr></tr>
	
	<tr>
	<td>AD Description </td>
  <td></td>
	  	<td class="verizoncolor"><%=ad.getDesc() %></td>
	</tr>
	<tr></tr>			
	
	</table>
</div>

</form>
</div>
<div class="top">
<a href="home.jsp" class="button red xlarge"><span class="white">Try Again</span></a>
</div>
   
</body>

</html>
