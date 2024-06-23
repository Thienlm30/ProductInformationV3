<%-- 
    Document   : viewUpdateCategory
    Created on : 23-Jun-2024, 17:16:50
    Author     : Thienlm30
--%>

<%@page import="thien.ws1.controller.Action"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/addNew.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="flex-block items-center  min-h-screen bg-gray-100">
       <div class="my-24 mx-32">
           <div class="bg-white p-8 rounded-lg shadow-lg w-full max-w-screen-xl">
               
               <form action="MainController" method="post">
                   <div class="div-style">
                       <label for="typeId" class="label-style">ID</label>
                       <input class="input-style cursor-not-allowed bg-gray-100" type="text" name="typeId" value="${param.typeId}" readonly/>
                   </div>
                   <div class="div-style">
                       <label for="categoryName" class="label-style">Category Name</label>
                       <input class="input-style" type="text" name="categoryName" value="${param.categoryName}" placeholder="Enter name" required=""/>
                   </div>
                   <div class="div-style">
                       <label for="memo" class="label-style">Memo</label>
                       <textarea class="input-style" name="memo" placeholder="Enter memo">${param.memo}</textarea>
                   </div>
                   <div class="div-style">
                        <p class="error-message">${msg}</p>
                    </div>
                   <button type="submit" class="button-style" name="action" value="<%= Action.SUBMIT_UPDATE_CATEGORY %>">Update</button>
               </form>
           </div>
       </div>
    </body>
</html>