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
    <div class="input-group" style="width: 300px">
        
                <%
                      String Sid = request.getParameter("id");
                      int id = Integer.parseInt(Sid);
                      kierowca kierow = new kierowca();
                      kierow = (kierowca)list.get(id -1);
                %>
  
    <form id="formDostawcy" name="formDostawcy" action="<%= request.getContextPath()%>/kierowcy" method="post">
        <h4>Dodaj kierowcę</h4>
        <input type="hidden" id="id" name="id" value=" <%= kierow.getId() %>">
        <input type="text" class="form-control" placeholder="Imie" name="imie_kierowcy" aria-describedby="basic-addon1" value="<%= kierow.getImie() %>"><br/><br/>
        <input type="text" class="form-control" placeholder="Nazwisko" name="nazwisko_kierowcy" aria-describedby="basic-addon1" value="<%= kierow.getNazwisko() %>"><br/><br/>
        <input type="text" class="form-control" placeholder="Nr dokumentu" name="nrdokumentu_kierowcy" aria-describedby="basic-addon1" value="<%= kierow.getNrdokumentu() %>"><br/><br/>
    <button type="submit" class="btn btn-default navbar-btn">Dodaj kierowcę</button>
    
    </form>
    </div>
        <%@include file="../WEB-INF/jspf/bottom.jspf"%>
    </body>
</html>
