<!--9b. Read all the existing records from the table coffee which is from the database test and query
coffee name starting with ‘D’ in the table.-->

<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Query Coffee Records - SQLite</title>
</head>
<body>
    <h2>All Coffee Records in the Database (SQLite)</h2>
<%
    Connection conn = null;
    try {
        // Path to your SQLite database file inside WEB-INF
        String dbPath = application.getRealPath("/") + "WEB-INF/coffee_records.db";
        
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath);

        out.println("<p style='color:green;'>Connected to SQLite database: coffee_records.db</p>");

        // Display all records
        Statement stmtAll = conn.createStatement();
        ResultSet rsAll = stmtAll.executeQuery("SELECT * FROM coffee");

        out.println("<h3>All Coffee Records:</h3>");
        out.println("<table border='1' cellpadding='5'><tr><th>ID</th><th>Name</th><th>Price</th></tr>");
        while (rsAll.next()) {
            out.println("<tr>");
            out.println("<td>" + rsAll.getInt("id") + "</td>");
            out.println("<td>" + rsAll.getString("coffee_name") + "</td>");
            out.println("<td>" + rsAll.getInt("price") + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        rsAll.close();
        stmtAll.close();

        // Query coffee names starting with 'D'
        out.println("<h3>Coffee Records Starting with 'D'</h3>");
        String query = "SELECT * FROM coffee WHERE coffee_name LIKE 'D%'";
        Statement stmtFilter = conn.createStatement();
        ResultSet rsFilter = stmtFilter.executeQuery(query);

        out.println("<table border='1' cellpadding='5'><tr><th>ID</th><th>Name</th><th>Price</th></tr>");
        while (rsFilter.next()) {
            out.println("<tr>");
            out.println("<td>" + rsFilter.getInt("id") + "</td>");
            out.println("<td>" + rsFilter.getString("coffee_name") + "</td>");
            out.println("<td>" + rsFilter.getInt("price") + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        rsFilter.close();
        stmtFilter.close();

    } catch (Exception e) {
        out.println("<p style='color:red;'>Exception: " + e.getMessage() + "</p>");
    } finally {
        if (conn != null) try { conn.close(); } catch (Exception e) {}
    }
%>
</body>
</html>
