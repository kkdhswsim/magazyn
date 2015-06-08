<%@page import="controler.Dostawcy"%>
<%@page import="model.dostawca"%>
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
            <a href="<%= request.getContextPath()%>/dostawcy?op=create" class="btn btn-mini btn-primary">Dodaj dostawcę</a>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Nazwa</th>
                    <th>Adres</th>
                    <th>Nip</th>
                    <th>OPCJE</th>
                </tr>
                <%
                  for(int i=0; i<list.size(); i++){
                      dostawca dostaw = new dostawca();
                      dostaw = (dostawca)list.get(i);
                %>
                <tr>
                    <td><%= dostaw.getId() %></td>
                    <td><%= dostaw.getNazwa() %></td>
                    <td><%= dostaw.getAdres() %></td>
                    <td><%= dostaw.getNip() %></td>
                    <td><a href="dostawcy" class="btn btn-mini btn-primary">Edytuj</a>
                        <a href="dostawcy" class="btn btn-mini btn-primary">Usun</a>
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
