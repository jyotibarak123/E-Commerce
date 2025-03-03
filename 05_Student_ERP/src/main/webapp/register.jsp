<jsp:include page="components/headcdn.jsp"></jsp:include>
<jsp:include page="components/navbar.jsp"></jsp:include>
<style>
.radio {
	display: inline;
	min-height: 0.9rem !important;
}
</style>
<body style="background-color: rgb(220, 220, 220);">

	<div class="container my-4"
		style="box-sizing: border-box; border: 2px solid gray; border-radius: 20px; width: 800px; height: 500px; justify-content: center; background-color: rgba(1, 1, 1, 0.3); padding-left: 50px; padding-right: 50px;">

		<div class="container my-4">
			<h1 style="text-align: center;">Registration Form</h1>
			  <form action="RegisterController" method="post">
				<div class="row">
					<table>
					  <tr>
						 <div class="col-md-4">
							<th>
								<label for="fname" class='form-label'> Full name :</label> 
								<input type='text' class='form-control' name='fname' id='fname' placeholder='Enter your name'>
							</th>
						 </div>
						 <div class="col-md-4">
							<th>
							  <label for="email" class='form-label'> Email :</label> 
							  <input type='email' class='form-control' name='email' id='email' placeholder='Enter your email' required>
							 </th>
					   	 </div>
					  </tr>
					  <tr>
						<div class="col-md-6">
								<th>
								   <label for="pass" class='form-label'> Password :</label> 
								   <input type='password' class='form-control' name='pass' id='pass' placeholder='Enter your password'>
								</th>
						</div>
						<div class="col-md-6">
							<th>
							  <label for="mobileNo" class='form-label'>MobileNo :</label>
							  <input type='tel' class='form-control' name='mobileNo' id='mobileNo' placeholder='Enter your mobileNo'>
							</th>
						</div>
					  </tr>
					  <tr>
						 <div class="col-md-4 flex">
								<th>
								    <label for="gender" class='form-check-label'> Gender :</label> 
									<input type='radio' class='form-check radio' name='gender' value="Male" id='gender'> Male
									<input	type='radio' class='form-check radio' name='gender'	value="Female" id='gender'> Female 
									<input type='radio'	class='form-check radio' name='gender' value="Others" id='gender'> Others
								</th>
						  </div>
						  <div class="col-md-4">
							<th>
							  <label for="isMember" class='form-check-label'>	isMember ?</label>
							  <input type='checkbox' class='form-check radio' name='isMember' value="yes" id='isMember'>
							</th>
						  </div>
					   </tr>
		     		   <tr>
						  <div class="col-md-6">
								<th>
								  <label for="fee" class='form-label'> Fee : </label> 
								  <input type='number' class='form-control' name='fee' id='fee' placeholder='Enter your fee'>
								</th>
						  </div>
						  <div class="col-md-6">
							 <th>
							   <label for="joinedAt" class='form-label'>joinedAt : </label>
							   <input type='date' class='form-control' name='joinedAt' id='joinedAt'>
							 </th>
						  </div>
					   </tr>	
                       <tr>
						  <div class="col-md-12 mt-5">
								<th>
								<input class='btn btn-secondary' type='reset' value='reset'>
								 <input class='btn btn-primary'	type='submit' value='submit'>
								</th>
						  </div>
					  </tr>
					</table>
				</div>
			</form>
		</div>
	</div>
		<jsp:include page="components/footscript.jsp"></jsp:include>