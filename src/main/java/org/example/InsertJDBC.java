package org.example;

import java.sql.*;

public class InsertJDBC {
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
                    create table table1(
                    tId serial primary key,
                    tName varchar(200) not null,
                    tCity varchar(400)
                    )
                    """;

            // create statement
            Statement stmt = con.createStatement();
            stmt.executeUpdate(q);

            System.out.println("table created  in database");

            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
