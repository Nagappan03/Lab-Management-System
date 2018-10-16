<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="HomePage.css">
</head>
<body bgcolor="silver">

 <%@ include file="headerPage.html" %> 
<table width="100%" height="0%" border="0">
  <tr>
    <td  bgcolor="#2e86c1">
   <h1><center>Lab Management System</center></h1>
</td>
</tr>
</table>
<ul>
  <li class="dropdown">
    <a href="" class="dropbtn">Lab request</a>
    <div class="dropdown-content">
      <a href="addLabRequest.jsp">Add Lab Request</a>
      <a href="approvedLabRequest.jsp">Approved Lab Request</a>
     
    </div>
  </li>
  <li class="dropdown">
    <a href="" class="dropbtn">Release Lab</a>
    <div class="dropdown-content">
      <a href="addReleaseRequest.jsp">Add Release Request</a>
      <a href="approvedReleaseRequest.jsp">Approved Release Request</a>
     
    </div>
  </li>
   <li class="dropdown">
    <a href="" class="dropbtn"> Lab Extension</a>
    <div class="dropdown-content">
      <a href="addLabExtension.jsp">Add lab Extension Request</a>
      <a href="approvedLabExtension.jsp">Approved lab Extension Request</a>
     
    </div>
  </li>
   <li><a href="./ViewLabDetailsServletLO">View Labs Details</a></li>
   <li><a href="loHomePage.jsp">Logout</a></li>
</ul>


<%@ include file="footerPage.html" %>

</body>
</html>