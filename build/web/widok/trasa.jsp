
<%@page import="model.trasa"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="list" scope="session" class="java.util.List" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../WEB-INF/jspf/jscss.jspf"%>
        <title>Ciężarówki - Lista</title>
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
                <a href="<%= request.getContextPath()%>/trasa?op=create" class="btn btn-mini btn-primary">Dodaj trasę</a>
                <table class="table table-striped">
                    <tr>
                        <th>Id</th>
                        <th>Data wyjazdu</th>
                        <th>Miejsce wyjazdu</th>
                        <th>Data powrotu</th>
                        <th>Miejsce powrotu</th>
                        <th>OPCJE</th>
                    </tr>
                    <%
                      for(int i=0; i<list.size(); i++){
                          trasa tr = new trasa();
                          tr = (trasa)list.get(i);
                    %>
                <tr>
                    <td><%= tr.getId() %></td>
                    <td><%= tr.getDwyjazd() %></td>
                    <td><%= tr.getMwyjazd() %></td>
                    <td><%= tr.getDpowrot() %></td>
                    <td><%= tr.getMpowrot() %></td>
                    
                    <td><a href="trasa?op=info&poz=<%= i%>&id=<%= tr.getId() %>" class="btn btn-mini btn-primary">Szczegóły</a>
                        
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
