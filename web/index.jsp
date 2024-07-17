<%-- 
    Document   : index
    Created on : 10-Jun-2024, 21:28:52
    Author     : Thienlm30
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/WEB-INF/tlds/mytags.tld" prefix="t" %>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Workshop1</title>
    </head>
    <body>

        <div class="flex items-center justify-center min-h-screen bg-gray-100">
            <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6 p-6">
                <c:forEach var="product" items="${productList}">
                    <form action="MainController" method="post">
                        <input type="hidden" name="productId" value="${product.productId}" />
                        <input type="hidden" name="productName" value="${product.productName}" />
                        <input type="hidden" name="productImage" value="${product.productImage}" />
                        <input type="hidden" name="brief" value="${product.brief}" />
                        <input type="hidden" name="postedDate" value="${product.postedDate}" />
                        <input type="hidden" name="unit" value="${product.unit}" />
                        <input type="hidden" name="typeId" value="${product.type.typeId}" />
                        <input type="hidden" name="account" value="${product.account}" />
                        <input type="hidden" name="price" value="${product.price}" />
                        <input type="hidden" name="discount" value="${product.discount}" />
                        <button type="submit" name="action" value="<%= Action.SHOW_DETAIL%>">
                            <t:ShowProduct name="${product.productName}" price="${product.price}" image="${product.productImage}" discount="${product.discount}"></t:ShowProduct>
                        </button>
                    </form>
                </c:forEach>
            </div>
        </div>
    </body>
</html>