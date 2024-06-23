/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thien.ws1.controller.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thien.ws1.controller.Action;
import thien.ws1.dao.AccountDAO;
import thien.ws1.dto.Account;

/**
 *
 * @author Thienlm30
 */
public class UpdateAccountServlet extends HttpServlet {

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
            request.setCharacterEncoding("UTF-8");
            String account = request.getParameter("account");
            String pass = request.getParameter("pass");
            String lastName = request.getParameter("lastName");
            String firstName = request.getParameter("firstName");
            Date birthday = Date.valueOf(request.getParameter("birthday"));
            boolean gender = request.getParameter("gender").equals("1");
            String phone = request.getParameter("phone");
            boolean isUse = request.getParameter("isUse").equals("1");
            int roleInSystem = Integer.parseInt(request.getParameter("roleInSystem"));
            
            AccountDAO d = new AccountDAO();
            String url = "";
            if (d.getObjectById(account) != null) {
                Account acc = new Account(account, pass, lastName, firstName, birthday, gender, phone, isUse, roleInSystem);
                d = new AccountDAO();
                if (d.updateRec(acc) != 0) {
                    url = "MainController?action=" + Action.VIEW_ACCOUNT;
                } else {
                    url = "MainController?action=" + Action.WELCOME;
                }
                
            } else {
                System.out.println("error in UpdateAccountServlet");
            }
            request.getRequestDispatcher(url).forward(request, response);
        }
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
        processRequest(request, response);
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
