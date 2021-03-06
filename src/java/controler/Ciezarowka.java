/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.ciezarowkaADD;
import dao.ciezarowkaDAO;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ciezarowka;
/**
 *
 * @author Dawid
 */
public class Ciezarowka extends HttpServlet {
    
   

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
            out.println("<meta http-equiv='refresh' content='0; URL=ciezarowka?op=list'>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Dokonano zmian w profilu kierowca");
            out.println("<a href='kierowcy?op=list'>do listy </a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
          protected void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String pagina = "/widok/ciezarowka.jsp";
            ciezarowkaDAO kierow = new ciezarowkaADD();
            HttpSession session = request.getSession(true);
            session.setAttribute("list", kierow.list());
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
            pagina = "/widok/createCiezarowka.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        }else if(op.equals("update")){
            pagina = "/widok/updateCiezarowka.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        }else if(op.equals("delete")){
            pagina = "/widok/deleteCiezarowka.jsp";

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
        
        ciezarowka kierow = new ciezarowka();
        
        String Sinfo = request.getParameter("info");
        int info = Integer.parseInt(Sinfo);
        
        String Sid = request.getParameter("id");
        int id = Integer.parseInt(Sid);
        
        kierow.setId(id);
        kierow.setMarka(request.getParameter("marka_ciezarowki"));
        kierow.setModel(request.getParameter("model_ciezarowki"));
        kierow.setRejestracja(request.getParameter("rejestracja_ciezarowki"));
        ciezarowkaDAO kierowDAO = new ciezarowkaADD();
        if(info==0){
        kierowDAO.save(kierow);
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
