<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
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
	$( "#datepicker1" ).datepicker();
	} );

function validate()
{

var reqList=document.forms.reqList.value;
var todate=document.forms.todate.value;

if(reqList=="" ||todate=="")
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
 <h3 align="center">Add Lab Request</h3>
<form action="./AddLabExtensionServlet" method="post" name="forms" onSubmit="return validate()">
<table align="center">

<tr>
		<td>Request ID:</td>
		<td><select name="reqList">
<core:forEach items="${reqList}" var="req">
<option value="<core:out value="${req}" />">
<core:out value="${req}" />
</option>
</core:forEach>
</select></td>
	</tr>

<tr>
<td>
To Date:</td>
<td><input type="text"  name="todate" id="datepicker"/> </td></tr>
<tr>
<td>
LO Name:</td><td><input type="text" name="loname"  value="<%= session.getAttribute("userName") %>" readonly="readonly"/></td></tr>
<tr>
<td>
</td><td><input type="submit" value="Submit"/></td></tr>
</table>
<table align="center"><tr><td><input type="submit" value="Back" onclick="back()"/></td></tr></table>
</form>
 <%@ include file="footerPage.html" %> 
</body>
</html>