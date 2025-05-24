<%-- 
  9d. Develop a JDBC project using MySQL to delete the records in the table Emp 
  of the database Employee by getting the name starting with ‘S’ through keyboard
  and generate the report as follows using HTML and JSP to get the field and display the results respectively:

  Salary Report
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Emp_No     : 101
  Emp_Name: Ramesh
  Basic
            : 25000
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Emp_No     : 102
  Emp_Name: Ravi
  Basic
            : 20000
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--%>


<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head><title>Salary Report - Delete by Starting Letter</title></head>
<body>

<h2>Delete Employees by Name Starting Letter</h2>
<form method="post">
    Enter starting letter: <input type="text" name="startLetter" maxlength="1" required />
    <input type="submit" value="Delete Employees" />
</form>

<%
    String startLetter = request.getParameter("startLetter");

    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("org.sqlite.JDBC");
        String dbPath = application.getRealPath("/WEB-INF/employee.db");
        conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath);

        // Create table if not exists (optional safety)
        Statement createStmt = conn.createStatement();
        createStmt.executeUpdate("CREATE TABLE IF NOT EXISTS Emp (" +
                                 "Emp_NO INTEGER PRIMARY KEY, " +
                                 "Emp_Name TEXT, " +
                                 "Basicsalary INTEGER)");
        createStmt.close();

        if (startLetter != null && !startLetter.trim().isEmpty()) {
            String deleteSQL = "DELETE FROM Emp WHERE Emp_Name LIKE ?";
            pstmt = conn.prepareStatement(deleteSQL);
            pstmt.setString(1, startLetter + "%");
            int deletedRows = pstmt.executeUpdate();
            out.println("<p style='color:green; font-weight:bold;'>Deleted " + deletedRows + 
                        " employee(s) whose name starts with '" + startLetter.toUpperCase() + "'</p>");
            pstmt.close();
        }

        // Now display report for all remaining employees
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM Emp ORDER BY Emp_NO");

        out.println("<h2>Salary Report</h2>");
        boolean hasRecords = false;
        while (rs.next()) {
            hasRecords = true;
            out.println("<hr>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>");
            out.println("Emp_No     : " + rs.getInt("Emp_NO") + "<br>");
            out.println("Emp_Name   : " + rs.getString("Emp_Name") + "<br>");
            out.println("Basic      : " + rs.getInt("Basicsalary") + "<br>");
        }
        if (!hasRecords) {
            out.println("<p>No employees found.</p>");
        }
        out.println("<hr>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    } catch (Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (stmt != null) stmt.close(); } catch (Exception e) {}
        try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }
%>

</body>
</html>
