import java.rmi.*;

public class ServerA {
    public static void main(String[] args) {
        System.out.println("Server A\n");
        try {
            ServerInterface serv = new Server();
            Naming.rebind("serverA", serv);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
