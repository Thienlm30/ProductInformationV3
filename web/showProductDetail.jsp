<%-- 
    Document   : showProductDetail
    Created on : 23-Jun-2024, 20:00:10
    Author     : Thienlm30
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="header.jsp" %>
        <title>Product Detail</title>
    </head>
    <body>
        <div class="flex items-center justify-center min-h-screen bg-gray-100">
            <div class="max-w-7xl mx-auto px-8">
                <div class="grid grid-cols-1 md:grid-cols-4 gap-4">
                    <div class="col-span-1 md:col-span-2">
                        <div class="max-w-md rounded-lg overflow-hidden shadow-lg bg-white">
                            <div class="w-full h-160 overflow-hidden">
                                <img class="object-cover w-full h-full" src=".${param.productImage}">
                            </div>
                        </div>
                    </div>


                    <div class="col-span-1 md:col-span-2">
                        <div class="max-w-md bg-white shadow-lg rounded-lg overflow-hidden">
                            <div class="px-6 py-4">
                                <div class="font-bold text-xl mb-2">${param.productName}</div>
                                <p class="text-gray-700 text-base mb-4">${param.brief}</p>
                                <div class="flex items-center mb-2">
                                    <c:choose>
                                        <c:when test="${param.discount != 0}">
                                            <span class="text-green-600 text-sm font-semibold">${param.price - (param.price * param.discount / 100)} VND</span>
                                            <span class="text-gray-600 text-sm line-through mr-2">${param.price} VND</span>
                                            <span class="text-red-600 text-sm ml-2">${param.discount}% OFF</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="text-green-600 text-sm font-semibold">${param.price} VND</span>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mt-4">
                                    <p class="text-gray-700 text-sm"><span class="font-semibold">Unit:</span> ${param.unit}</p>
                                    <p class="text-gray-700 text-sm"><span class="font-semibold">Name:</span> ${param.productName}</p>
                                    <p class="text-gray-700 text-sm"><span class="font-semibold">Availability:</span> In stock</p>
                                    <p class="text-gray-700 text-sm"><span class="font-semibold">Condition:</span> New</p>
                                    <p class="text-gray-700 text-sm"><span class="font-semibold">Shipping:</span> Free Shipping</p>
                                </div>
                                <form action="MainController" method="post">
                                    <input type="hidden" name="productId" value="${param.productId}" />
                                    <input type="hidden" name="productName" value="${param.productName}" />
                                    <input type="hidden" name="productImage" value="${param.productImage}" />
                                    <input type="hidden" name="brief" value="${param.brief}" />
                                    <input type="hidden" name="postedDate" value="${param.postedDate}" />
                                    <input type="hidden" name="unit" value="${param.unit}" />
                                    <input type="hidden" name="typeId" value="${param.typeId}" />
                                    <input type="hidden" name="account" value="${param.account}" />
                                    <input type="hidden" name="price" value="${param.price}" />
                                    <input type="hidden" name="discount" value="${param.discount}" />
                                    <div class="flex justify-between mt-7">
                                        <c:choose>
                                            <c:when test="${sessionScope.loginedAcc.roleInSystem == 1 || sessionScope.loginedAcc.roleInSystem == 2}">
                                                <button class="px-4 py-2 bg-green-500 hover:bg-green-600 text-white rounded-lg" type="submit" name="action" value="<%= Action.UPDATE_PRODUCT%>">Update</button>
                                                <button class="px-4 py-2 bg-red-500 hover:bg-red-600 text-white rounded-lg" type="submit" name="action" value="<%= Action.DELETE_PRODUCT%>">Delete</button>
                                            </c:when>
                                            <c:otherwise>
                                                <button class="mt-4 bg-blue-500 hover:bg-blue-600 text-white py-2 px-4 rounded focus:outline-none focus:shadow-outline">Add to Cart</button>
                                            </c:otherwise>
                                        </c:choose>
                                        <button class="mt-4 text-blue-500 hover:text-blue-600 hover:underline py-2 px-4" name="action" value="<%= Action.WELCOME%>">Back</button>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

    </body>
</html>
