
<jsp:include page="components/headcdn.jsp"></jsp:include>
<jsp:include page="components/navbar.jsp"></jsp:include>
<body style="background-color: rgb(220, 220, 220);">



<%
String price = request.getParameter("price");
     if(price==null){
    	 System.out.println("price is null");
     }
     else{
    	 Double pri = Double.parseDouble(price);
     }
%>


	  <div class="container my-4"
		style="box-sizing: border-box; border: 2px solid gray; border-radius: 20px; width: 600px; height: 500px; justify-content: center; background-color: rgba(1, 1, 1, 0.3); padding-left: 40px; padding-right: 40px; margin-top: 300px;">
		 <div class="container my-4">
		   <h1 style="text-align: center; margin-bottom:50px; margin-top:40px;">Credit Card Payment</h1>
			 <form action="CreditCardController" method="post">
			   <div class="row">
		         <table>
				   <div class="col-md-12">
					 <tr>
					   <th><label for="fname" class='form-label'>Name of Card Holder : </label></th>
					   <th><input type='text' class='form-control w-100' name='fname' id='fname' placeholder='Enter Card Holder Name' required> </th>
					 </tr>
						</div>
						<div class="col-md-12">
						<tr>
							<th><label for="num" class='form-label'> Enter Credit Card Number :</label> </th>
						    <th><input type='tel' class='form-control' name='num' id='num'	placeholder='1234-1234-1234-1234' required></th>
						</tr>
						</div>
						<div class="col-md-12">
						<tr>
							<th><label for="month" class='form-label'>Expiry Month : </label></th>
							 <th><input type='month' class='form-control' name='month' id='month' placeholder='MM'></th>
						</tr>
						</div>
						<div class="col-md-12">
						<tr>
							<th><label for="year" class='form-label'>Expiry Year : </label></th>
							 <th><input type='number' class='form-control' name='year' id='year' placeholder='YYYY'></th>
						</tr>
						</div>
						<div class="col-md-12">
							<tr>
								<th><label for="cvv" class='form-label'> Enter CVV : </label></th>
								<th> <input	type='tel' class='form-control' name='cvv' id='cvv' placeholder='123'></th>
							</tr>
						</div>
                       <div class="d-grid gap-2">
						<tr>						
						      <th><button type="submit" class="btn btn-primary w-75 mt-5 ms-5">Pay : <%=price %></button> 
						</tr>
						</div>
	    	        </table>
				</div>
			</form>
		</div>
	</div>

	
	

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>