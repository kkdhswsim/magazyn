
<%@page import="model.ciezarowka"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="list" scope="session" class="java.util.List" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../WEB-INF/jspf/jscss.jspf"%>
        <title>Ciężarkówki - DELETE</title>
    </head>
    <!-- BODY STRONY -->
    <body style='background-color: #9999cc'>
        
    <div class="container" style="width: 770px; background-color:white ;">
        <!-- Pasek na górze strony -->
        <div class="row">
            <div class="col-xs-12 col-md-8">
               
            </div>
        
            <div class="col-xs-6 col-md-4">
                
            </div>
        </div>
        <!-- KONIEC Pasek na górze strony KONIEC-->
        
        <!-- Logo strony -->
        <div id="logo" style="height: 170px; width: 770px;">
            <img src='<%= request.getContextPath()%>/widok/images/logo.jpg'>
            <br/><br/>
        </div>
        <!-- KONIEC Logo strony -->
           
        <!-- Główne okno strony -->
        <div id="main"> 
            <div class="content">
                <!--MENU -->
                <div id="menu" style="height: 100px;">
                    <%@include file="../WEB-INF/jspf/top.jspf"%>
                </div>
                <!-- KONIEC MENU -->
                
                <!-- ////////////////////////////////Główna część strony///////////////////////////// -->
                <center>
                        <div class="input-group" style="width: 300px">
        
                <%
                      String Sid = request.getParameter("poz");
                      int poz = Integer.parseInt(Sid);
                      ciezarowka kierow = new ciezarowka();
                      kierow = (ciezarowka)list.get(poz);
                %>
  
                    <form id="formDostawcy" name="formDostawcy" action="<%= request.getContextPath()%>/ciezarowka" method="post">
                        <h4>Usuń ciężarówkę nr: <%= kierow.getId() %></h4>
                        <input type="hidden" class="form-control" name="info" value= '1'>
                        <input type="hidden" class="form-control" name="id" value= '<%= kierow.getId() %>'>
                        <input type="text" readonly class="form-control" placeholder="Imie" name="model_ciezarowki" aria-describedby="basic-addon1" value="<%= kierow.getMarka() %>"><br/><br/>
                        <input type="text" readonly class="form-control" placeholder="Nazwisko" name="marka_ciezarowki" aria-describedby="basic-addon1" value="<%= kierow.getModel() %>"><br/><br/>
                        <input type="text" readonly class="form-control" placeholder="Nr dokumentu" name="rejestracja_ciezarowki" aria-describedby="basic-addon1" value="<%= kierow.getRejestracja() %>"><br/><br/>
                    <button type="submit" class="btn btn-default navbar-btn">Usuń ciężarowkę</button>
                    <br/><font color="red" size="5">Uwaga!! Usunięcie jest nieodwracalne!! </font>

    
    
                </form></div></center>
                <!--//////////////////// Główna część strony///////////////////////// -->
                
                
                
                <!-- ////////////////////KONIEC głównej częsci strony//////////////////////////// -->
                <div class="clear"></div>
            </div><!-- koniec CONTENT -->
        </div><!-- koniec MAIN -->
       
        <!-- STOPKA -->     
    <div id="footer">
         <%@include file="../WEB-INF/jspf/bottom.jspf"%>
    </div>
        <!-- KONIEC STOPKA --> 

   </div> <!-- KONIEC CONTAINENT -->
   
  </body>
</html>
