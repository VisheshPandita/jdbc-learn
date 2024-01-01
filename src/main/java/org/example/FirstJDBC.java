package org.example;

import java.sql.*;

public class FirstJDBC {
    public static void main(String[] args) {
        try{
            // load the driver
            Class.forName("org.postgresql.Driver");

            // creating a connection
            String url = "jdbc:postgresql://localhost:5432/vishesh";
            String username = "vishesh";
            String password = "password";

            Connection con = DriverManager.getConnection(url, username, password);

            if(con.isClosed()){
                System.out.println("Connection is Closed");
            }else{
                System.out.println("Connection Created");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}