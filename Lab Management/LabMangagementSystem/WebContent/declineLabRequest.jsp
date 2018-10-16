<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Decline Lab Request</title>

<link rel="stylesheet" type="text/css" href="HomePage.css">
<script type="text/javascript">
function validate()
{
	var rid=document.form1.req_id.value;
	 var a=/^[A-Z0-9a-z]+$/;
	if(rid=="")
		{
		//window.location('approveLabReleaseRequest.jsp');
		 alert("Request Id should be filled");
		 return false;
		}
	 
	
	}
	
function back()
{
	window.location='viewLabRequest.jsp';
}
</script>

<script>
function AvoidSpace(event) {
    var k = event ? event.which : window.event.keyCode;
    if (k == 32) return false;
}
</script>

</head>
<body bgcolor=" #b9770e">

 <%@ include file="headerPage.html" %> 
<h3 align="center">Decline Lab Request</h3>
<center>
 <form action="./DeclineLabRequestServlet" method="post" name="form1" onSubmit="return validate()">
 <table>
 <tr>
 <td>
 Request Id:</td><td><input type="text" name="req_id" placeholder="Request Id" required="" maxlength="5" pattern="[0-9]+" title="Enter numeric data only" onkeypress="return AvoidSpace(event)"/></td></tr>
 <tr>
 <td>
</td>
<td>
 <input type="submit" value="Decline"/></td></tr>
 </table>
 </form>
  <table><tr><td><input type="submit" value="Back" onclick="back()"/></td></tr></table>
     <a href="Home.jsp">Logout</a> 
</center>

<%@ include file="footerPage.html" %>

</body>
</html>