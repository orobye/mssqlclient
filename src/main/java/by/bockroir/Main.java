package by.bockroir;

public class Main {
    public static void main(String[] args) {
        try (Connector connector = new Connector("192.168.1.4", "1433", "CKRO", "polystat", "8095461");){
            CmdClient cmdClient = new CmdClient();
            cmdClient.setConnection(connector.getConnection());
        }
    }
}
