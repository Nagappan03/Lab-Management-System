<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OTH Home Page</title>

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
<body bgcolor="#76d7c4">

 <%@ include file="headerPage.html" %> 
<table width="100%" height="0%" border="0">
  <tr>
    <td  bgcolor="#e15148">
   <h1><center>Operation Team Head</center></h1>
</td>
</tr>
</table>
  <div class="container">
 
<ul>
  
  <li><a href="./ViewLabDetailsServletOTH">View Lab Details</a></li>
  <li><a href="addLab.jsp">Add Lab</a></li>
  <li><a href="deletelab.jsp">Delete Lab</a></li>
  <li><a href="labSearch.jsp">Search Lab_Details</a></li>
 <%--  <li><a href="search.jsp">Search Lab</a></li>  --%>
  <li class="t1"><a href="othLogin.jsp">Logout</a></li>
  
</ul>

<%@ include file="footerPage.html" %>
</body>
</html>