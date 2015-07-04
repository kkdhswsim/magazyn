
<%@ page import="java.sql.*" %>
<%@page import="model.kierowca"%>
<%@page import="model.trasa"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="list" scope="session" class="java.util.List" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../WEB-INF/jspf/jscss.jspf"%>
        <title>Kierowcy - Lista</title>
        <%
        //String baza = "jdbc:mysql://dawid73.cal24.pl/dawid73_swsim";
        //String user = "dawid73_swsim";
        //String haslo = "java4321";
            
        String baza = "jdbc:mysql://localhost:6033/transport";
        String user = "root";
        String haslo = "";
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
                
                <!-- ////////////////////////////////Główna część strony///////////////////////////// -->
                <center>
                 <div class="input-group" style="width: 300px">
  
                <form id="formDostawcy" name="formDostawcy" action="<%= request.getContextPath()%>/trasa" method="post">
                    <h4>Dodaj trasę</h4>
                    <input type="hidden" class="form-control" name="info" value= '0'>
                    <input type="hidden" id="id" name="id" value="0">
        
                    <%
                        int idk,idc,idn;
                        String nazwisko="";
                        String imie="";
                        String markac="";
                        String rejc="";
                        String rejn="";
                        String markan="";
                        
                        Connection connection = null;
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        connection = DriverManager.getConnection(baza, user, haslo);
                        Statement statement = connection.createStatement() ;
                        ResultSet resultset = statement.executeQuery("select id, nazwisko, imie from kierowca;") ;
                        

                    %>
                    Kierowca: <select name='id_kierowcy' class="form-control">
                    <%
                        while(resultset.next()) {
                        idk = resultset.getInt("id");
                        nazwisko = resultset.getString("nazwisko");
                        imie = resultset.getString("imie");
                    %>
                     <option value="<%= idk %>"><%= nazwisko %> <%= imie %></option> 
                    <%
                        }                       
                    %>
                    </select> <br/><br/>
                    
                    
                        <%
                        Connection connection2 = null;
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        connection2 = DriverManager.getConnection(baza, user, haslo);
                        Statement statement2 = connection.createStatement() ;
                        ResultSet resultset2 = statement2.executeQuery("select id, marka, rejestracja from ciezarowka;") ;
   
                    %>
                    Ciężarowka: <select name='id_ciezarowki' class="form-control">
                    <%
                        while(resultset2.next()) {
                        idc = resultset2.getInt("id");
                        markac = resultset2.getString("marka");
                        rejc = resultset2.getString("rejestracja");
                    %>
                     <option value="<%= idc %>"><%= markac %> <%= rejc %></option> 
                    <%
                        }                       
                    %>
                    </select> <br/><br/>
                    
                    
                         <%
                        Connection connection3 = null;
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        connection3 = DriverManager.getConnection(baza, user, haslo);
                        Statement statement3 = connection.createStatement() ;
                        ResultSet resultset3 = statement3.executeQuery("select id, marka, rejestracja from naczepa;") ;
   
                    %>
                    Naczepa: <select name='id_naczepy' class="form-control">
                    <%
                        while(resultset3.next()) {
                        idn = resultset3.getInt("id");
                        markan = resultset3.getString("marka");
                        rejn = resultset3.getString("rejestracja");
                    %>
                     <option value="<%= idn %>"><%= markan %> <%= rejn %></option> 
                    <%
                        }                       
                    %>
                    </select> <br/><br/>
                 
                        
                    
                    
                    <!-- /////////////////////// --->
                  
                    
                    
                Data wyjazdu: <input type="text" class="form-control" placeholder="Data wyjazdu" name="dwyjazd" aria-describedby="basic-addon1" value=""><br/><br/>
                Data powrotu: <input type="text" class="form-control" placeholder="Data powrotu" name="dpowrot" aria-describedby="basic-addon1" value=""><br/><br/>
                Miejsce wyjazdu: <input type="text" class="form-control" placeholder="Miejsce wyjazdu" name="mwyjazd" aria-describedby="basic-addon1" value=""><br/><br/>
                Miejsce powrotu: <input type="text" class="form-control" placeholder="Miejsce powrotu" name="mpowrot" aria-describedby="basic-addon1" value=""><br/><br/>
            
                <button type="submit" class="btn btn-default navbar-btn">Dodaj trasę</button>

                </form>
                </div></center>
  
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
