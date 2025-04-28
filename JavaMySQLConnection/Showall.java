import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Showall {
    public static void retrieveAll(Connection conn, Scanner scanner) {
        try {
            String sql = "SELECT id, name, course FROM students";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet resultSet = stmt.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("No students found.");
            } else {
                System.out.println("💡 All Students:");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String course = resultSet.getString("course");

                    System.out.println("ID: " + id + " | Name: " + name + " | Course: " + course);
                }
            }
        } catch (SQLException e) {
            System.out.println("❌ Error retrieving students: " + e.getMessage());
        }
    }
}