/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thien.ws1.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thien.ws1.controller.Action;
import thien.ws1.controller.Navigation;
import thien.ws1.dao.AccountDAO;
import thien.ws1.dao.CategoryDAO;
import thien.ws1.dao.ProductDAO;
import thien.ws1.dto.Account;
import thien.ws1.dto.Category;
import thien.ws1.dto.Product;

/**
 *
 * @author Thienlm30
 */
public class SubmitAddProductServlet extends HttpServlet {

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
            String productId = request.getParameter("productId");
            String productName = request.getParameter("productName");
            String productImage = request.getParameter("productImage");
            String brief = request.getParameter("brief");
            Date postedDate = Date.valueOf(request.getParameter("postedDate"));
            String unit = request.getParameter("unit");
            String typeId = request.getParameter("typeId");
            CategoryDAO cd = new CategoryDAO();
            Category c = cd.getObjectById(String.valueOf(typeId));
            String acc = request.getParameter("account");
            AccountDAO ad = new AccountDAO();
            Account account = ad.getObjectById(acc);
            int price = Integer.parseInt(request.getParameter("price"));
            int discount = Integer.parseInt(request.getParameter("discount"));

            String url = "MainController?action=" + Action.WELCOME;
            String message = "";
            ProductDAO d = new ProductDAO();

            if (d.getObjectById(productId) != null) {
                message = "Product Id already exists";
                request.setAttribute("message", message);
                url = "MainController?action=" + Action.ADD_PRODUCT;
            } else {
                d = new ProductDAO();
                Product p = new Product(productId, productName, productImage, brief, postedDate, c, account, unit, price, discount);
                if (d.insertRec(p) != 0) {
                    url = Navigation.URL_VIEW_PRODUCT_DETAIL;
                }
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
