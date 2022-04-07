package com.example.webapp;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@ApplicationPath("/api")
public class LoginApplication extends Application {
public static Connection getConnection() throws SQLException, ClassNotFoundException {
    String url = "jdbc:postgresql://localhost:5432/postgres";
    Properties props = new Properties();
    props.setProperty("user","postgres");
    props.setProperty("password","admin");
    //props.setProperty("ssl","false");
    Class.forName("org.postgresql.Driver");
    return DriverManager.getConnection(url, props);
}
}