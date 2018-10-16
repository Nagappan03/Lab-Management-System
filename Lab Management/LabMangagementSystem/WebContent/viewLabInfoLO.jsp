<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Lab Details</title>
<script type="text/javascript">
function back()
{
	window.location='loHomePage.jsp';
}
</script>
<link rel="stylesheet" type="text/css" href="HomePage.css">
</head>
<body bgcolor=" #bfc9ca ">
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
<h3 align="center">Lab Details</h3>
<table align="center"><tr><td><input type="submit" value="Back" onclick="back()"/></td></tr></table>
<br>
		<table border="1" align="center">
		<thead>
		<tr>
		<th>LAB_ID</th>
		<th>LAB_NAME</th>
		<th>CAPACITY</th>
		<th>TYPE</th>
		<th>LOCATION</th>
		<th>NO_OF_SYSTEMS</th>
		<th>PROJECTOR</th>
		<th>VC_FACILITY</th>
		<th>NO_OF_WHITE_BOARDS</th>
		<th>STATUS</th>
		
		</tr>
		</thead>
		<tbody>
		<core:forEach items="${list}" var="labDetails">
		<tr>
		<td><core:out value="${labDetails.labId}"></core:out></td>
		<td><core:out value="${labDetails.labName}"></core:out></td>
		<td><core:out value="${labDetails.capacity}"></core:out></td>
		<td><core:out value="${labDetails.type}"></core:out></td>
		<td><core:out value="${labDetails.location}"></core:out></td>
		<td><core:out value="${labDetails.noOfSystems}"></core:out></td>
		<td><core:out value="${labDetails.projector}"></core:out></td>
		<td><core:out value="${labDetails.vcFacility}"></core:out></td>
		<td><core:out value="${labDetails.noOfWhiteBoards}"></core:out></td>
		<td><core:out value="${labDetails.status}"></core:out></td>
		
		</tr>
		
		</core:forEach>
		</tbody>
		</table>
		<%@ include file="footerPage.html" %> 
</body>
</html>