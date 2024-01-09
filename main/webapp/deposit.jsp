<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login_style.css">
</head>
<body>
<h1>STEJO BANK OF INDIA</h1>
	<header>
		<table id="table1">
			<tr>
			<td>
				<div class="h1"><a href="Home.html" id="a1">Home</a></div>
			</td>
			</tr>
		</table>
	</header>
	<h1>MONEY TRANSFER</h1>
	<div id="div1">
	<form id="login" action="Deposit" method="post">
		<table id="table2">
			<tr id="tr">
				<td><label>Select Bank type</label></td>
				<td><select name="bank" id="inputbox">
						<option value="self">Self bank</option>
				</select></td>
			</tr>
			<tr id="tr">
				<td><label>Account Number</label></td>
				<td><input type="number" name="account" required="required" id="inputbox"></td>
			</tr>
			<tr id="tr">
				<td><label>Amount</label></td>
				<td><input type="number" name="amount" required="required" id="inputbox"></td>
			</tr>
			<tr id="tr">
				<td><label>Password</label></td>
				<td><input type="password" name="password" required="required" id="inputbox"><input type="checkbox" id="pss" onclick="show()"></td>
			</tr>
			<tr id="tr">
				<td colspan="2"><input type="submit" value="Transfer" class="btn">
				<a href="accdetailsview.jsp"><input type="button" value="Back" class="btn"></a></td>
			</tr>
		</table>
	</form>
	</div>
	<br>
	<footer>
		<table>
			<tr>
				<td><a href="Home.html"><img src="104445_video_youtube_icon.png" class="img"></a></td>
				<td><a href="https://instagram.com/stejo_11?utm_source=qrt&igshid=MzNINGNkZWQ4Mg%3D%3D"
						target="_blank"><img src="1161953_instagram_icon.png" class="img"></a></td>
				<td><a href="https://www.facebook.com/stejo.wilfred" target="_blank"><img
							src="2515845_black and white_dark grey_facebook_icon.png" class="img"></a></td>
				<td><a href="https://github.com/stejowilfred" target="_blank"><img
							src="317712_code repository_github_repository_resource_icon.png" class="img"></a></td>
				<td><a><img src="5282551_tweet_twitter_twitter logo_icon.png" class="img"></a></td>
			</tr>
		</table>
	</footer>
	<script type="text/javascript">
	function show(){
		var obj=document.getElementById("pass");
		if(obj.type==="password"){
			obj.type="text";
		}else{
			obj.type="password";
		}
	}
	</script>
</body>
</html>