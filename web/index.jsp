<%-- 
    Document   : index
    Created on : 10-Jun-2024, 21:28:52
    Author     : Thienlm30
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                            <div class="group w-80 rounded-lg overflow-hidden shadow-lg bg-white m-4 relative hover:shadow-xl transition duration-300 ease-in-out transform hover:-translate-y-1 hover:scale-105">
                                <div class="w-full h-80 overflow-hidden">
                                    <img class="object-cover w-full h-full" src=".${product.productImage}" alt="${product.productName}">
                                </div>
                                <div class="px-6 py-4">
                                    <div class="font-bold text-sm mb-2">${product.productName}</div>
                                    <div class="flex justify-between items-center">
                                        <div>
                                            <c:choose>
                                                <c:when test="${product.discount != 0}">
                                                    <span class="text-gray-600 text-sm line-through mr-2">${product.price} VND</span>
                                                    <span class="text-green-600 text-sm font-semibold">${product.price - (product.price * product.discount / 100)} VND</span>
                                                    <span class="text-red-600 text-sm ml-2">${product.discount}% OFF</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="text-green-600 text-sm font-semibold">${product.price} VND</span>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </button>
                    </form>
                </c:forEach>
            </div>
        </div>
    </body>
</html>