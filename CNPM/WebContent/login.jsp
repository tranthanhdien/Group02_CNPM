
<!DOCTYPE HTML>
<html>
<head>
<title>Login-Group02</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Flash Registration Form  Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<!--web-fonts-->
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
</head>
<link
	href='//fonts.googleapis.com/css?family=Josefin+Sans:400,100,100italic,300,300italic,400italic,600,600italic,700,700italic'
	rel='stylesheet' type='text/css'>
<body>
	<!---header--->
	<div class="header">
		<h1>Login Box</h1>
	</div>
	<!---header--->
	<!---main--->
	<div class="main">
		<!-- 4. Gửi thông tin đăng nhập -->
		<form action="LoginController?action=account" method="post">
			<div class="main-section">
				<div class="login-section">
					<h2>Login</h2>
					<div class="login-top">
						<p>Login with social</p>
						<ul>
							<!-- Dang nhap FB -->


							<li><a class="face"
								href="http://graph.facebook.com/oauth/authorize?client_id=401733703942139&scope=public_profile,email,user_likes&redirect_uri=http://localhost:8080/NMCNPM_NĐCSong_2019/LoginFB.html"><span
									class="twit"> </span>Login with Facebook</a></li>



							<!-- Dang Nhap GG -->
							<li><a class="twit"
								href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/CNPM/LoginGoogle&response_type=code
    &client_id=1060948132726-eh3lib9ad78brmcfn11avd49b28r6nv6.apps.googleusercontent.com&approval_prompt=force"><span
									class="twit"> </span>Login with Google</a></li>
						</ul>
					</div>
					<div class="login-middle">
						<p>Log in with your name and password</p>
						<p style="color: red; text-align: center;"><%=request.getAttribute("message")%>
						</p>

						<input type="text" id="userName" name="userName"
							placeholder="Name"> <input type="password" id="pass"
							name="pass" placeholder="Password">
					</div>
					<div class="login-bottom">
						<div class="login-left">
							<p>Forgot your password?</p>
							<a href="#">Sign Up Now!</a>
						</div>
						<div class="login-right">
							<input type="submit" value="Login">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="footer">
		<p>
			&copy 2019 Flat Login Box. All rights reserved | Design by <a
				href="#">Anh chang dep trai</a>
		</p>
	</div>

	<!---main--->
</body>
</html>
