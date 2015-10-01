<%String username = null;
if(null != request.getSession().getAttribute("username")){
	username = (String)request.getSession().getAttribute("username");
}
	%>
<table ng-controller="LoginController">
                <tbody><tr>
                <td><h1 style="margin:5px 0;">{{message}}</h1></td>
                <td><img src="images/logo.png" style="height:30px;width:30px"/></td>                               
                </tr>
                </tbody></table>  
                <% if(null != username){ %>
                <table align="right" class="{{welcomeclass}}">
                <tr><td><span class="white" style="font-size:20px"> Welcome, <%=username%> <img src="images/acc.png" style="height:25px;width:20px"> </span></td></tr>                                               
                <tr><td align="right"><a href="login.jsp" >Logout</a></td></tr>
                </table>   
                <%} %>           
                <div class="redribbon"></div>                                                