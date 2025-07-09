<%@ page import="java.sql.*, db.DBConnection" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE id=?");
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    rs.next();
%>

<form action="edit" method="post">
    <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
    Name: <input type="text" name="name" value="<%= rs.getString("name") %>"><br>
    Email: <input type="email" name="email" value="<%= rs.getString("email") %>"><br>
    Course: <input type="text" name="course" value="<%= rs.getString("course") %>"><br>
    <input type="submit" value="Update Student">
</form>
