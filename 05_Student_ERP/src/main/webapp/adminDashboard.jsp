<%@page import="java.util.List"%>
<%@ page import="com.ducat.modal.Student"%>
<%@ page import="com.ducat.dao.StudentDao"%>
<%@ page import="com.ducat.dao.impl.StudentDaoImpl"%>


<jsp:include page="components/headcdn.jsp"></jsp:include>
<jsp:include page="components/navbar.jsp"></jsp:include>
<link rel="stylesheet" href="css/style.css">
<body style="background-color: rgb(220, 220, 220);">

<%

          StudentDao dao = new StudentDaoImpl();
          List<Student> allStudents = dao.getAllStudents();

%>

	<h1 class="text-center" style="margin-top: 2rem;">All Students List</h1>
	<div class="mx-auto" style='width: 90%; overflow-x: auto;'>
		<table class="table table-striped" border='1'>
			<thead class="table-dark">
				<tr>
	<%      		
          String[] columns = dao.getColumnsName();
          for(String col : columns)
          {  %>
					<td><%=col%></td>
					<% } %>
					<td>Actions</td>
				</tr>
			</thead>
			<tbody>
		   <%   for(Student student: allStudents)
          { %>
				<tr>
					<td><%=student.getId()%></td>
					<td><%=student.getName()%></td>
					<td><%=student.getMobileNo()%></td>
					<td><%=student.getGender()%></td>
					<td><%=student.isMember()%></td>
					<td><%=student.getFee()%></td>
					<td><%=student.getJoinedAt()%></td>
					<td><%=student.getEmail()%></td>
					<td><%=student.getPassword()%></td>
					<td>
						<button class='btn btn-primary' data-bs-toggle='modal' data-bs-target='#editModal' onclick='fillModal(this)'>Edit</button>
						<a href='DeleteController?id=<%=student.getId()%>'><button class='btn btn-danger'>Delete</button></a>
					</td>
				</tr>
				<% } %>

			</tbody>
			<tfoot class="table-dark">
				<tr>
					<%  
					for(String col :  columns)  { %>
					<td><%=col%></td>
					<% } %>
					<td>Actions</td>
				</tr>
			</tfoot>

		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

	<div class="modal fade" id="editModal" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="staticBackdropLabel">Edit
						your Form</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">

					<div class="container my-4">
						<h1 style="text-align: center;">Registration Form</h1>
						<form action="EditController" method="get">
							<div class="row">
								<table>
									<div class="col-md-4">
										<tr>
											<th>
											<label for="id" class='form-label'> ID :</label> 
											<input type='text' class='form-control' name='id' id='id' placeholder='Enter your id' disabled>
											 <input type='hidden' value='' id='id2' name='id'>
											 </th>
									</div>
									<div class="col-md-4">
										<tr>
											<th><label for="fname" class='form-label'> Full
													name :</label> <input type='text' class='form-control' name='fname'
												id='fname' placeholder='Enter your name'></th>
									</div>
									<div class="col-md-4">
										<th><label for="email" class='form-label'> Email
												:</label> <input type='email' class='form-control' name='email'
											id='email' placeholder='Enter your email'></th>
										</tr>
									</div>
									<div class="col-md-6">
										<tr>
											<th><label for="pass" class='form-label'>
													Password :</label> <input type='text' class='form-control'
												name='pass' id='pass' placeholder='Enter your password'>
											</th>
									</div>
									<div class="col-md-6">
										<th><label for="mobileNo" class='form-label'>
												MobileNo :</label> <input type='tel' class='form-control'
											name='mobileNo' id='mobileNo'
											placeholder='Enter your mobileNo'></th>
										</tr>
									</div>
									<div class="col-md-4 flex">
										<tr>
											<th><label for="gender" class='form-check-label'>
													Gender :</label> <input type='radio' class='form-check radio'
												name='gender' value="Male"> Male <input type='radio'
												class='form-check radio' name='gender' value="Female">
												Female <input type='radio' class='form-check radio'
												name='gender' value="Others"> Others</th>
									</div>
									<div class="col-md-4">
										<th><label for="isMember" class='form-check-label'>
												isMember ?</label> <input type='checkbox' class='form-check radio'
											name='isMember' value="yes" id='isMember'></th>
										</tr>
									</div>
									<div class="col-md-6">
										<tr>
											<th><label for="fee" class='form-label'> Fee : </label>
												<input type='number' class='form-control' name='fee'
												id='fee' placeholder='Enter your fee'></th>
									</div>
									<div class="col-md-6">
										<th><label for="joinedAt" class='form-label'>
												joinedAt : </label> <input type='date' class='form-control'
											name='joinedAt' id='joinedAt'></th>
										</tr>
									</div>
								</table>
							</div>
					
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Cancel</button>
					<button type="submit" class="btn btn-primary">edit</button>
				</div>
				</form>
				</div>
				</div>
			</div>
		</div>
	</div>
	<script>
					    function fillModal(e)
					     {
					           const tr=e.parentNode.parentNode;
					           console.log(tr);
					           console.dir(tr);
					           const tdArr=tr.children;
					           document.querySelector("#id").value=tdArr[0].textContent;
					           document.querySelector("#id2").value=tdArr[0].textContent;
					           document.querySelector("#fname").value=tdArr[1].textContent;
					           document.querySelector("#mobileNo").value=tdArr[2].textContent;
					           let genArr=document.querySelectorAll("input[name='gender']");
					           let gen = tdArr[3].textContent;
					           console.dir(genArr);
					           console.dir(gen);
					           for(let i=0; i<genArr.length;i++)
					           {
					                if(genArr[i].value.startsWith(gen))
					                {
					                     genArr[i].checked=true;
					                }
					           }
					           if(tdArr[4].textContent=='true')
					               document.querySelector("#isMember").checked=true;
					           document.querySelector("#fee").value=tdArr[5].textContent;
					           document.querySelector("#joinedAt").value=tdArr[6].textContent;
					           document.querySelector("#email").value=tdArr[7].textContent;
					           document.querySelector("#pass").value=tdArr[8].textContent;
					     }
					    
     </script>
