

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="WEB-INF/jspf/jscss.jspf"%>
        <title>Kierowcy</title>
        
    </head>
    <body style='background-color: #9999cc'>
<div class="container" style="width: 770px; background-color:white ;">
    <div id="logo" style="height: 170px; width: 770px;">
        <img src='<%= request.getContextPath()%>/widok/images/logo.jpg'>
        <br/><br/>
    </div> 
            
    <div id="main"> 
    <div class="content">
          <!--MENU -->
                <div id="menu" style="height: 100px;">
                    <%@include file="WEB-INF/jspf/top.jspf"%>
                </div>
                <!-- KONIEC MENU -->
                <div class="jumbotron"><center>
                    <h1>System Transportowy</h1>
                    <p>Kompleksowy system obsługi transportu i spedycji, krajowej i międzynarodowej oraz zarządzania taborem</p>
                    </center>
                    </div>

        
            <div class="clear"></div>
    </div>
    </div>
            
    <div id="footer">
         <%@include file="WEB-INF/jspf/bottom.jspf"%>
    </div>

        
            
</div>
   </body>
</html>
