<html>
<head>
<meta charset="utf-8" />
<title>Register</title>
<link type="text/css" rel="stylesheet" href="css/register.css" />
<!--  <script src="/js/jquery-1.11.2.min.js" type="text/javascript"></script>
<script src="/js/register.js" type="text/javascript"></script>-->
</head>
<body>
	<div class="header"></div>
	<div class="main">
		<div class="user-info">
			<form action="account/register?" method="post">
				<ul>
					<li><span>Account</span> <input name="account" tabindex="1"
						class="account-login" type="email" /></li>
					<li><span>Password</span> <input name="password" tabindex="2"
						class="password main-password" type="password" /></li>
					<li><span>Confirm</span> <input type="password" tabindex="3"
						class="password password-agin" name="confirmpassword" /></li>
					<li class="submit-btn"><span></span> <input
						class="submit-step" type="submit" value="submit" tabindex="4"></li>
				</ul>
			</form>
		</div>
	</div>
	<div class="footer"></div>

</body>

</html>