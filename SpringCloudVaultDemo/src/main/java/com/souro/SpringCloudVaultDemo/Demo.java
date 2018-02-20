/**
 * 
 */
package com.souro.SpringCloudVaultDemo;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sourabrata
 *
 */

@SpringBootApplication
public class Demo {
	@Value("${spring.profiles.active:#{null}}")
    private String profiles;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${other.username}")
    private String other;

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);
    }

    @PostConstruct
	private void postConstruct() throws SQLException {
		System.out.println("##########################");
        System.out.println("profile(s): " + profiles);
        System.out.println("username: " + username);
        System.out.println("password: " + password);
		System.out.println("other: " + other);

		dataSource.getConnection();
        System.out.println("Successfully connected to database");
        System.out.println("##########################");

        /*isTrue (!username.equals("to-be-overwritten-by-vault-value"), "Username " + username);
        isTrue (!password.equals("to-be-overwritten-by-vault-value"), "Password " + password);*/
    }
}
