/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thien.ws1.controller;

/**
 * The Action interface contains constants representing different actions
 * that can be used to set the value of the `action` parameter in a String query.
 * This interface includes actions related to login, account management, 
 * category management, and product management.
 * 
 * @author Thienlm30
 */
public interface Action {
    
    /** Action for logging in */
    public final String LOGIN = "login";
    /** Action for welcoming a user */
    public final String WELCOME = "welcome";
    /** Action for logging out */
    public final String LOGOUT = "logout";
    
    
    // account
    /** Action for viewing an account */
    public final String VIEW_ACCOUNT = "account";
    /** Action for updating an account */
    public final String UPDATE = "update";
    /** Action for deleting an account */
    public final String DELETE = "delete";
    /** Action for activating an account */
    public final String ACTIVE = "active";
    /** Action for registering a new account */
    public final String REGISTER = "register";
    /** Action for submitting an update to an account */
    public final String SUBMIT_UPDATE = "submit-update";
    /** Action for adding a new account */
    public final String ADD_NEW_ACCOUNT = "add-new-account";
    
    
    // category
    /** Action for viewing a category */
    public final String VIEW_CATEGORY = "category";
    /** Action for updating a category */
    public final String UPDATE_CATEGORY = "update-category";
    /** Action for submitting an update to a category */
    public final String SUBMIT_UPDATE_CATEGORY = "submit-update-category";
    /** Action for deleting a category */
    public final String DELETE_CATEGORY = "delete-category";
    /** Action for adding a new category */
    public final String ADD_CATEGORY = "add-category";
     /** Action for submitting the addition of a new category */
    public final String SUBMIT_ADD_CATEGORY = "submit-add-category";
    
    
    // product
    /** Action for showing details of a product */
    public final String SHOW_DETAIL = "show-detail";
    /** Action for updating a product */
    public final String UPDATE_PRODUCT = "update-product";
    /** Action for submitting an update to a product */
    public final String SUBMIT_UPDATE_PRODUCT = "submit-update-product";
    /** Action for deleting a product */
    public final String DELETE_PRODUCT = "delete-product";
     /** Action for adding a new product */
    public final String ADD_PRODUCT = "add-product"; 
    /** Action for submitting the addition of a new product */
    public final String SUBMIT_ADD_PRODUCT = "submit-add-product";
    

}   