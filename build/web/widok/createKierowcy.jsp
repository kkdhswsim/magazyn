<%@page import="model.kierowca"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
  
    <form id="formDostawcy" name="formDostawcy" action="<%= request.getContextPath()%>/kierowcy" method="post">
        <h4>Dodaj kierowcę</h4>
        <input type="hidden" id="id" name="id" value=" ">
        <input type="text" class="form-control" placeholder="Imie" name="imie_kierowcy" aria-describedby="basic-addon1" value=""><br/><br/>
    <input type="text" class="form-control" placeholder="Nazwisko" name="nazwisko_kierowcy" aria-describedby="basic-addon1"><br/><br/>
    <input type="text" class="form-control" placeholder="Nr dokumentu" name="nrdokumentu_kierowcy" aria-describedby="basic-addon1"><br/><br/>
    <button type="submit" class="btn btn-default navbar-btn">Dodaj kierowcę</button>
    
    </form>
    </div>
        <%@include file="../WEB-INF/jspf/bottom.jspf"%>
    </body>
</html>
