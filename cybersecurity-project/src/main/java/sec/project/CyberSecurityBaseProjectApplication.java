package sec.project;

import java.sql.Connection;
import java.sql.DriverManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CyberSecurityBaseProjectApplication {

    public static void main(String[] args) throws Throwable {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:./database", "sa", "")) {
            conn.prepareStatement("DROP TABLE User IF EXISTS;").executeUpdate();
            conn.prepareStatement("CREATE TABLE User ("
                    + "username VARCHAR(50) PRIMARY KEY, password VARCHAR(30));").executeUpdate();
            conn.close();
        }
        SpringApplication.run(CyberSecurityBaseProjectApplication.class);
    }
}
