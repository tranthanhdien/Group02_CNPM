
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
	<!-- 2. Hệ thống trả về trang login cho người dùng -->
<body>
	<!---header--->
	<div class="header">
		<h1>Login Box</h1>
	</div>
	<!---header--->
	<!---main--->
	<div class="main">
		<form action="LoginController" method="post">
			<div class="main-section">
				<div class="login-section">
					<h2>Login</h2>
					<div class="login-top">
						<p>Login with social</p>
						<ul>
							<li><a class="face"
								href="https://www.facebook.com/dialog/oauth?client_id=401733703942139&redirect_uri=https://ltweb.azurewebsites.net/login-facebook"><span
									class="twit"> </span>Login with Facebook</a></li>
							<li><a class="twit"
								href="https://accounts.google.com/signin/oauth/oauthchooseaccount?client_id=745032533472-rmlgld6ab5t3u2vrv03vuo6d3m3f6s2e.apps.googleusercontent.com&as=8rFs9AeZ8WM6BXOuNqFSYw&destination=http%3A%2F%2Flocalhost%3A8080&approval_state=!ChR1QXVmLVhnYm1sczR1REFadXNDUhIfczlleFZPUnpGcndaOEhuU1JuY2dubXEtRkhaSXNCWQ%E2%88%99AJDr988AAAAAXPALtbbfiG81E4PPVvStSwXWBGlwFvRc&oauthgdpr=1&oauthriskyscope=1&xsrfsig=ChkAeAh8T7bPV_ZepHhyowMmL7Df-hKi0T98Eg5hcHByb3ZhbF9zdGF0ZRILZGVzdGluYXRpb24SBXNvYWN1Eg9vYXV0aHJpc2t5c2NvcGU&flowName=GeneralOAuthFlow"><span
									class="twit"> </span>Login with Google</a></li>
						</ul>
					</div>
					<div class="login-middle">
					<!-- 3. Người dùng nhập userName, password -->
						<p>Log in with your name and password</p>
						<!-- 9. Trả về thông tin thất bại -->
						<p style="color: red; text-align: center;">
						<%=request.getAttribute("message") %>
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
						<!-- 4. Gửi thông tin đăng nhập(Username, password) lên Server -->
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
				href="#">Tran Thanh Dien</a>
		</p>
	</div>

	<!---main--->
</body>
</html>
