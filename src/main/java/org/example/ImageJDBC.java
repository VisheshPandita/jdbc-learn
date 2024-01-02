package org.example;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ImageJDBC {
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
                    insert into images(pic) values(?)
                    """;

            // create statement
            PreparedStatement pstmt = con.prepareStatement(q);

            FileInputStream fis = new FileInputStream("path/to/image");
            pstmt.setBinaryStream(1, fis, fis.available());

            pstmt.executeUpdate();

            System.out.println("done ....");

            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
