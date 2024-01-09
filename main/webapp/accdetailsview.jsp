<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/accountview_style.css">
</head>
<body>
	<h1>STEJO BANK OF INDIA</h1>
	<header>
		<table id="table1">
			<tr>
				<td>
					<div class="h1">
						<a href="Home.html" id="a1">Home</a>
					</div>
				</td>
				<td>
					<div class="h1">
						<a href="deposit.jsp" id="a1">Money Transfer</a>
					</div>
				</td>
				<td>
					<div class="h1">
						<a href="newaccount.html" id="a1">Create New Account</a>
					</div>
				</td>
				<td>
					<div class="h1">
						<a href="login.html" id="a1">Login</a>
					</div>
				</td>
			</tr>
		</table>
	</header>
	<h1>ACCOUNT DETAILS</h1>

	<div id="div1">
		<table id="table2">
			<tr id="tr1">
				<td><label>Account Holder's Name :</label></td>
				<td>${FirstName}</td>
			</tr>
			<tr id="tr2">
				<td><label>First Name :</label></td>
				<td>${FirstName}</td>
			</tr>
			<tr id="tr1">
				<td><label>Last Name :</label></td>
				<td>${lastName}</td>
			</tr>
			<tr id="tr2">
				<td><label>Bank Name :</label></td>
				<td>${BankName}</td>
			</tr>
			<tr id="tr1">
				<td><label>Account Number :</label></td>
				<td>${AccountNumber}</td>
			</tr>
			<tr id="tr2">
				<td><label>Branch Name :</label></td>
				<td>${BranchName}</td>
			</tr>
			<tr id="tr1">
				<td><label>IFSC :</label></td>
				<td>${IFSC}</td>
			</tr>
			<tr id="tr2">
				<td><label>GMAIL :</label></td>
				<td>${Gmail}</td>
			</tr>
			<tr id="tr1">
				<td><label>Address :</label></td>
				<td>${Address}</td>
			</tr>
			<tr>
				<td id="hbtn1"><a href="Home.html"><input type="button"
						value="Home" class="btn"></a></td>
				<td id="hbtn2"><a href="deposit.jsp"><input type="button"
						value="Send Money" class="btn"></a></td>
			</tr>
		</table>

	</div>
	<br>
	<footer>
		<table>
			<tr>
				<td><a href="Home.html"><img
						src="104445_video_youtube_icon.png" class="img"></a></td>
				<td><a
					href="https://instagram.com/stejo_11?utm_source=qrt&igshid=MzNINGNkZWQ4Mg%3D%3D"
					target="_blank"><img src="1161953_instagram_icon.png"
						class="img"></a></td>
				<td><a href="https://www.facebook.com/stejo.wilfred"
					target="_blank"><img
						src="2515845_black and white_dark grey_facebook_icon.png"
						class="img"></a></td>
				<td><a href="https://github.com/stejowilfred" target="_blank"><img
						src="317712_code repository_github_repository_resource_icon.png"
						class="img"></a></td>
				<td><a><img
						src="5282551_tweet_twitter_twitter logo_icon.png" class="img"></a></td>
			</tr>
		</table>
	</footer>
</body>
</html>