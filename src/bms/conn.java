package bms;

import java.sql.*;

public class conn {

    Connection c;
    Statement s;

    @SuppressWarnings("UseSpecificCatch")
    public conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///project", "root", "");
            s = c.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}