<!-- 8b. Read all the existing records from the table coffee which is from the database test and update
an existing coffee product in the table with its id. -->

<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Coffee Price</title>
</head>
<body>

<h2>Update Coffee Price</h2>

<%
    String updateId = request.getParameter("id");
    String newPrice = request.getParameter("price");

    String dbPath = application.getRealPath("/") + "WEB-INF/test.db";
    String dbURL = "jdbc:sqlite:" + dbPath;

    // Step 1: Update price if form submitted
    if (updateId != null && newPrice != null) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection(dbURL);

            String updateQuery = "UPDATE coffee SET price = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(updateQuery);
            ps.setInt(1, Integer.parseInt(newPrice));
            ps.setInt(2, Integer.parseInt(updateId));
            int rows = ps.executeUpdate();

            if (rows > 0) {
                out.println("<p style='color:green;'>Coffee with ID " + updateId + " updated successfully!</p>");
            } else {
                out.println("<p style='color:red;'>No coffee found with ID " + updateId + ".</p>");
            }

            ps.close();
            con.close();
        } catch (Exception e) {
            out.println("<p style='color:red;'>Update Error: " + e.getMessage() + "</p>");
        }
    }
%>

<!-- Step 2: Show form to update coffee -->
<form method="post">
    Coffee ID to Update: <input type="number" name="id" required><br>
    New Price: <input type="number" name="price" required><br>
    <input type="submit" value="Update Price">
</form>

<hr>
<h2>All Coffee Records</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Coffee Name</th>
        <th>Price</th>
    </tr>
<%
    // Step 3: Display all records
    try {
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(dbURL);
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
    } catch (Exception e) {
        out.println("<p style='color:red;'>Display Error: " + e.getMessage() + "</p>");
    }
%>
</table>

</body>
</html>
