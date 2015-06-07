
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="WEB-INF/jspf/jscss.jspf"%>
        <title>Program dla Magazynierów</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
    </head>
    <body>
        <%@include file="WEB-INF/jspf/top.jspf"%>
    <div class="input-group" style="width: 300px">
    
    <form action="DodajDoBazy" method="post">
    <input type="text" class="form-control" placeholder="Nazwa firmy" name="nazwa_firmy" aria-describedby="basic-addon1"><br/><br/>
    <input type="text" class="form-control" placeholder="Adres firmy" name="adres_firmy" aria-describedby="basic-addon1"><br/><br/>
    <input type="text" class="form-control" placeholder="NIP" name="nip_firmy" aria-describedby="basic-addon1"><br/><br/>
    <button type="submit" class="btn btn-default navbar-btn">Dodaj firmę</button>
    
    </form>
    </div>
        <%@include file="WEB-INF/jspf/bottom.jspf"%>
    </body>
</html>
