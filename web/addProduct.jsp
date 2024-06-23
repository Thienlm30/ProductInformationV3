<%-- 
    Document   : addProduct
    Created on : 23-Jun-2024, 21:14:10
    Author     : Thienlm30
--%>

<%@page import="java.time.LocalDate"%>
<%@page import="thien.ws1.controller.Action"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/addNew.css" rel="stylesheet" type="text/css"/>
        <%@include file="header.jsp" %>
        <title>Add Product</title>
    </head>
    <body class="flex-block items-center  min-h-screen bg-gray-100">
        <div class="my-24 mx-32">
            <div class="bg-white p-8 rounded-lg shadow-lg w-full max-w-screen-xl">
                <c:set var="selectedTypeId" value="${sessionScope.selectedTypeId}" />
                <form action="MainController" method="post">
                    <div class="div-style">
                        <label for="productId" class="label-style">Product Id</label>
                        <p class="text-red-600">${message}</p>
                        <input class="input-style" type="text" id="productId" name="productId" placeholder="Enter product Id" required="" value="${param.productId}"/>
                    </div>
                    <div class="div-style">
                        <label for="productName" class="label-style">Product Name</label>
                        <input class="input-style" type="text" id="productName" name="productName" placeholder="Enter product Name" required="" value="${param.productName}"/>
                    </div>
                    <div class="div-style">
                        <label for="productImage" class="label-style">Product Image</label>
                        <input class="input-style" type="txt" name="productImage" placeholder="Enter link product Image" required="" value="${param.productImage}" />
                    </div>
                    <div class="div-style">
                        <label for="brief" class="label-style">Brief</label>
                        <textarea class="input-style" id="brief" name="brief" placeholder="Enter brief" >${param.brief}</textarea>
                    </div>
                    <div>
                        <input class="input-style" type="hidden" id="postedDate" name="postedDate" value="<%= LocalDate.now()%>" required />
                    </div>
                    <div class="div-style">
                        <label for="unit" class="label-style">Unit</label>
                        <input class="input-style" type="text" id="unit" name="unit" placeholder="unit" required="" value="${param.unit}"/>
                    </div>
                    <div class="div-style">
                        <label for="typeId" class="label-style">Type</label>
                        <select class="input-style" id="typeId" name="typeId" required>
                            <c:forEach var="option" items="${categoryList}">
                                <option value="${option.typeId}" ${selectedTypeId != null && selectedTypeId == option.typeId ? 'selected="selected"' : ''}> ${option.categoryName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <input class="input-style" type="hidden" id="account" name="account" value="${loginedAcc.account}"/>
                    </div>
                    <div class="div-style">
                        <label for="price" class="label-style">price</label>
                        <input class="input-style" type="number" name="price" id="price" placeholder="Enter price"  required="" value="${param.price}"/>
                    </div>
                    <div class="div-style">
                        <label for="discount" class="label-style">discount</label>
                        <input class="input-style" type="number"  name="discount" id="discount" placeholder="Enter discount" required="" value="${param.discount}"/>
                    </div>

                    <button type="submit" class="button-style" name="action" value="<%= Action.SUBMIT_ADD_PRODUCT %>">Add</button>
                </form>
            </div>
        </div>
    </body>
</html>
