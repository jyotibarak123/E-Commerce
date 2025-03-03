<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="com.ducat.modal.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
	<nav class="navbar navbar-expand-lg bg-body-tertiary"
		data-bs-theme='dark'>
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp">E-MegaMart</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp">Products</a></li>
					<li class="nav-item"><a class="nav-link" href="cart.jsp">Cart<span class="badge badge-danger">${cart.size()}</span> </a></li>
					<li class="nav-item"><a class="nav-link" href="creditcard.jsp">Payment
							</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Category </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="phone.jsp">Phone</a></li>
							<li><a class="dropdown-item" href="laptop.jsp">Laptop</a></li>
							<li><a class="dropdown-item" href="tablet.jsp">Tablet
							</a></li>
						</ul></li>
				</ul>
				<div class='flex justify-content-between'>
				<%
				HttpSession session = request.getSession(false);
				Student curStu = new Student();
				if (session != null) {
					curStu = (Student) session.getAttribute("user");
 					
				if (curStu!=null && curStu.getEmail() != null)
				{  %>
					<span class='text-white'>Welcome : <%= curStu.getName()%></span>
					
					 <a href="LogoutController"> <button class='btn btn-warning'>logout</button>
					</a>
					
			<% 	} 
				else
				{ %>
					
					  <a href="login.jsp"><button class='btn btn-success'>login</button></a>
					  <a href="register.jsp"><button class='btn btn-primary'>register</button></a>
				
				<%}
				}
				%>
				</div>
				
			</div>
		</div>
	</nav>
	<nav class="navbar" data-bs-theme="light"
			style="height: 120px; background-color: rgb(220, 220, 220);">
			<div class="container-fluid d-block">
				<h1 style="text-align: center;">Electronics item</h1>
				<form class="d-flex" role="search" style="margin-left: 510px">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search" style="width: 400px;">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</nav>
	
	
					
	
