<%@ page import="java.sql.*" %>
<%@ page import="com.lab_mngt.utils.ConnectionUtils" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search lab details </title>
<style>
select {
	height: 30px;
	width: 300px;
}
</style>
<script type="text/javascript">
    function myfunction()
    {
    	window.location='otmHomePage.jsp';
    }
    </script>
</head>
<body bgcolor="silver">
<%@ include file="headerPage.html" %> 

<form action="">
<table border="2" align="center" width="50%">

<tr><th align="center" bgcolor=" #cb4335
" style="color: white;"colspan="6"><h1>Search lab_details</th></tr>
<tr>
 <th align="right">Location Name :</th>
 <td>
          <select name="Location" id="Location" onchange="this.form.submit();">
            <option value="0">Select Location </option>
<% {
 
        Connection con=ConnectionUtils.getConnection();
        PreparedStatement ps =con.prepareStatement("SELECT DISTINCT Location FROM LAB_DETAILS");
        ResultSet resultset=ps.executeQuery();
        %>
        <h4>Location:</h4><% while(resultset.next()){ %>
           <option value="<%=resultset.getString(1)%>"><%= resultset.getString(1)%></option>
           
        <%
        }
        }
        %>
        
</select>
</td>
</tr>
<tr>
  <th align="right">LAB Details :</th>
  
   <td>
   <select>
   <option value="0">View Available Lab Details </option>
     <%
     
     String sa=request.getParameter("Location");
     request.setAttribute("Location", sa);
     
     out.println("<h1>"+sa+"<h1>");
     System.out.println("satish");
     Connection con=ConnectionUtils.getConnection();
     PreparedStatement ps =con.prepareStatement("Select * from Lab_Details where location=? and status =? ");
     ps.setString(1, sa);
     ps.setString(2, "available");
    ResultSet  resultset=ps.executeQuery();%>
  <h4>LABNAME:</h4><%  while(resultset.next()){ %>
    <option ><%="lab_id is   "+resultset.getInt(1)+"     "+"lab_name is   "+ resultset.getString(2)+"   "+"lab_Capacity is"+resultset.getInt(3) %></option>
    <%
    }
     
   
   %>
   
   
  
   </select>
   
   </td>
</tr>
<tr>

 </table>













</form>

<br>
<center><input type="button" value="Back" onclick="myfunction()"/><br><br>
<class="t1"><a href="Home.jsp">Logout</a></center>
<br>

</body>
</html>