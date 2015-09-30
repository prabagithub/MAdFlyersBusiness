
<table class="logintable">
<tr>
<td colspan="2">
<h1 class="splfont">{{header}}</h1>
</td>
</tr>
<% if(null != request.getAttribute("error") && (boolean) request.getAttribute("error")){
%>
<tr>
<td colspan="2"><span class="red">{{errmsg}}</span></td>
</tr>
<%} %>
<tr>

 <td >{{username}}</td>
<td><input type="text" autofocus="autofocus" class="form-control" name="username" id="username" placeholder="Username"/>
</td>
</tr>
<tr>
</tr>
<tr>
<td>
{{pwd}}
</td>
<td><input type="password" autofocus="autofocus" class="form-control" id="pwd" name="pwd" placeholder="Password"/>
</td>
</tr>
<tr></tr>
<tr>
<td>
</td>
<td>
<input type="submit" class="button red xlarge" style="color:white;" value="{{btnvalue}}"/></td>
</tr>
</table>
<div class="saml-login"></div>
<table>
<tr>
<td colspan="2">{{regmsg}}</td>
</tr>
<tr>
<td><a href="">{{forgot}}</a></td>
</tr>
</table>

