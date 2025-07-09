package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import db.DBConnection;

public class ViewStudentsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try (Connection conn = DBConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            out.println("<h2>Student List</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Course</th><th>Actions</th></tr>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("course") + "</td>");
                out.println("<td><a href='edit-student.jsp?id=" + rs.getInt("id") + "'>Edit</a> | " +
                            "<a href='delete?id=" + rs.getInt("id") + "'>Delete</a></td>");
                out.println("</tr>");
            }

            out.println("</table>");
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println("<br><a href='index.jsp'>Home</a>");
    }
}
