package by.bockroir;

import java.sql.Connection;

public class CmdClient {
    private Connection conn;
    
    public void setConnection(Connection conn){
        this.conn = conn;
    }
}
