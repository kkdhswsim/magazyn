
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.trasa"%>
<%@page import="model.ciezarowka"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="list" scope="session" class="java.util.List" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../WEB-INF/jspf/jscss.jspf"%>
        <title>Trasa - INFO</title>
          <%
        String baza = "jdbc:mysql://dawid73.cal24.pl/dawid73_swsim";
        String user = "dawid73_swsim";
        String haslo = "java4321";
        %>
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
                <center>
                    <div class="input-group" style="width: 300px">
        
                <%
                      String Sid = request.getParameter("poz");
                      int poz = Integer.parseInt(Sid);
                      trasa tra = new trasa();
                      tra = (trasa)list.get(poz);
                %>
  
                <div class="panel panel-default">
                <div class="panel-heading">Skąd</div>
                <div class="panel-body">
                <%= tra.getMwyjazd() %>
                </div>
                </div>
                
                <div class="panel panel-default">
  <div class="panel-heading">Dokąd</div>
  <div class="panel-body">
    <%= tra.getMpowrot() %>
  </div>
</div>
                
                <div class="panel panel-default">
  <div class="panel-heading">Data wyjazdu</div>
  <div class="panel-body">
    <%= tra.getDwyjazd() %>
  </div>
</div>
                
                <div class="panel panel-default">
  <div class="panel-heading">Data powrotu</div>
  <div class="panel-body">
    <%= tra.getDpowrot() %>
  </div>
</div>
  
   <div class="panel panel-default">
  <div class="panel-heading">Kierowca</div>
  <div class="panel-body">
  <%
    int idk=tra.getKierowca_id();
    String nazwisko="";
    String imie="";
                        Connection connection = null;
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        connection = DriverManager.getConnection(baza, user, haslo);
                        Statement statement = connection.createStatement() ;
                        ResultSet resultset = statement.executeQuery("select nazwisko, imie from kierowca WHERE id=" + idk) ;
  
                        while(resultset.next()) {
                        nazwisko = resultset.getString("nazwisko");
                        imie = resultset.getString("imie");
                        }
                    %>
                  <%= nazwisko %> <%= imie %>
  </div>
</div>
  
     <div class="panel panel-default">
  <div class="panel-heading">Ciężarówka</div>
  <div class="panel-body">
  <%
    int idc=tra.getCiezarowka_id();
    String ciezarowka="";
    String rejc="";
                        Connection connection2 = null;
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        connection2 = DriverManager.getConnection(baza, user, haslo);
                        Statement statement2 = connection2.createStatement() ;
                        ResultSet resultset2 = statement.executeQuery("select marka, rejestracja from ciezarowka WHERE id=" + idc) ;
  
                        while(resultset2.next()) {
                        ciezarowka = resultset2.getString("marka");
                        rejc = resultset2.getString("rejestracja");
                        }
                    %>
                  <%= ciezarowka %> <%= rejc %>
  </div>
</div>
  
       <div class="panel panel-default">
  <div class="panel-heading">Naczepa</div>
  <div class="panel-body">
  <%
    int idn=tra.getNaczepa_id();
    String naczepa="";
    String rejn="";
                        Connection connection3 = null;
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        connection3 = DriverManager.getConnection(baza, user, haslo);
                        Statement statement3 = connection3.createStatement() ;
                        ResultSet resultset3 = statement.executeQuery("select marka, rejestracja from naczepa WHERE id=" + idn) ;
  
                        while(resultset3.next()) {
                        naczepa = resultset3.getString("marka");
                        rejn = resultset3.getString("rejestracja");
                        }
                    %>
                  <%= naczepa %> <%= rejn %>
  </div>
</div>
             <a href="<%= request.getContextPath()%>/trasa?op=list" class="btn btn-mini btn-primary">Wróc</a>  
                    </div></center>
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
