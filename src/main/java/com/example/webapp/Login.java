package com.example.webapp;


import javax.ws.rs.*;
import java.sql.*;
import java.util.Properties;

@Path("/login")
public class Login {
    @POST
    @Produces("text/plain")
    public String login(@FormParam("usr") String usr, @FormParam("pwd") String pwd) {
        StringBuilder msg= new StringBuilder("Trying to connect...");
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            Properties props = new Properties();
            props.setProperty("user","postgres");
            props.setProperty("password","admin");
            //props.setProperty("ssl","false");
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, props);
            PreparedStatement st = conn.prepareStatement("SELECT * FROM users WHERE name = ? and password = ?");
            st.setString(1,usr);
            st.setString(2,pwd);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                msg.append("Hello, " + rs.getString(2) + "! You've successfully logged in!");
            }
        } catch (SQLException e) {System.out.println(e.getMessage());} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return msg.toString();
    }
}
