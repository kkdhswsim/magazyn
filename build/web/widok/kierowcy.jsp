
<%@page import="model.kierowca"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="list" scope="session" class="java.util.List" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../WEB-INF/jspf/jscss.jspf"%>
        <title>Program dla Magazynierów</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
    </head>
    <body>
        <%@include file="../WEB-INF/jspf/top.jspf"%>
        <div style="width: 700px">
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
        </div>

    
        <%@include file="../WEB-INF/jspf/bottom.jspf"%>
    </body>
</html>
