<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="logintable">
<tr>
<td colspan="2">
<h1 class="splfont {{hdrbg}}" >{{header}}</h1>

</td>
</tr>
<% if(null != request.getAttribute("error") && (boolean) request.getAttribute("error")){
%>
<tr>
<td colspan="2"><span class="red">{{errmsg}}</span></td>
</tr>
<%} %>
<c:if test="${param.reg eq 'reg'}">
<tr class="tr50">
<td>
 First Name
 </td>
 <td><input type="text" autofocus="autofocus" class="form-control" placeholder="First Name"/> 
 </td>
 </tr>
 <tr>
 </tr>
 <tr class="tr50">
 <td>Last Name</td>
 <td><input type="text" autofocus="autofocus" class="form-control" placeholder="Last Name"/>
 </tr>
 </c:if>

<tr class="tr50">
<c:if test="${param.reg eq 'reg'}">
 <td >{{username}}</td>
 </c:if>
<td><input type="text" autofocus="autofocus" class="form-control" name="username" id="username" placeholder="Username"/>
</td>
</tr>
<tr>
</tr>
<tr class="tr50">
<c:if test="${param.reg eq 'reg'}">
<td>
{{pwd}}
</td>
</c:if>
<td><input type="password" autofocus="autofocus" class="form-control" id="pwd" name="pwd" placeholder="Password"/>
</td>
</tr>
<tr></tr>


<c:if test="${param.reg eq 'reg'}">
<tr class="tr50">
<td>
{{confirm}}
</td>
<td><input type="password" autofocus="autofocus" class="form-control" id="cpwd" name="cpwd" placeholder="Password"/>
</td>
</tr>
<tr>
</tr>
<tr class="tr50">
<td colspan="2"><input type="checkbox"> I accept the <a href="" style="color:#1B809B"> terms and conditions</a></td>
</tr>

</c:if>

<tr class="tr50">
<c:if test="${param.reg eq 'reg'}">
<td>
</td>
</c:if>
<td>
<input type="submit" class="button red xlarge" style="color:white;" value="{{btnvalue}}"/></td>
</tr>
</table>
<div class="saml-login"></div>
<table>
<tr>
<td colspan="2"><a href="{{}}">{{regmsg}}</a></td>
</tr>
<tr>
<td><a href="">{{forgot}}</a></td>
</tr>
</table>

