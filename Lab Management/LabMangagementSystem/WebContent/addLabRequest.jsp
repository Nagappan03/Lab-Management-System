<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Lab Request</title>
<link rel="stylesheet" type="text/css" href="HomePage.css">
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$( function() {
$( "#datepicker" ).datepicker({minDate:0});
} );

$( function() {
	$( "#datepicker1" ).datepicker({minDate:0});
	} );
function validate()
{

var lablist=document.forms.labList.value;
var fromdate=document.forms.fromdate.value;
var todate=document.forms.todate.value;

if(todate<fromdate){
alert("Enter valid from and to dates ")
return false;
}

if(lablist=="" ||fromdate=="" || todate=="" )
	{
	
	 alert("All the fields must be filled");
	 return false;
	}

}
function back()
{
	window.location='loHomePage.jsp';
}

</script>

</head>
<body bgcolor="#2e86c1">

 <%@ include file="headerPage.html" %> 
 
 <ul>
  <li class="dropdown">
    <a href="" class="dropbtn">Lab request</a>
    <div class="dropdown-content">
      <a href="./AddLabRequestServlet">Add Lab Request</a>
      <a href="./ViewApprovedRequestServlet">Approved Lab Request</a>
     
    </div>
  </li>
  <li class="dropdown">
    <a href="" class="dropbtn">Release Lab</a>
    <div class="dropdown-content">
      <a href="./AddLabReleaseServlet">Add Release Request</a>
      <a href="./ViewApprovedReleaseServlet">Approved Release Request</a>
     
    </div>
  </li>
   <li class="dropdown">
    <a href="" class="dropbtn"> Lab Extension</a>
    <div class="dropdown-content">
      <a href="./AddLabExtensionServlet">Add lab Extension Request</a>
      <a href="./ViewApprovedExtensionServlet">Approved lab Extension Request</a>
     
    </div>
  </li>
   <li><a href="./ViewLabDetailsServletLO">View Labs Details</a></li>
  <li class="t1"><a href="loLogin.jsp">Logout</a></li>
</ul>
<br>
<h3 align="center">Add Lab Request</h3>
<br>
<form action="./AddLabRequestServlet" method="post" name="forms" onSubmit="return validate()">
<table align="center">




<!--  <tr>
<td>Lab Name:</td><td><select name="LabName">
<option value=""></option>
</select></td></tr>
<tr>
-->


	
<tr>
		<td>Lab Name:</td>
		<td><select name="labList">
<core:forEach items="${labList}" var="lab">
<option value="<core:out value="${lab}" />">
<core:out value="${lab}" />
</option>
</core:forEach>
</select></td>
	</tr>

<tr>
<td>
  From Date:</td>
<td><input type="text"  name="fromdate" id="datepicker" /> </td></tr>
<tr>
<td>
To Date:</td>
<td><input type="text"  name="todate" id="datepicker1" /> </td></tr>
<tr>
<td>
LO Name:</td><td><input type="text" name="loname" value="<%=session.getAttribute("userName") %>" readonly/></td></tr>
<tr>
<td>
</td><td><input type="submit" value="Submit"/></td></tr>
</table>
</form>
<table align="center">
<tr><td><input type="submit" value="Back" onclick="return back()"/></td></tr></table>
 <%@ include file="footerPage.html" %> 
</body>
</html>