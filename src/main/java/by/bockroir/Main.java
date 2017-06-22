package by.bockroir;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());
    
    public static void main(String[] args) throws IOException {
//        System.out.println(String.format( Commands.SHOW_COLUMNS.toString(), "!"));

        if (args.length < 5){
            System.out.println("pass args: HOST PORT DATABASE_NAME USERNAME PASSWORD");
            return;        
            }
        
        try (Connector connector = new Connector(args[0], args[1], args[2], args[3], args[4]);){
            CmdClient cmdClient = new CmdClient();
            cmdClient.setConnection(connector.getConnection());
            logger.info("Connection OK");
            cmdClient.runClient();
        } catch (SQLException e){
            e.printStackTrace();
            return;
        }
    }
}
