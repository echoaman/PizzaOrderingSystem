import java.rmi.*;

public class ServerB {
    public static void main(String[] args) {
        System.out.println("Server B\n");
        try {
            ServerInterface serv = new Server();
            Naming.rebind("serverB", serv);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
