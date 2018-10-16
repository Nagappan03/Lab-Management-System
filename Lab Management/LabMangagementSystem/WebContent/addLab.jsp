<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Lab</title>
<script type="text/javascript">
function back()
{
	window.location='othHomePage.jsp';
}
function validate()
{
var a=/^[A-Z0-9a-z]+$/;
var LabName=document.forms.LabName.value;
var capacity=document.forms.capacity.value;
var type=document.forms.type.value;
var LabLocation=document.forms.LabLocation.value;
var no_of_systems=document.forms.no_of_systems.value;
var projector=document.forms.projector.value;
var VC_Facility=document.forms.VC_Facility.value;
var no_white_boards=document.forms.no_white_boards.value;
var Status=document.forms.Status.value;
if(LabName=="" ||capacity==""||type==""||LabLocation==""||no_of_systems==""||projector==""||VC_Facility==""||no_white_boards==""||Status=="")
	{
	//window.location('approveLabReleaseRequest.jsp');
	 alert("All the fields must be filled");
	 return false;
	}

</script>

<script>
function AvoidSpace(event) {
    var k = event ? event.which : window.event.keyCode;
    if (k == 32) return false;
}
</script>


<link rel="stylesheet" type="text/css" href="HomePage.css">
</head>
<body bgcolor=" #F08080 ">

 <%@ include file="headerPage.html" %>
 <ul>
 
  <li><a href="./ViewLabDetailsServletOTH">View Lab Details</a></li>
  <li><a href="addLab.jsp">Add Lab</a></li>
  <li><a href="deletelab.jsp">Delete Lab</a></li>
  <li class="t1"><a href="othLogin.jsp">Logout</a></li>
  
</ul>
  
 <h3 align="center">Add Lab</h3>
<form action="./AddLabServlet" method="post" name="forms" onSubmit="return validate()">
<table align="center">
<tr>
<td>Lab Name:</td><td><input type="text" name="LabName" placeholder="Lab Name" required="" pattern="[a-z]+" maxlength="8"  title="Enter only Alphabats donot enter numberic data" onkeypress="return AvoidSpace(event)"/></td></tr>
<tr>
<td>
Capacity:</td>
<td><input type="text" name="capacity" placeholder="capacity" required="" pattern="^[1-9][0-9]*$" maxlength="5" title="Enter value greater than 0" onkeypress="return AvoidSpace(event)"/></td></tr>
<tr>
<td>
Type:</td><td><select name="type">
<option ></option>
<option  value="Auditorium">Auditorium</option>
	<option value="Normal">Normal</option>
</select></td></tr>
<tr>
<td>
Location:</td>
<td><select name="LabLocation">
<option ></option>
    <option value="egypt">egypt</option>
	<option value="hyderabad">hyderabad</option>
	<option value="pune">pune</option>
	<option value="Bangalore">Bangalore</option>
</select></td>
<tr>
<td>
Number Of Systems:</td>
<td><input type="text" name="no_of_systems" placeholder="No of systems" required="" maxlength="5" pattern="^[1-9][0-9]*$" title="Enter value greater than 0" onkeypress="return AvoidSpace(event)"/></td></tr>
<tr>
<td>
Projector:</td><td><select name="projector">
<option ></option>
   <option value="yes">yes</option>
	<option value="no">no</option>	
</select></td></tr>
<tr>
<td>
VC Facility:</td><td><select name="VC_Facility" >
<option ></option>
    <option value="yes">yes</option>
	<option value="no">no</option>	
</select></td></tr>
<tr>
<td>
Number of White Boards :</td><td><select name="no_white_boards" >
<option ></option>
    <option value="1">1</option>
	<option value="2">2</option>	
	<option value="3">3</option>	
	<option value="4">4</option>	
</select></td></tr>
<tr>
<td>
Status:</td><td><select name="Status">
<option ></option>
    <option value="available">available</option>
	<option value="not available">not available</option>	
</select></td></tr>
<tr>
<td></td>
<td>
<input type="submit" value="Submit"/></td></tr>
</table>
<table align="center"><tr><td><input type="submit" value="Back" onclick="back()"/></td></tr></table>
</form>
  
</body>
</html>