/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connector {
    static Connection con;
        
    public static Connection connection(){
        if(con == null){
            String url = "jdbc:mysql://localhost:3306/movie_db";
            String user = "root";
            String password = "";

            try {
                con = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to the database!");
            } catch (SQLException e) {
                System.out.println("Connection failed!");
                e.printStackTrace();
            }
        }
        
        return con;
    }
    

}
