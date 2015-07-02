
<%@page import="model.kierowca"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="list" scope="session" class="java.util.List" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../WEB-INF/jspf/jscss.jspf"%>
        <title>Kierowcy</title>
        
    </head>
    <body style="background-color: black;">
<div class="container" style="width: 770px; background-color: white;">
        <div class="row">
        <div class="col-xs-12 col-md-8">.col-xs-12 .col-md-8</div>
        <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
        </div>
    <div id="logo" style="height: 150px;">

    </div> 
            
    <div id="main"> 
    <div class="content">
        <div id="menu" style="height: 100px;">
        <%@include file="../WEB-INF/jspf/top.jspf"%>
        </div>
            <a href="<%= request.getContextPath()%>/kierowcy?op=create" class="btn btn-mini btn-primary">Dodaj dostawcę</a>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>Nr dokumentu</th>
                    <th>OPCJE</th>
                </tr>
                <%
                  for(int i=0; i<list.size(); i++){
                      kierowca kierow = new kierowca();
                      kierow = (kierowca)list.get(i);
                %>
                <tr>
                    <td><%= kierow.getId() %></td>
                    <td><%= kierow.getImie() %></td>
                    <td><%= kierow.getNazwisko() %></td>
                    <td><%= kierow.getNrdokumentu() %></td>
                    <td><a href="kierowcy?op=update&id=<%= kierow.getId() %>" class="btn btn-mini btn-primary">Edytuj</a>
                        <a href="kierowcy" class="btn btn-mini btn-primary">Usun</a>
                    </td>
                </tr>
                 <%
                  }
                %>
            </table>
            <div class="clear"></div>
    </div>
    </div>
            
    <div id="footer">
         <%@include file="../WEB-INF/jspf/bottom.jspf"%>
    </div>

        
            
</div>
   </body>
</html>
