 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="HomePage.css">



 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>








<style>
  
     body{ 
      margin: auto;
      background-image:url("lab1.jpg");
      background-size:100% 300%;
      background-repeat:no-repeat;
      
  }
  </style>



</head>
<body bgcolor="#0b5345">
<table width="100%" border="0">
  <tr>
    <td colspan="2" bgcolor="#1abc9c">
   <h1><center><font color='#4a235a'>Lab Management System</font></center></h1>
</td>
</tr>
</table>
  <div class="container">
 

   <!-- <a href="#home" class="btn btn-primary btn-lg">
          <span class="glyphicon glyphicon-home"></span>Home
`        </a> -->
 <a href="loLogin.jsp" class="btn btn-primary btn-lg"> <span class="glyphicon glyphicon-user"></span>Learning Officer</a>
 <a href="otmLogin.jsp"class="btn btn-primary btn-lg"> <span class="glyphicon glyphicon"></span>Operation Team Member</a>
 <a href="othLogin.jsp"class="btn btn-primary btn-lg"> <span class="glyphicon glyphicon"></span>Operation Team Head</a>
  
</div>

<br>
<table width="100%" border="0">
  <tr>
<td>








<!-- <img src="home1.jpg" width=100% height=500> -->


<!-- <marquee > -->
<!-- <img src="techm2.jpg" alt="techm2" width="650" height="450"> -->

<!-- <img src="techm3.jpg" alt="techm3" width="650" height="450"> -->
<!-- <img src="techm1.jpg" alt="techm1" width="650" height="450"> -->

<!-- </marquee> -->




</td>
</tr>
</table>
<br>
<br>
</div>
</body>
<br>
<br>
<br>
<br>

<%@ include file="footerPage.html" %>

</html>