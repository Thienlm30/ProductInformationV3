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
public interface Action {
    public final String LOGIN = "login";
    public final String WELCOME = "welcome";
    public final String LOGOUT = "logout";
    // account
    public final String VIEW_ACCOUNT = "account";
    public final String UPDATE = "update";
    public final String DELETE = "delete";
    public final String ACTIVE = "active";
    public final String REGISTER = "register";
    public final String SUBMIT_UPDATE = "submit-update";
    public final String ADD_NEW_ACCOUNT = "add-new-account";
    // category
    public final String VIEW_CATEGORY = "category";
    public final String UPDATE_CATEGORY = "update-category";
    public final String SUBMIT_UPDATE_CATEGORY = "submit-update-category";
    public final String DELETE_CATEGORY = "delete-category";
    public final String ADD_CATEGORY = "add-category";
    public final String SUBMIT_ADD_CATEGORY = "submit-add-category";
    
    
    // product
    public final String SHOW_DETAIL = "show-detail";
    public final String UPDATE_PRODUCT = "update-product";
    public final String SUBMIT_UPDATE_PRODUCT = "submit-update-product";
    public final String DELETE_PRODUCT = "delete-product";
    public final String ADD_PRODUCT = "add-product";
    public final String SUBMIT_ADD_PRODUCT = "submit-add-product";
    

}   