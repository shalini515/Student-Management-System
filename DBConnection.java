package db;
import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "yourpassword");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
