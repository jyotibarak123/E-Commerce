<%@page import="com.ducat.dao.impl.OrderDaoImpl"%>
<%@page import="com.ducat.dao.OrderDao"%>
<%@page import="com.ducat.modal.Order"%>
<jsp:include page="components/headcdn.jsp"></jsp:include>
<jsp:include page="components/navbar.jsp"></jsp:include>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"></script>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="com.ducat.modal.Product"%>




<div class="container mt-5"
	style="justify-content: center; align-items: center;">
	<h2 style="justify-content: center;">Your Cart Items</h2>
	<table class="table table-striped" border='1'>
		<thead class="table-dark">
			<tr>
				<th>Product Name</th>
				<th>Description</th>
				<th>Price</th>
				<th>Buy Now</th>
				<th>Remove</th>
			</tr>
		</thead>
		<tbody>

			<%
			
       HttpSession session = request.getSession(false);
       if(session!=null)
       {
         ArrayList<Order>cartlist = (ArrayList<Order>) session.getAttribute("cart"); 
       if(cartlist!=null && !cartlist.isEmpty()) {
    	   for(Order product : cartlist){    %>
			<tr>
				<td><%=product.getTitle()%></td>
				<td><%=product.getDescription()%></td>
				<td>Rs: <%=product.getPrice()%></td>
				<td>
              <div class="d-flex align-items-center">
             <form action="updateQuantity" method='get'>
             <input type="hidden" value="<%=product.getP_id()%>" id='id' name='id'>
             <input type="hidden" value="<%=product.getO_id()%>" id='id' name='o_id'>
             <input type="hidden" value="<%=product.getO_quantity()%>" id="orderInput" name="orderQuantity">
             <button type="button" class="btn btn-primary" name="action" value="increment" onclick="updateQuantity(this, 'increment')">+</button>
             <input type="text" name="quantity" class="form-control text-center" id="orderQuantity" value="<%=product.getO_quantity()%>" style="width: 70px;" readonly>            
            <button type="button" class="btn btn-primary" name="action" value="decrement" onclick="updateQuantity(this, 'decrement')">-</button>
            <a href="creditcard.jsp?price=<%=product.getPrice()%>"><button type="submit" class="btn btn-primary">Buy</button></a> 
            
        </form>
        </div>
				</td>
				<td><a href="RemoveController?id=<%=product.getP_id()%>"><button class="btn btn-danger">Remove item</button></a></td>
			</tr>

			<%} }else { %>
			<tr>
				<td colspan="3">No items in cart</td>
			</tr>

			<% } }  else { %>
			<tr>
			<td>session is null</td>
			</tr>
			<%  }%>

		</tbody>
	</table>
</div>

 <script> 
     function updateQuantity(button, type) {
    let form = button.closest("form"); 
    let input = form.querySelector("input[name='quantity']");
    let hiddenInput = form.querySelector("input[name='orderQuantity']");
    
    let value = parseInt(input.value);

    if (type === 'increment') {
        value++;
    } 
    else if (type === 'decrement' && value > 1) {
        value--;
    }
    input.value = value;        
    hiddenInput.value = value; 
}
 </script> 
