<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OTM Home Page</title>

<link rel="stylesheet" type="text/css" href="HomePage.css">
</head>
<body bgcolor="silver">

 <%@ include file="headerPage.html" %> 
     <ul>
 <li><a href="viewLabRequest.jsp">View Lab Request</a></li>
  <li><a href="viewLabRelease.jsp">View lab release Request</a></li>
   <li><a href="viewExtension.jsp">View Lab extension Request</a></li>
     <li><a href="./ViewLabDetailsServlet">View Labs Details</a></li>
     <li><a href="search.jsp">Search Lab</a></li>
   <li class=t1><a href="otmLogin.jsp">Logout</a></li>
</ul>


<%@ include file="footerPage.html" %>

</body>
</html>