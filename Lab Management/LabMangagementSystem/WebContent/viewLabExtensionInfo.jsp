<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="HomePage.css">
<title>View Extension Request</title>
<script type="text/javascript">
function back()
{
	window.location='loHomePage.jsp';
}
</script>
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
<h3 align="center">View Extension Request</h3>
<table align="center"><tr><td><input type="submit" value="Back" onclick="back()"/></td></tr></table>
	<table border="1" align="center">
		<thead>
		<tr>
		<th>REQ_ID</th>
		<th>LAB_ID</th>
		<th>LAB_NAME</th>
		<th>EXTENSION_DATE</th>
		<th>LO_NAME</th>
		<th>APPROVE_STATUS</th>
		
		
		</tr>
		</thead>
		<tbody>
		<core:forEach items="${list}" var="labDetails">
		<tr>
		<td><core:out value="${labDetails.req_id}"></core:out></td>
		<td><core:out value="${labDetails.labId}"></core:out></td>
		<td><core:out value="${labDetails.labName}"></core:out></td>
		<td><core:out value="${labDetails.toDate}"></core:out></td>
		<td><core:out value="${labDetails.loName}"></core:out></td>
		<td><core:out value="${labDetails.approveStatus}"></core:out></td>
		
		</tr>
		
		</core:forEach>
		</tbody>
		</table>
</body>
</html>