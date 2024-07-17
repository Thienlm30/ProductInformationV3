/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thien.ws1.controller;

/**
 * The Navigation interface contains constants representing URLs for various pages 
 * and servlets in the application. These constants are used for page navigation 
 * and redirection.
 *
 * @author Thienlm30
 */
public interface Navigation {
    /** URL for error page */
    public final String URL_ERROR = "";
    /** URL for the welcome page, typically showing a list of products */
    public final String URL_WELCOME = "ListProductServlet";
    /** URL for the home page */
    public final String URL_HOME = "index.jsp";
    /** URL for the login form */
    public final String URL_LOGIN_FORM = "login.jsp";
    /** URL for the logout servlet */
    public final String URL_LOGOUT = "LogoutServlet";
    
    
    // account
    /** URL for the account servlet */
    public final String URL_ACCOUNT_SERVLET = "ListAccountServlet";
    /** URL for viewing an account */
    public final String URL_VIEW_ACCOUNT = "viewAccount.jsp";
    /** URL for the active servlet */
    public final String URL_ACTIVE_SERVLET = "ActiveServlet";
    /** URL for the update account servlet */
    public final String URL_UPDATE_ACCOUNT_SERVLET = "UpdateAccountServlet";
    /** URL for the register servlet */
    public final String URL_REGISTER_SERVLET = "RegisterServlet";
    /** URL for the register form */
    public final String URL_REGISTER_FORM = "register.jsp";
    /** URL for viewing the update account page */
    public final String URL_VIEW_UPDATE_ACCOUNT = "viewUpdateAccount.jsp";
    /** URL for the delete account servlet */
    public final String URL_DELETE_ACCOUNT_SERVLET = "DeleteAccountServlet";
    
    // product
    /** URL for the product detail servlet */
    public final String URL_PRODUCT_DETAIL_SERVLET = "ProductDetailServlet";
     /** URL for viewing product details */
    public final String URL_VIEW_PRODUCT_DETAIL = "showProductDetail.jsp";
    /** URL for viewing the add product page */
    public final String URL_VIEW_ADD_PRODUCT = "addProduct.jsp";
    /** URL for adding a product */
    public final String URL_ADD_PRODUCT = "AddProductServlet";
    /** URL for submitting the addition of a product */
    public final String URL_SUBMIT_ADD_PRODUCT_SERVLET = "SubmitAddProductServlet";
    /** URL for viewing the update product page */
    public final String URL_VIEW_UPDATE_PRODUCT = "viewUpdateProduct.jsp";
    /** URL for the update product servlet */
    public final String URL_UPDATE_PRODUCT_SERVLET = "UpdateProductServlet";
    /** URL for the delete product servlet */
    public final String URL_DELETE_PRODUCT_SERVLET = "DeleteProductServlet";
    
    
    // category
    /** URL for viewing categories */
    public final String URL_VIEW_CATEGORY = "viewCategory.jsp";
    /** URL for the category servlet */
    public final String URL_CATEGORY_SERVLET = "ListCategoryServlet";
    /** URL for adding a category */
    public final String URL_ADD_CATEGORY_SERVLET = "AddCategoryServlet";
    /** URL for viewing the add category page */
    public final String URL_VIEW_ADD_CATEGORY = "addCategory.jsp";
    /** URL for submitting the addition of a category */
    public final String URL_SUBMIT_ADD_CATEGORY_SERVLET = "SubmitAddCategoryServlet";
    /** URL for the update category servlet */
    public final String URL_UPDATE_CATEGORY_SERVLET = "UpdateCategoryServlet";
    /** URL for viewing the update category page */
    public final String URL_VIEW_UPDATE_CATEGORY = "viewUpdateCategory.jsp";
    /** URL for deleting a category */
    public final String URL_DELETE_CATEGORY = "DeleteCategoryServlet";
    
    
    
    
    
}   