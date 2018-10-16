<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OTM Home Page</title>

<link rel="stylesheet" type="text/css" href="HomePage.css">

<script type="text/javascript">

history.pushState(null,null,'loLogin');
		window.addEventListener('popstate',function(event){
			history.pushState(null,null,'loLogin');
		});
		window.history.forward();
		function noBack(){
			window.history.forward();
		}
		
		
</script>


</head>
<body bgcolor=" #f0b27a
">

 <%@ include file="headerPage.html" %> 
<table width="100%" height="0%" border="0">
  <tr>
    <td  bgcolor="#138d75">
   <h1><center>Operation Team Member</center></h1>
</td>
</tr>
</table>
     <ul>
 <li><a href="viewLabRequest.jsp">View Lab Request</a></li>
  <li><a href="viewLabRelease.jsp">View lab release Request</a></li>
   <li><a href="viewExtension.jsp">View Lab extension Request</a></li>
     <li><a href="./ViewLabDetailsServletOTM">View Labs Details</a></li>
     <li><a href="labSearch1.jsp">Search Lab_Details</a></li>
   <%--   <li><a href="search.jsp">Search Lab</a></li> --%>
   <li class=t1><a href="otmLogin.jsp">Logout</a></li>
</ul>


<%@ include file="footerPage.html" %>

</body>
</html>