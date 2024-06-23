/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thien.ws1.controller;

/**
 *
 * @author Thienlm30
 */
public interface Navigation {
    public final String URL_ERROR = "";
    public final String URL_WELCOME = "index.jsp";
    public final String URL_LOGIN_FORM = "login.jsp";
    public final String URL_LOGOUT = "LogoutServlet";
    // account
    public final String URL_ACCOUNT_SERVLET = "ListAccountServlet";
    public final String URL_VIEW_ACCOUNT = "viewAccount.jsp";
    public final String URL_ACTIVE_SERVLET = "ActiveServlet";
    public final String URL_UPDATE_ACCOUNT_SERVLET = "UpdateAccountServlet";
    public final String URL_REGISTER_SERVLET = "RegisterServlet";
    public final String URL_REGISTER_FORM = "register.jsp";
    public final String URL_VIEW_UPDATE_ACCOUNT = "viewUpdateAccount.jsp";
    public final String URL_DELETE_ACCOUNT_SERVLET = "DeleteAccountServlet";
    
    // product
    public final String URL_VIEW_PRODUCT = "viewProduct.jsp";
    public final String URL_PRODUCT_SERVLET = "ListProductServlet";
    
    // category
    public final String URL_VIEW_CATEGORY = "viewCategory.jsp";
    public final String URL_CATEGORY_SERVLET = "ListCategoryServlet";
    public final String URL_ADD_CATEGORY_SERVLET = "AddCategoryServlet";
    public final String URL_VIEW_ADD_CATEGORY = "addCategory.jsp";
    public final String URL_SUBMIT_ADD_CATEGORY_SERVLET = "SubmitAddCategoryServlet";
    
    
    
    
}   