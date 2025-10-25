package labs.sast.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Intentionally vulnerable example for SAST demo.
 * DO NOT USE IN PRODUCTION.
 */
public class UnsafeSqlExample {
    public static void main(String[] args) throws Exception {
        String userInput = args.length > 0 ? args[0] : "admin";
        // Vulnerable: concatenating user input into SQL
        String sql = "SELECT * FROM users WHERE username='" + userInput + "'";

        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:test")) {
            try (Statement st = conn.createStatement()) {
                st.execute("CREATE TABLE users (id INT PRIMARY KEY, username VARCHAR(255))");
                st.execute("INSERT INTO users VALUES (1, 'admin')");
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    System.out.println("Found user: " + rs.getString("username"));
                }
            }
        }
    }
}
