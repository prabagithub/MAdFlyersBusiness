<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="uid" value="{{usernameid}}"/>
<c:set var="pid" value="{{pwdid}}"/>
<table class="logintable">
<tr>
<td colspan="2">
<h1 class="splfont {{hdrbg}}" >{{header}}</h1>

</td>
</tr>
<c:if test="${param.errid eq 'show'}">
<tr>
<td colspan="2"><span class="red">{{errmsg}}</span></td>
</tr>
</c:if>
<c:if test="${param.reg eq 'reg'}">
<tr class="tr50">
 <td><input type="text" autofocus="autofocus" class="form-control" placeholder="First Name" id="fname" name="fname"/> 
 </td>
 
 <td><input type="text" autofocus="autofocus" class="form-control" placeholder="Last Name" id="lname" name="lname"/>
 </tr>
 </c:if>

<tr class="tr50">
<td colspan="2"><input type="text" autofocus="autofocus" class="form-control {{input350}}" name="username" id="${uid}" placeholder="Username"/>
</td>
</tr>
<tr>
</tr>
<tr class="tr50">
<td colspan="2"><input type="password" autofocus="autofocus" class="form-control {{input350}}" id="${pid}" name="pwd" placeholder="{{pwd}}"/>
</td>
</tr>
<tr></tr>


<c:if test="${param.reg eq 'reg'}">
<tr class="tr50">
<td colspan="2"><input type="password" autofocus="autofocus" class="form-control {{input350}}" id="cpwd" name="cpwd" placeholder="{{repwd}}"/>
</td>
</tr>
<tr>
</tr>
<tr class="tr50">
<td colspan="2"><input type="checkbox"> I accept the <a href="" style="color:#1B809B"> terms and conditions</a></td>
</tr>

</c:if>

<tr class="tr50">
<td>
<input type="submit" class="button red xlarge" style="color:white;" value="{{btnvalue}}"/></td>
</tr>
</table>
<c:if test="${param.reg eq 'login'}">
<div class="saml-login"></div>
</c:if>
<table>
<tr>
<td><a href="">{{forgot}}</a></td>
</tr>
</table>

