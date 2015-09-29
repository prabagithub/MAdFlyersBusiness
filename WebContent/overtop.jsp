<%String username = null;
if(null != request.getSession().getAttribute("username")){
	username = (String)request.getSession().getAttribute("username");
}
	%>
<table>
                <tbody><tr>
                <td><h1 style="margin:5px 0;">{{message}}</h1></td>
                <td><img src="images/logo.jpg" style="height:30px;width:30px"/></td>                               
                </tr>
                </tbody></table>  
                <% if(null != username){ %>
                <table align="right" class="{{welcomeclass}}">
                <tr><td><span class="white"> Welcome, <%=username%>  <img src="images/acc.png" style="height:25px;width:20px"> </span></td></tr>                                               
                <tr><td><a href="login.jsp" class="button red xlarge" ><span class="white">Logout</span></a></td></tr>
                </table>   
                <%} %>           
                <div class="redribbon"></div>                                
                <div class="overtop {{color}}">{{overtopmsg}}</div> 