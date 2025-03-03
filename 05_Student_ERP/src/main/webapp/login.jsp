<jsp:include page="components/headcdn.jsp"></jsp:include>
<jsp:include page="components/navbar.jsp"></jsp:include>

<link rel="stylesheet" href="css/style.css">
<body style="background-image: url('https://png.pngtree.com/thumb_back/fh260/background/20201101/pngtree-scene-with-geometrical-forms-the-poster-model-minimal-background-render-image_452981.jpg'); background-size: cover; background-repeat: no-repeat; background-position: center;">
	<div class="login-container">
		<h1>Login to your Account</h1>
		<h2 class='text-danger'>
		<%
		 String msg = (String)request.getAttribute("msg"); 
		 if(msg!=null)
		  {
		   out.print(msg);
			} 
		 %>
		</h2>
		<form action="LoginHandler" method="post">
			<input type="text" name="username" id="username"
				placeholder="Username" required> <input type="password"
				name="password" placeholder="Password" id="password" required>
			<button type="submit">Login</button>
		</form>
		<p>
			Don't have an account? <a href="#">Sign Up</a>
		</p>
		<p>
			<a href="#">Forgot password?</a>
		</p>
	</div>


	<jsp:include page="components/footscript.jsp"></jsp:include>