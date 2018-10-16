<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LO Home Page</title>

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
<body bgcolor="#f0f3f4">

 <%@ include file="headerPage.html" %> 
<table width="100%" height="0%" border="0" >
  <tr>
    <td  bgcolor=" #6c3483 ">
   <h1><center>Learning Officer</center></h1>
</td>
</tr>
</table>
<ul>
  <li class="dropdown">
    <a href="" class="dropbtn">Lab request</a>
    <div class="dropdown-content">
    <font="style:Bold">
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





<%@ include file="footerPage.html" %>

</body>
</html>