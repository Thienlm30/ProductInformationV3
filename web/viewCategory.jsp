<%-- 
    Document   : viewCategory
    Created on : 23-Jun-2024, 15:07:12
    Author     : Thienlm30
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/table.css" rel="stylesheet" type="text/css"/>
        <title>Category List JSP</title>
    </head>
    <body>
        <div class="table-container">
            <div class="table-wrapper">
                <h1 class="text-2xl font-bold mb-4">List of categories in system</h1>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NAME</th>
                            <th>MEMO</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="category" items="${categoryList}">
                        <tr>
                            <td>${category.typeId}</td>
                            <td>${category.categoryName}</td>
                            <td>${category.memo}</td>
                            <td>
                                <form action="MainController" method="post">
                                    <input type="hidden" name="typeId" value="${category.typeId}" />
                                    <input type="hidden" name="categoryName" value="${category.categoryName}" />
                                    <input type="hidden" name="memo" value="${category.memo}" />
                                    <button class="update" type="submit" name="action" value="<%= Action.UPDATE_CATEGORY %>">Update</button>
                                    <button class="delete" type="submit" name="action" value="<%= Action.DELETE_CATEGORY %>">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <form action="MainController" method="post">
                    <div class="flex w-full justify-center mt-7">
                        <button class="deactivate" type="submit" name="action" value="<%= Action.ADD_CATEGORY %>">Add new Category</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
