<%-- 
    Document   : header
    Created on : 16-Jun-2024, 17:28:56
    Author     : Thienlm30
--%>

<%@page import="thien.ws1.controller.Action"%>
<%@page import="thien.ws1.dto.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Intro</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" rel="stylesheet">
    </head>
    <body>
        <nav class="bg-gray-200 shadow shadow-gray-300 w-100 px-8 md:px-auto sticky top-0 z-50">
            <div class="md:h-16 h-28 mx-auto md:px-4 container flex items-center justify-between flex-wrap md:flex-nowrap">
                <div>
                    <c:if test="${not empty loginedAcc}">
                        <p>Welcome <span style="color: red; font-weight: bold">${loginedAcc.account}</span> ${loginedAcc.lastName} ${loginedAcc.firstName}</p>
                    </c:if>
                </div>
                <div class="text-gray-500 order-3 w-full md:w-auto md:order-3">
                    <ul class="flex font-semibold justify-between">
                        <li class="md:px-4 md:py-2 text-indigo-500"><a href="MainController?action=<%= Action.WELCOME%>">Home</a></li>
                        <li class="md:px-4 md:py-2 hover:text-indigo-400"><a href="MainController?action=<%= Action.VIEW_ACCOUNT%>">Account</a></li>
                        <li class="md:px-4 md:py-2 hover:text-indigo-400"><a href="MainController?action=<%= Action.VIEW_CATEGORY%>">Categories</a></li>
                        <li class="md:px-4 md:py-2 hover:text-indigo-400"><a href="MainController?action=<%= Action.VIEW_PRODUCT%>">Product</a></li>
                    </ul>
                </div>
                <div class="order-2 md:order-3">
                    <c:choose>
                        <c:when test="${not empty loginedAcc}">
                            <button class="px-4 py-2 bg-red-500 hover:bg-red-600 text-gray-50 rounded-xl flex items-center gap-2">
                                <a href="MainController?action=<%= Action.LOGOUT%>">Logout</a>
                            </button>
                        </c:when>
                        <c:otherwise>
                            <button class="px-4 py-2 bg-indigo-500 hover:bg-indigo-600 text-gray-50 rounded-xl flex items-center gap-2">
                                <a href="MainController?action=<%= Action.LOGIN%>">Login</a>
                            </button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </nav>
    </body>
</html>