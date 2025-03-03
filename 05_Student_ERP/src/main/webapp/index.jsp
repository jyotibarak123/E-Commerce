<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.ducat.modal.Product"%>
<%@page import="com.ducat.dao.ProductDao"%>
<%@page import="com.ducat.dao.impl.ProductDaoImpl"%>
<jsp:include page="components/headcdn.jsp"></jsp:include>
<jsp:include page="components/navbar.jsp"></jsp:include>
<style>
body{
background-color:rgb(220, 220, 220);
}
</style>

<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel" ">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="3" aria-label="Slide 4"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="4" aria-label="Slide 5"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="5" aria-label="Slide 6"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active" data-bs-interval="2000">
      <img src="https://images.unsplash.com/photo-1565995487495-e2a23f3af2ee?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8bW9iaWxlJTIwYW5kJTIwbGFwdG9wfGVufDB8fDB8fHww" class="d-block w-100" height="540px"  alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h1>Welcome to E-MegaMart</h1>
        <button class="btn btn-danger">Laptop</button>
        <button class="btn btn-primary">Phone</button>
        <button class="btn btn-success">Tablet</button>
      </div>
    </div>
    <div class="carousel-item" data-bs-interval="2000">
      <img src="https://plus.unsplash.com/premium_photo-1661346003893-06c36b3aeb44?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8bW9iaWxlJTIwYW5kJTIwbGFwdG9wfGVufDB8fDB8fHww" class="d-block w-100" height="540px"  alt="...">
      <div class="carousel-caption d-none d-md-block">
         <h1>Welcome to E-MegaMart</h1>
        <button class="btn btn-danger">Laptop</button>
        <button class="btn btn-primary">Phone</button>
        <button class="btn btn-success">Tablet</button>
      </div>
    </div>
    <div class="carousel-item" data-bs-interval="2000">
      <img src="https://images.unsplash.com/photo-1542345307-d87fd97e0ed5?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fG1vYmlsZSUyMGFuZCUyMGxhcHRvcHxlbnwwfHwwfHx8MA%3D%3D" class="d-block w-100" height="540px"  alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h1>Welcome to E-MegaMart</h1>
        <button class="btn btn-danger">Laptop</button>
        <button class="btn btn-primary">Phone</button>
        <button class="btn btn-success">Tablet</button>
      </div>
    </div>
    <div class="carousel-item" data-bs-interval="2000">
      <img src="https://images.unsplash.com/photo-1563660908188-1af7b8a6388c?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTh8fG1vYmlsZSUyMGFuZCUyMGxhcHRvcHxlbnwwfHwwfHx8MA%3D%3D" class="d-block w-100" height="540px"  alt="...">
      <div class="carousel-caption d-none d-md-block">
         <h1>Welcome to E-MegaMart</h1>
        <button class="btn btn-danger">Laptop</button>
        <button class="btn btn-primary">Phone</button>
        <button class="btn btn-success">Tablet</button>
      </div>
    </div>
    <div class="carousel-item" data-bs-interval="2000">
      <img src="https://images.unsplash.com/photo-1574144632346-0d82d0dead5a?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8bW9iaWxlJTIwYW5kJTIwbGFwdG9wfGVufDB8fDB8fHww" class="d-block w-100" height="540px"  alt="...">
      <div class="carousel-caption d-none d-md-block">
         <h1>Welcome to E-MegaMart</h1>
        <button class="btn btn-danger">Laptop</button>
        <button class="btn btn-primary">Phone</button>
        <button class="btn btn-success">Tablet</button>
      </div>
    </div>
    <div class="carousel-item" data-bs-interval="2000">
      <img src="https://images.unsplash.com/photo-1426024084828-5da21e13f5dc?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8bW9iaWxlJTIwYW5kJTIwbGFwdG9wfGVufDB8fDB8fHww" class="d-block w-100" height="540px"  alt="...">
      <div class="carousel-caption d-none d-md-block">
         <h1>Welcome to E-MegaMart</h1>
        <button class="btn btn-danger">Laptop</button>
        <button class="btn btn-primary">Phone</button>
        <button class="btn btn-success">Tablet</button>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>



<%
    ProductDao dao = new ProductDaoImpl();
    List<Product> pro = dao.getAllProducts();
    request.setAttribute("products", pro);

%>
	<c:forEach var="product" items="${products}">
	
<div class="container d-flex justify-content-center">
<div data-aos="flip-left">
	<div class="card mb-3" style="max-width: 600px; min-height: 270px; margin-top:100px;">
   	 <div class="row g-4">
		<div class="col-md-4 mh-4">
			<img src="${product.image}" class="img-fluid rounded-start"
				alt="...">
		</div>
		<div class="col-md-8">
			<div class="card-body">
				<h5 class="card-title" style="color: green;">${product.title}</h5>
				<p class="card-text">${product.description}</p>
				<h2 class="justify-content:center" style="color: red;">${product.price}</h2>
				<br>
				<a href ="AddToCart?id=${product.id}"><button class="btn btn-success">Add to Cart</button></a>
				<button class="btn btn-primary">Buy now</button>
				
			</div>
		</div>
		</div>
	</div>
	</div>
	</div>
	</c:forEach>
	



<jsp:include page="components/footscript.jsp"></jsp:include>