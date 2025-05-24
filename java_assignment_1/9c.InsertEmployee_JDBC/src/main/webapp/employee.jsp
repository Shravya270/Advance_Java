<!-- 9c. Develop a JDBC project using MySQL to append the fields empno, empname and basicsalary
into the table Emp of the database Employee by getting the fields through keyboard and Generate
the report as follows for the table Emp (Emp_NO , Emp_Name, Basicsalary ) using HTML and JSP
to get the field and display the results respectively -->

<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Employee Management - Insert and Report (SQLite)</title>
</head>
<body>

<h2>Enter Employee Details</h2>
<form method="post">
  Emp No: <input type="text" name="empno" required/><br/><br/>
  Emp Name: <input type="text" name="empname" required/><br/><br/>
  Basic Salary: <input type="text" name="salary" required/><br/><br/>
  <input type="submit" value="Insert Employee"/>
</form>

<%
    Connection conn = null;
    try {
        String dbPath = application.getRealPath("/WEB-INF/employee.db");
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath);

        // Create table if not exists
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Emp (" +
                           "Emp_NO INTEGER PRIMARY KEY, " +
                           "Emp_Name TEXT, " +
                           "Basicsalary INTEGER)");
        stmt.close();

        if(request.getParameter("empno") != null && request.getMethod().equalsIgnoreCase("POST")) {
            try {
                int empno = Integer.parseInt(request.getParameter("empno"));
                String empname = request.getParameter("empname");
                int salary = Integer.parseInt(request.getParameter("salary"));

                String insertQuery = "INSERT INTO Emp (Emp_NO, Emp_Name, Basicsalary) VALUES (?, ?, ?)";
                PreparedStatement pst = conn.prepareStatement(insertQuery);
                pst.setInt(1, empno);
                pst.setString(2, empname);
                pst.setInt(3, salary);

                int inserted = pst.executeUpdate();
                if(inserted > 0) {
                    out.println("<p style='color:green; font-weight:bold;'>Employee inserted successfully.</p>");
                }
                pst.close();
            } catch(NumberFormatException nfe) {
                out.println("<p style='color:red;'>Emp No and Salary must be valid numbers.</p>");
            } catch(SQLException sqle) {
                out.println("<p style='color:red;'>Database error: " + sqle.getMessage() + "</p>");
            }
        }

        // Display all employee records as report
        Statement reportStmt = conn.createStatement();
        ResultSet rs = reportStmt.executeQuery("SELECT * FROM Emp ORDER BY Emp_NO");

        out.println("<hr>");
        out.println("<h2>Employee Report</h2>");
        out.println("<table border='1' cellpadding='5' cellspacing='0'>");
        out.println("<tr><th>Emp No</th><th>Emp Name</th><th>Basic Salary</th></tr>");

        boolean hasRecords = false;
        while(rs.next()) {
            hasRecords = true;
            out.println("<tr>");
            out.println("<td>" + rs.getInt("Emp_NO") + "</td>");
            out.println("<td>" + rs.getString("Emp_Name") + "</td>");
            out.println("<td>" + rs.getInt("Basicsalary") + "</td>");
            out.println("</tr>");
        }

        if (!hasRecords) {
            out.println("<tr><td colspan='3'>No employee records found.</td></tr>");
        }

        out.println("</table>");

        rs.close();
        reportStmt.close();

    } catch(Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
    } finally {
        if(conn != null) try { conn.close(); } catch(Exception e) {}
    }
%>

</body>
</html>