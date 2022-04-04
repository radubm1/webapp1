package com.example.webapp;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.sql.*;
import java.util.Properties;

@Path("/login")
public class Login {
    @POST
    @Produces("text/plain")
    public String login(@QueryParam("usr") String usr, @QueryParam("pwd") String pwd) {
        String msg="Trying to connect...";
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            Properties props = new Properties();
            props.setProperty("user","postgres");
            props.setProperty("password","admin");
            //props.setProperty("ssl","false");
            Connection conn = DriverManager.getConnection(url, props);
            PreparedStatement st = conn.prepareStatement("SELECT * FROM users WHERE name = ? and password = ?");
            st.setString(1,usr);
            st.setString(2,pwd);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                msg="Hello, " + rs.getString(2) + "! You've successfully logged in!";
            }
            rs.close();
            st.close();
        } catch (SQLException e) {System.out.println(e.getMessage());}
        return msg;
    }
}
