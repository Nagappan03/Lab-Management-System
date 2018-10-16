<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="HomePage.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LO Login</title>

<script type="text/javascript">

history.pushState(null,null,'loLogin');
		window.addEventListener('popstate',function(event){
			history.pushState(null,null,'loLogin');
		});
		window.history.forward();
		function noBack(){
			window.history.forward();
		}



function validate()
{
	var userName=document.UserLoginForm.userName.value;
	var passWord=document.UserLoginForm.passWord.value;
	
	if(userName =="" && passWord =="")
	{
		alert("User Name and Password  must be filled ");
  		return false;
	}
	else if(userName =="")
	{
		alert("User Name must be filled (A-z,0-9)");
  		return false;	
	}
	else if(passWord == "")
	{
		alert("Password must be filled");
  		return false;
	}
	
}
</script>
</head>
<style>
body{ 
      background-image:url("lab2.png");
      background-size:cover;
      background-repeat:no-repeat;
  }
	
</style>
<body bgcolor="silver" onload="noBack();"
onpageshow="if(event.persisted) noBack();"onunload="">

<table width="100%" border="0">
  <tr>
    <td colspan="2" bgcolor="#1abc9c">
   <h1><center><font color='#4a235a'>Lab Management System</font></center></h1>
</td>
</tr>
</table>
  <div class="container">
 
<ul>
  <li><a href="Home.jsp">Home</a></li>
</ul>

<br>
<table width="100%" border="0">
 
</table>
<form method="POST" action="./LOLoginServlet"  onSubmit="return validate()" name="UserLoginForm">
<h3 align="center"><font color=' #cb4335'>LO Login</font></h3>
<table align="center" cellspacing="5" cellpadding="5">

<tr> 
	<td>UserName</td>
	<td><input type="text" name="userName" id="userName" placeholder="Enter User Name" pattern="[a-zA-Z]+" required/></td>
</tr>
<tr>
	<td>Password</td>
	<td> <input type="password" name="passWord" id="passWord" placeholder="Enter Password"/><i></i> </td></tr>
	
<tr><td></td><td><center>
<input type="submit" value="Login"/></center><br>
	
</td></tr></table></form>

<br>
<%@ include file="footerPage.html" %>
</div>
</body>
</html>