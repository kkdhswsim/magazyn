/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.ciezarowkaADD;
import dao.ciezarowkaDAO;
import dao.kierowcaADD;
import dao.kierowcaDAO;
import dao.trasaADD;
import dao.trasaDAO;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ciezarowka;
import model.trasa;
/**
 *
 * @author Dawid
 */
public class Trasa extends HttpServlet {
    
   

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv='refresh' content='0; URL=trasa?op=list'>");
            out.println("</head>");
            out.println("</head>");
            out.println("<body>");
            out.println("Dokonano zmian w profilu kierowca");
            out.println("<a href='trasa?op=list'>do listy </a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
          protected void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String pagina = "/widok/trasa.jsp";
            trasaDAO tr = new trasaADD();
            HttpSession session = request.getSession(true);
            session.setAttribute("list", tr.list());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
            
        }
          
            protected void list2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String pagina = "/widok/CreateTrasa.jsp";
            kierowcaDAO tr = new kierowcaADD();
            HttpSession session2 = request.getSession(true);
            session2.setAttribute("list2", tr.list());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
            
        }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String op = request.getParameter("op");
        String pagina;
        if(op.equals("create")){
            pagina = "/widok/createTrasa.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        }else if(op.equals("update")){
            pagina = "/widok/updateTrasa.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        }else if(op.equals("delete")){
            pagina = "/widok/deleteTrasa.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        }
        
        else if(op.equals("info")){
            pagina = "/widok/infoTrasa.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        }
 
        else{
       this.list(request, response);
    }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        trasa tr = new trasa();
        
        String Sinfo = request.getParameter("info");
        int info = Integer.parseInt(Sinfo);
        
        String Sid = request.getParameter("id");
        int id = Integer.parseInt(Sid);
        
        String Sidk = request.getParameter("id_kierowcy");
        int idk = Integer.parseInt(Sidk);
        
        String Sidc = request.getParameter("id_ciezarowki");
        int idc = Integer.parseInt(Sidc);
        
        String Sidn = request.getParameter("id_naczepy");
        int idn = Integer.parseInt(Sidn);
        
        tr.setId(id);
        tr.setKierowca_id(idk);
        tr.setCiezarowka_id(idc);
        tr.setNaczepa_id(idn);
        tr.setDwyjazd(request.getParameter("dwyjazd"));
        tr.setMwyjazd(request.getParameter("mwyjazd"));
        tr.setDpowrot(request.getParameter("dpowrot"));
        tr.setMpowrot(request.getParameter("mpowrot"));

        trasaDAO kierowDAO = new trasaADD();
        if(info==0){
        kierowDAO.save(tr);
        }
        else if(info==1){
        kierowDAO.delete(id);
        }
        this.list(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
