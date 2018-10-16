
    <%@ page import="com.lab_mngt.utils.ConnectionUtils" %>
    <%@ page import="java.sql.*" %>
    <jsp:include page = "labSearch.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="basedonLocation.jsp">
     <h4>LabName:</h4><select name="LabName">
<% 

        String Location1 =(String)request.getParameter("Location");
         out.println(Location1);
           Connection con=ConnectionUtils.getConnection();
            PreparedStatement ps =con.prepareStatement("Select Lab_NAme from Lab_Details where location=?");
            ps.setString(1, Location1);
          ResultSet  resultset=ps.executeQuery();%>
          <h4>LABNAME:</h4><%  while(resultset.next()){ %>
           <option ><%= resultset.getString(1)%></option>
           <%
        }
         
        
       
        
        %>
        
        

        <input type="submit" value="OK">
        </form>
        </select>  
        

</body>
</html>