<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<% Class.forName("oracle.jdbc.driver.OracleDriver");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
    <HEAD>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <TITLE>View Lab Request</TITLE>
 <link rel="stylesheet" type="text/css" href="HomePage.css">
    <script type="text/javascript">
    function myfunction()
    {
    	window.location='otmHomePage.jsp';
    }
    </script>
    </HEAD>
    <BODY bgcolor="silver">
     <%@ include file="headerPage.html" %> 
        <H3><center>View Lab Request</center></H3>
       <ul>
 
    <li>
      <a href="approveLabRequest.jsp">Approve lab Request</a></li>
     <li> <a href="declineLabRequest.jsp">Decline lab Request</a></li> 
     <li class="t1"><a href="Home.jsp">Logout</a></li> 
</ul>
<!--  <center><a href="otmHomePage.jsp">Back</a></center>-->
<br>
<center><input type="button" value="Back" onclick="myfunction()"/></center>
<br>
        <%
        //Class.forName("oracle.jdbc.driver.OracleDriver");
       Connection con=DriverManager.getConnection("jdbc:oracle:thin:@172.16.153.233:1521:xe", "user1", "techm123");

                    ResultSet rs;
                    Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    rs =
                            statement.executeQuery("SELECT * FROM lab_request_details where approve_status not in('Approved','Not Approved')");
                    while(rs.next())
                    {
        %>
        <TABLE cellpadding="15" border="1" align="center">
            <TR>
                <TH>REQ_ID </TH>
                <TH>  LAB_ID </TH>
                <TH> LAB_NAME </TH>
                <TH> FROM_DATE </TH>
                <TH> TO_DATE </TH>
                <TH> LO_NAME </TH>
                
 
            </TR>
          <%
				do {
			%>
 
 
            <TR>
                <TD> <%=  rs.getInt(1)%> </TD>
                <TD> <%= rs.getInt(2)%> </TD>
                <TD> <%= rs.getString(3)%> </TD>
                <TD> <%= rs.getString(4)%> </TD>
                <TD> <%= rs.getString(5)%> </TD>
                <TD> <%= rs.getString(6)%> </TD>
                
            </TR>
          <%rs.next();
} while (rs.isAfterLast() != true);
%>
        </TABLE>
        <BR>
        <%
                    }
        %>
        <%@ include file="footerPage.html" %> 
        
    </BODY>
</HTML>