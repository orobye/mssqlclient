package by.bockroir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector implements java.lang.AutoCloseable {
    private Connection conn;
    
    public Connector(String host, String port, String databaseName, String username, String password){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.conn = DriverManager.getConnection(
                                String.format("jdbc:sqlserver://%s:%s;databaseName=%s",host, port, databaseName),
                                                                username, password);
            
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public Connection getConnection(){  return this.conn; }
    
    public void close() throws SQLException{
        this.conn.close();
    }
}
