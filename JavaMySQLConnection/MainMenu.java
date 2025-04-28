import java.sql.Connection;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (Connection conn = DatabaseConnection.getConnection()) {
            String choice;
            do {
                System.out.println("\n--- Main Menu ---");
                System.out.println("1. Show all students");
                System.out.println("2. Search for a student");
                System.out.println("3. Insert a new student");
                System.out.println("4. Update student information");
                System.out.println("5. Delete a student");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1" -> Showall.retrieveAll(conn, scanner); // Ensure 'showall' is properly defined
                    case "2" -> hanapin.retrieve(conn, scanner); // Ensure 'hanapin' is properly defined
                    case "3" -> InsertStudent.main(new String[] {}); // Ensure InsertStudent is implemented
                    case "4" -> UpdateStudent.main(new String[] {}); // Ensure UpdateStudent is implemented
                    case "5" -> DeleteStudent.main(new String[] {}); // Ensure DeleteStudent is implemented
                    case "6" -> System.out.println("Exiting the program. Goodbye!");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } while (!choice.equals("6"));
        } catch (Exception e) {
            System.out.println("❌ Connection failed: " + e.getMessage());
        } finally {
            scanner.close(); // Close the scanner resource
        }
    }
}