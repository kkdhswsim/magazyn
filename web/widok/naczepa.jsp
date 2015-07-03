
<%@page import="model.naczepa"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="list" scope="session" class="java.util.List" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../WEB-INF/jspf/jscss.jspf"%>
        <title>Naczepy - Lista</title>
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
                
                <!--//////////////////// Główna część strony///////////////////////// -->
                <a href="<%= request.getContextPath()%>/naczepa?op=create" class="btn btn-mini btn-primary">Dodaj naczepę</a>
                <table class="table table-striped">
                    <tr>
                        <th>Id</th>
                        <th>Marka</th>
                        <th>Typ</th>
                        <th>Rejestracja</th>
                        <th>OPCJE</th>
                    </tr>
                    <%
                      for(int i=0; i<list.size(); i++){
                          naczepa kierow = new naczepa();
                          kierow = (naczepa)list.get(i);
                    %>
                <tr>
                    <td><%= kierow.getId() %></td>
                    <td><%= kierow.getMarka() %></td>
                    <td><%= kierow.getTyp() %></td>
                    <td><%= kierow.getRejestracja() %></td>
                    <td><a href="naczepa?op=update&poz=<%= i%>&id=<%= kierow.getId() %>" class="btn btn-mini btn-primary">Edytuj</a>
                        <a href="naczepa?op=delete&poz=<%= i%>&id=<%= kierow.getId() %>" class="btn btn-mini btn-primary">Usun</a>
                    </td>
                </tr>
                 <%
                  }
                %>
                </table>
                
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
