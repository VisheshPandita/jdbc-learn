package org.example;

import java.sql.*;

public class InsertComplexJDBC {
    public static void main(String[] args) {
        try{
            // load the driver
            Class.forName("org.postgresql.Driver");

            // creating a connection
            String url = "jdbc:postgresql://localhost:5432/jdbc";
            String username = "vishesh";
            String password = "password";

            Connection con = DriverManager.getConnection(url, username, password);

            // create query
            String q = """
                    insert into table1(tName,tCity) values (?,?)
                    """;

            PreparedStatement pstmt = con.prepareStatement(q);

            pstmt.setString(1, "Vishesh Pandta");
            pstmt.setString(2, "Delhi");

            pstmt.executeUpdate();

            System.out.println("inserted ....");

            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
