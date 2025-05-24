<%-- 
  8d. Develop a JDBC project using JDBC to update the fields empno, empname and basicsalary 
  into the table Emp of the database Employee using HTML and JSP to get the fields and display the results respectively.
--%>


<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Update Employee Details</title>
</head>
<body>
<h2>Update Employee Details</h2>

<form method="post">
    Emp No (to update): <input type="text" name="empno" required/><br/>
    New Name: <input type="text" name="empname" required/><br/>
    New Basic Salary: <input type="text" name="salary" required/><br/>
    <input type="submit" value="Update"/>
</form>

<%
Connection con = null;
try {
    String dbPath = application.getRealPath("/") + "WEB-INF/employee.db";
    Class.forName("org.sqlite.JDBC");
    con = DriverManager.getConnection("jdbc:sqlite:" + dbPath);

    // Create table if not exists (optional safety)
    Statement createStmt = con.createStatement();
    createStmt.executeUpdate("CREATE TABLE IF NOT EXISTS Emp (Emp_NO INTEGER PRIMARY KEY, Emp_Name TEXT, Basicsalary INTEGER)");
    createStmt.close();

    // Process update if form submitted
    if (request.getParameter("empno") != null) {
        int empno = Integer.parseInt(request.getParameter("empno"));
        String empname = request.getParameter("empname");
        int salary = Integer.parseInt(request.getParameter("salary"));

        PreparedStatement ps = con.prepareStatement(
            "UPDATE Emp SET Emp_Name = ?, Basicsalary = ? WHERE Emp_NO = ?"
        );
        ps.setString(1, empname);
        ps.setInt(2, salary);
        ps.setInt(3, empno);

        int rows = ps.executeUpdate();
        if (rows > 0) {
            out.println("<p style='color:green;'>Employee updated successfully.</p>");
        } else {
            out.println("<p style='color:red;'>Employee not found with Emp No: " + empno + "</p>");
        }
        ps.close();
    }

    // Show updated list of all employees
    out.println("<hr/><h3>Employee List</h3>");
    out.println("<table border='1' cellpadding='5'>");
    out.println("<tr><th>Emp No</th><th>Name</th><th>Basic Salary</th></tr>");

    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM Emp");

    while(rs.next()) {
        out.println("<tr>");
        out.println("<td>" + rs.getInt("Emp_NO") + "</td>");
        out.println("<td>" + rs.getString("Emp_Name") + "</td>");
        out.println("<td>" + rs.getInt("Basicsalary") + "</td>");
        out.println("</tr>");
    }

    out.println("</table>");
    rs.close();
    stmt.close();
} catch (Exception e) {
    out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
} finally {
    if (con != null) con.close();
}
%>

</body>
</html>
