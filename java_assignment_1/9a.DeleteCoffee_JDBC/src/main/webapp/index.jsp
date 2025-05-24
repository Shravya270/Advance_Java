<!-- 9a. Read all the existing records from the table coffee which is from the database test and delete
an existing coffee product from the table with its id. -->


<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Manage Coffee Records - SQLite</title>
</head>
<body>
    <h2>Coffee Records - SQLite Dynamic Delete</h2>

    <!-- Form to enter the ID to delete -->
    <form method="post">
        <label>Enter Coffee ID to Delete:</label>
        <input type="text" name="deleteId" required />
        <input type="submit" value="Delete" />
    </form>

<%
    Connection conn = null;
    try {
        String dbPath = application.getRealPath("/WEB-INF/coffee_records.db");
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
        out.println("<p style='color:green;'>Connected to SQLite database: coffee_records.db</p>");

        Statement stmt = conn.createStatement();

        // Create coffee table if not exists
        stmt.executeUpdate(
            "CREATE TABLE IF NOT EXISTS coffee (" +
            "id INTEGER PRIMARY KEY, " +
            "coffee_name TEXT, " +
            "price INTEGER)"
        );

        // Check if coffee table is empty, insert sample data if it is
        ResultSet rsCheck = stmt.executeQuery("SELECT COUNT(*) AS total FROM coffee");
        if (rsCheck.next() && rsCheck.getInt("total") == 0) {
            stmt.executeUpdate("INSERT INTO coffee (id, coffee_name, price) VALUES (1, 'Espresso', 100)");
            stmt.executeUpdate("INSERT INTO coffee (id, coffee_name, price) VALUES (2, 'Latte', 120)");
            stmt.executeUpdate("INSERT INTO coffee (id, coffee_name, price) VALUES (3, 'Cappuccino', 130)");
            stmt.executeUpdate("INSERT INTO coffee (id, coffee_name, price) VALUES (4, 'Americano', 110)");
            stmt.executeUpdate("INSERT INTO coffee (id, coffee_name, price) VALUES (5, 'Mocha', 150)");
            out.println("<p style='color:blue;'>Inserted sample coffee records.</p>");
        }
        rsCheck.close();

        // Process delete request
        String idStr = request.getParameter("deleteId");
        if (idStr != null && !idStr.trim().isEmpty()) {
            try {
                int deleteId = Integer.parseInt(idStr.trim());
                String deleteQuery = "DELETE FROM coffee WHERE id = ?";
                PreparedStatement pst = conn.prepareStatement(deleteQuery);
                pst.setInt(1, deleteId);
                int rowsDeleted = pst.executeUpdate();
                if (rowsDeleted > 0) {
                    out.println("<p style='color:blue;'>Successfully deleted record with ID: " + deleteId + "</p>");
                } else {
                    out.println("<p style='color:red;'>No record found with ID: " + deleteId + "</p>");
                }
                pst.close();
            } catch (NumberFormatException e) {
                out.println("<p style='color:red;'>Invalid ID format. Please enter a valid number.</p>");
            }
        }

        // Display current coffee records
        ResultSet rs = stmt.executeQuery("SELECT * FROM coffee ORDER BY id");
        out.println("<h3>Current Coffee Records:</h3>");
        out.println("<table border='1' cellpadding='5'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Price</th></tr>");
        while (rs.next()) {
            out.println("<tr>");
            out.println("<td>" + rs.getInt("id") + "</td>");
            out.println("<td>" + rs.getString("coffee_name") + "</td>");
            out.println("<td>" + rs.getInt("price") + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        rs.close();
        stmt.close();

    } catch (Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
    } finally {
        if (conn != null) try { conn.close(); } catch (Exception e) {}
    }
%>
</body>
</html>

