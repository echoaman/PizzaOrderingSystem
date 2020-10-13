import java.rmi.*;

public class ServerA {
    public static void main(String[] args) {
        try {
            ServerInterface serv = new Server();
            Naming.rebind("serverA", serv);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
