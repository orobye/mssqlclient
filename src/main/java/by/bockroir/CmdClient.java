package by.bockroir;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CmdClient {
    private Connection conn;
    
    public void setConnection(Connection conn){
        this.conn = conn;
    }
    
    public void runClient() throws SQLException{
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        
        while (!command.equals("exit")){
            Statement stmt = conn.createStatement();
            stmt.execute(command);
            ResultSet rs = stmt.getResultSet();
            if (rs != null){
                while (rs.next()) {
                    System.out.println(rs.getString(1));
                }
            }
        }
    }
}
