package org.playground_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class App {
    public String getGreeting() {
        return "Hello from SQL Playground!";
    }   

    public static void main(String args[]) {
        System.out.println("Let's start testing...!");

        Map<String, String> env = System.getenv(); 

        final String POSTGRES_DBNAME = env.get("POSTGRES_DATABASE");
        final String POSTGRES_USER = env.get("POSTGRES_USER");
        final String POSTGRES_PASSWORD = env.get("POSTGRES_PASSWORD");
        final int POSTGRES_PORT = 5432;

        Properties connProperties = new Properties();
        connProperties.put("user", POSTGRES_USER);
        connProperties.put("password", POSTGRES_PASSWORD);
        connProperties.put("ssl", false);

        List<String> columns = Arrays.asList("id", "date_prod", "title", "genre", "duration", "director");

        // NOTE: The path to the JAR with the PostgreSQL driver needs to be explitly added to CLASSPATH
        //       export CLASSPATH="/usr/share/java/postgresql-42.7.2.jar:."
        //       Gradle can handle this automatically when pulling the driver as a dependency.
        String dbUrl = String.format(
            "jdbc:postgresql://localhost:%d/%s",
            POSTGRES_PORT,
            POSTGRES_DBNAME
        );
        System.out.println("Connecting to database via URL: " + dbUrl);

        try (Connection conn = DriverManager.getConnection(dbUrl, connProperties)) {
            String query = "SELECT * FROM films";
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery(query)) {
                    // NOTE: The core implementation of JDBC does not support returning complete rows
                    //       Nor does it have any inspection properties to know column names
                    int recordId = 1;
                    while (rs.next()) {
                        System.out.println(String.format("Returned record %d: ", recordId));
                        for (String col : columns) {
                            System.out.println(String.format("'%s' : '%s'", col, rs.getString(col)));
                        }
                        ++recordId;
                    }
                }
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }   
}
