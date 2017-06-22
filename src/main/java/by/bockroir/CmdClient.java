package by.bockroir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class CmdClient {
    private Connection conn;

    // TODO: command to show all tables "showTables"
    // TODO: add command "showColumnsNames"

    public void setConnection(Connection conn){
        this.conn = conn;
    }
    
    public void runClient() throws SQLException, IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
        
        while (!command.equals("exit")){
            if (command.equals("showTables")) {
                command = Commands.SHOW_TABLES.toString();
            } else if (command.equals("showColumns")) {
                command = String.format(Commands.SHOW_COLUMNS.toString(), reader.readLine());
            }

            Statement stmt = conn.createStatement();
            try {
                stmt.execute(command);
            } catch (Exception e) {
                System.err.println("Wrong command. Exception: " + e);
            }
            ResultSet rs = stmt.getResultSet();
            if (rs != null){
                while (rs.next()) {
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        System.out.print("| ");
                        System.out.print(rs.getString(i));
                    }
                    System.out.println();
                }
            }
            command = reader.readLine();
        }
    }
}
