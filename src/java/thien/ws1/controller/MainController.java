/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thien.ws1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thienlm30
 */
public class MainController extends HttpServlet {

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
            String url = "";
            String action = request.getParameter("action");

            if (action == null) {
                action = Action.WELCOME;
            }
            switch (action) {
                case Action.WELCOME:
                    url = Navigation.URL_WELCOME;
                    break;                    
                case Action.LOGIN:
                    url = Navigation.URL_LOGIN_FORM;
                    break;
                case Action.LOGOUT:
                    url = Navigation.URL_LOGOUT;
                    break;
                    
                // account
                case Action.VIEW_ACCOUNT:
                    url = Navigation.URL_ACCOUNT_SERVLET;
                    break;
                case Action.ACTIVE:
                    url = Navigation.URL_ACTIVE_SERVLET;
                    break;
                case Action.UPDATE:
                    url = Navigation.URL_VIEW_UPDATE_ACCOUNT;
                    break;
                case Action.SUBMIT_UPDATE:
                    url = Navigation.URL_UPDATE_ACCOUNT_SERVLET;
                    break;
                case Action.REGISTER:
                    url = Navigation.URL_REGISTER_FORM;
                    break;
                case Action.ADD_NEW_ACCOUNT:
                    url = Navigation.URL_REGISTER_SERVLET;
                    break;
                case Action.DELETE:
                    url = Navigation.URL_DELETE_ACCOUNT_SERVLET;
                    break;
                    
                // category
                case Action.VIEW_CATEGORY:
                    url = Navigation.URL_CATEGORY_SERVLET;
                    break;
                case Action.ADD_CATEGORY:
                    url = Navigation.URL_VIEW_ADD_CATEGORY;
                    break;
                case Action.SUBMIT_ADD_CATEGORY:
                    url = Navigation.URL_SUBMIT_ADD_CATEGORY_SERVLET;
                    break;
                case Action.UPDATE_CATEGORY:
                    url = "";
                    break;
                case Action.DELETE_CATEGORY:
                    url = "";
                    break;
                
                    
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
