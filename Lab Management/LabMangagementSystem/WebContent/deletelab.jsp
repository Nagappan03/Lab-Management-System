<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Lab</title>
<link rel="stylesheet" type="text/css" href="HomePage.css">
<script type="text/javascript">
function back()
{
	window.location='othHomePage.jsp';
}
function validate()
{
	var LabId=document.forms.LabId.value;
	 var a=/^[A-Z0-9a-z]+$/;
	if(LabId=="")
		{
		//window.location('approveLabReleaseRequest.jsp');
		 alert("Lab Id should be filled");
		 return false;
		}
	 
</script>

<script>
function AvoidSpace(event) {
    var k = event ? event.which : window.event.keyCode;
    if (k == 32) return false;
}
</script>

</head>
<body bgcolor=" #F08080">

 <%@ include file="headerPage.html" %> 
  <ul>
  
  <li><a href="./ViewLabDetailsServletOTH">View Lab Details</a></li>
  <li><a href="addLab.jsp">Add Lab</a></li>
  <li><a href="deletelab.jsp">Delete Lab</a></li>
  <li class="t1"><a href="othLogin.jsp">Logout</a></li>
  
</ul>
<br>
<h3 align="center">Delete Lab</h3>
<form action="./DeleteLabServlet" method="post" name="forms" onSubmit="return validate()">
<table align="center">
<tr>
<td><b>Lab Id:</b></td><td><input type="text" name="LabId" placeholder="Lab Id" pattern="[0-9]+"  maxlength="5" required="" title="Enter numeric data only" onkeypress="return AvoidSpace(event)"/></td></tr>
<tr><td></td><td><input type="submit" value="Submit"></td></tr>
</table>
<table align="center"><tr><td><input type="submit" value="Back" onclick="back()"/></td></tr></table>
</form>
 <%@ include file="footerPage.html" %> 
</body>
</html>