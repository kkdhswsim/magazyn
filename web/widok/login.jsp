
<%@page import="model.login"%>

<%
   String user = request.getParameter( "username" );
   session.setAttribute( "theName", name );
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="list" scope="session" class="java.util.List" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../WEB-INF/jspf/jscss.jspf"%>
        <title>Kierowcy</title>
        
    </head>
    <body style='background-color: #9999cc'>
<div class="container" style="width: 770px; background-color:white ;">
        <div class="row">
            <div class="col-xs-12 col-md-8">

               
            </div>
        <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
        </div>
    <div id="logo" style="height: 170px; width: 770px;">
        <img src='<%= request.getContextPath()%>/widok/images/logo.jpg'>
        <br/><br/>
    </div> 
            
    <div id="main"> 
    <div class="content">
        <div style="height: 70px">
            Witaj użytkowniku!<br/>
            Musisz się zalogować, aby móc korzystać z aplikacji!
        </div>

<form class="form-inline" method='post' action='<%= request.getContextPath()%>/widok/login.jsp'>
  <div class="form-group">
    <label class="sr-only" for="exampleInputEmail3">User</label>
    <input type="text" class="form-control" id="exampleInputEmail3" placeholder="User" name="user">
  </div>
  <div class="form-group">
    <label class="sr-only" for="exampleInputPassword3">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword3" placeholder="Password" name="pass">
  </div>
  <button type="submit" class="btn btn-default">Zaloguj</button>
</form>
        
            <div class="clear"></div>
    </div>
    </div>
            
    <div id="footer">
         <%@include file="../WEB-INF/jspf/bottom.jspf"%>
    </div>

        
            
</div>
   </body>
</html>
