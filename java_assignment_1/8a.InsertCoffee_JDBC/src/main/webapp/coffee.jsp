<!-- 8a. Q1. Read all the existing records from the table coffee which is from the database test and insert a
new coffee product into it -->


<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Coffee Records</title>
</head>
<body>

<%
    String name = request.getParameter("coffee_name");
    String price = request.getParameter("price");

    String dbPath = application.getRealPath("/") + "WEB-INF/test.db";
    Connection con = null;

    try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:" + dbPath);

        // Create table if not exists
        Statement createStmt = con.createStatement();
        createStmt.execute("CREATE TABLE IF NOT EXISTS coffee (id INTEGER PRIMARY KEY AUTOINCREMENT, coffee_name TEXT NOT NULL, price INTEGER NOT NULL)");

        if (name != null && price != null) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO coffee (coffee_name, price) VALUES (?, ?)");
            ps.setString(1, name);
            ps.setInt(2, Integer.parseInt(price));
            ps.executeUpdate();
            ps.close();
        }
    } catch (Exception e) {
        out.println("<p style='color:red;'>Insert Error: " + e.getMessage() + "</p>");
    }
%>

<h2>Coffee Records</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Coffee Name</th>
        <th>Price</th>
    </tr>
    <%
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM coffee");

            while(rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("coffee_name") + "</td>");
                out.println("<td>" + rs.getInt("price") + "</td>");
                out.println("</tr>");
            }

            rs.close();
            con.close();
        } catch(Exception e) {
            out.println("<p style='color:red;'>Display Error: " + e.getMessage() + "</p>");
        }
    %>
</table>

<h3>Add New Coffee</h3>
<form method="post">
    Coffee Name: <input type="text" name="coffee_name" required /><br>
    Price: <input type="number" name="price" required /><br>
    <input type="submit" value="Add Coffee" />
</form>

</body>
</html>
